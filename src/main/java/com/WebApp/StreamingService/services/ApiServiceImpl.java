package com.WebApp.StreamingService.services;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;
@Service
public class ApiServiceImpl implements ApiService {
    private static final String API_KEY = "2fa0c86253msh27c51dc8cf35e30p154ddejsnf23dbb811fa1";
    private static final String API_HOST = "imdb146.p.rapidapi.com";
    private static final String BASE_URL = "https://imdb146.p.rapidapi.com/v1/find/?query=";

    private String makeApiRequest(String query) {
            HttpResponse<String> response = Unirest.get(BASE_URL + query)
                    .header("X-RapidAPI-Key", API_KEY)
                    .header("X-RapidAPI-Host", API_HOST)
                    .asString();
            return response.getBody();
    }

    @Override
    public String fetchData(String query) {
        return makeApiRequest(query);
    }

    @Override
    public String fetchTitleDetails(String id) {
        return makeApiRequest(id);
    }

    @Override
    public String fetchNameDetails(String id) {
        return makeApiRequest(id);
    }

    @Override
    public String fetchVideoDetails(String id) {
        return makeApiRequest(id);
    }

    @Override
    public String fetchNewsDetails(String id) {
        return makeApiRequest(id);
    }
}
