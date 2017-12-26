package com.greg.slackstack.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {

    @JsonProperty("reputation")
    public Integer reputation;
    @JsonProperty("user_id")
    public Integer userId;
    @JsonProperty("user_type")
    public String userType;
    @JsonProperty("profile_image")
    public String profileImage;
    @JsonProperty("display_name")
    public String displayName;
    @JsonProperty("link")
    public String link;

    public Owner() {
    }


    @Override
    public String toString() {
        return "Owner:\ndisplay name: " + displayName +
                "\nreputation: " + reputation+
                "\nuser id: " + userId+
                "\nlink: " + link;

    }
}

