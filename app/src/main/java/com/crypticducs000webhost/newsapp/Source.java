package com.crypticducs000webhost.newsapp;

import java.util.List;

/**
 * Created by Hp on 1/20/2018.
 */
class UrlsToLogs{
    private String small, medium,large;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}

public class Source {
    private String id;
    private String name;
    private String discription;
    private String url;
    private String category;
    private String language;
    private String country;
    private UrlsToLogs urlsToLogs;
    private List<String> sortBysAvailable;

    public Source() {
    }

    public Source(String id, String name, String discription, String url, String category, String language, String country, UrlsToLogs urlsToLogs, List<String> sortByAvailable) {
        this.id = id;
        this.name = name;
        this.discription = discription;
        this.url = url;
        this.category = category;
        this.language = language;
        this.country = country;
        this.urlsToLogs = urlsToLogs;
        this.sortBysAvailable = sortBysAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UrlsToLogs getUrlsToLogs() {
        return urlsToLogs;
    }

    public void setUrlsToLogs(UrlsToLogs urlsToLogs) {
        this.urlsToLogs = urlsToLogs;
    }

    public List<String> getSortBysAvailable() {
        return sortBysAvailable;
    }

    public void setSortBysAvailable(List<String> sortByAvailable) {
        this.sortBysAvailable = sortByAvailable;
    }
}
