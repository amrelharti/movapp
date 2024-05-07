package com.WebApp.StreamingService.services;

public interface ApiService {
    String fetchData(String query);
    String fetchTitleDetails(String Id);
     String fetchNameDetails(String Id);
    String fetchVideoDetails(String Id);
    public String fetchNewsDetails( String Id);

}
