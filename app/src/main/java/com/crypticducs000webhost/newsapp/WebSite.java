package com.crypticducs000webhost.newsapp;

import java.util.List;

/**
 * Created by Hp on 1/20/2018.
 */

public class WebSite {
    private String status;
    private List<Source> sources;

    public WebSite(String status) {
        this.status = status;
    }

    public WebSite(String status, List<Source> sources) {
        this.status = status;
        this.sources = sources;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
