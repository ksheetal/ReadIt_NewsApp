package com.crypticducs000webhost.newsapp;



import java.util.List;

/**
 * Created by Hp on 1/20/2018.
 */


public class IconBetterIdea {
    private String url;
    private List<Icon> icons;

    public IconBetterIdea() {
    }

    public IconBetterIdea(String url, List<Icon> icons) {
        this.url = url;
        this.icons = icons;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Icon> getIcons() {
        return icons;
    }

    public void setIcons(List<Icon> icons) {
        this.icons = icons;
    }   //set chnaged into get
}