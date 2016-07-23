package com.alekseyld.tasklist.data;

import com.alekseyld.tasklist.BuildConfig;

import java.io.IOException;
import java.net.URI;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * Created by Alekseyld on 21.07.2016.
 */
public class FakeInterceptor implements Interceptor {
    // FAKE RESPONSES.
    private final static String TEACHER_ID_1 = "{\"id\":1,\"age\":28,\"name\":\"Victor Apoyan\"}";
    private final static String TEACHER_ID_2 = "{\"id\":1,\"age\":16,\"name\":\"Tovmas Apoyan\"}";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = null;
        if(BuildConfig.DEBUG) {
            String responseString;
            // Get Request URI.
            final HttpUrl uri = chain.request().url();
            // Get Query String.
            final String query = uri.query();
            // Parse the Query String.
            final String[] parsedQuery = query.split("=");

            if(parsedQuery[0].equalsIgnoreCase("id") && parsedQuery[1].equalsIgnoreCase("1")) {
                responseString = TEACHER_ID_1;
            }
            else if(parsedQuery[0].equalsIgnoreCase("id") && parsedQuery[1].equalsIgnoreCase("2")){
                responseString = TEACHER_ID_2;
            }
            else {
                responseString = "";
            }

            response = new Response.Builder()
                    .code(200)
                    //Response
                    .message(responseString)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                    .addHeader("content-type", "application/json")
                    .build();
        }
        else {
            response = chain.proceed(chain.request());
        }

        return response;
    }
}
