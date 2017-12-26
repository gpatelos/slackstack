package com.greg.slackstack.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wrapper {

    @JsonProperty("items")
    public ArrayList<Item> items;
    @JsonProperty("has_more")
    public Boolean hasMore;
    @JsonProperty("quota_max")
    public Integer quotaMax;
    @JsonProperty("quota_remaining")
    public Integer quotaRemaining;

    public Wrapper() {
    }

    public ArrayList<Item> getItem() {
        return items;
    }

    public void setItem(ArrayList<Item> item) {
        this.items = item;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(Integer quotaMax) {
        this.quotaMax = quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(Integer quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

    @Override
    public String toString() {

        return "Item: " + items;
    }
}
