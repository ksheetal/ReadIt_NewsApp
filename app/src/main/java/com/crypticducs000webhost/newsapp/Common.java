package com.crypticducs000webhost.newsapp;

/**
 * Created by Hp on 1/20/2018.
 */

public class Common {
    private static final String BASE_URL="https://newsapi.org/";

  //  public static final String API_KEY="fbbd2d7b042f40279845179ed4529ae3";  //SHEETAL API
    public static final String API_KEY="38452b3dbdc64b5aba76dc73c70fe3d1";

    public static NewsService getNewsService()
    {
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService()
    {
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }

    public static String getApiUrl(String source,String sortBy,String api_key){
        StringBuilder apiUrl=new StringBuilder("https://newsapi.org/v1/articles?source=");
        return apiUrl.append(source)
                .append("&sortBy=")
                .append(sortBy)
                .append("&apiKey=")
                .append(api_key).toString();
    }
}
