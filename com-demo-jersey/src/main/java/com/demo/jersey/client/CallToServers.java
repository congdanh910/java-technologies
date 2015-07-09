package com.demo.jersey.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import org.apache.commons.lang.StringUtils;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;
import java.util.Map;

/**
 * Created by danh.ho on 09/07/2015.
 */
public class CallToServers {

    private static Integer connectionTimeout = 30000;
    private static Integer readTimeout = 30000;
    private static Boolean followRedirects = true;


    public static String get(String url, MultivaluedMap<String, String> queryParams, Map<String, Object> headers) {
        String result = StringUtils.EMPTY;

        // preparing something for client request
        Client client = getClient();
        WebResource webResource = client.resource(url);
        Builder webResourceBuilder;

        //adding the parameters if we need
        if (queryParams != null) {
            webResourceBuilder = webResource.queryParams(queryParams).getRequestBuilder();
        } else {
            webResourceBuilder = webResource.getRequestBuilder();
        }

        //adding the header if we need
        addHeaders(headers, webResourceBuilder);

        //preparing something to get the response
        ClientResponse clientResponse = webResourceBuilder.get(ClientResponse.class);
        result = clientResponse.getEntity(String.class);
        return result;
    }

    private static Client getClient() {
        Client client = new Client();
        client.setConnectTimeout(connectionTimeout);
        client.setReadTimeout(readTimeout);
        client.setFollowRedirects(followRedirects);
        return client;
    }

    private static void addHeaders(Map<String, Object> headers, Builder builder) {
        if (headers != null) {
            for (Map.Entry<String, Object> entry : headers.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        String url = "http://localhost:8080/rest/hello/infoJson/";
        String name = "Danh";
        String urlBuilder = UriBuilder.fromUri(url).path("{name}").build(name).toString();

        System.out.println("urlBuilder : " + urlBuilder);

        String data = CallToServers.get(urlBuilder, null, null);

        System.out.println("data : " + data);

    }


}
