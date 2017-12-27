package com.greg.slackstack.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @JsonProperty("tags")
    public ArrayList<String> tags;
    @JsonProperty("owner")
    public Owner owner;
    @JsonProperty("is_answered")
    public Boolean isAnswered;
    @JsonProperty("view_count")
    public Integer viewCount;
    @JsonProperty("answer_count")
    public Integer answerCount;
    @JsonProperty("score")
    public Integer score;
    @JsonProperty("question_id")
    public Integer questionId;
    @JsonProperty("link")
    public String link;
    @JsonProperty("title")
    public String title;

    public Item() {
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getAnswered() {
        return isAnswered;
    }

    public void setAnswered(Boolean answered) {
        isAnswered = answered;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Item parsed to ->\nquestionId: " + questionId +
                "\nisAnswered: " + isAnswered +
                "\ntags: " + tags+
                "\nowner: " + owner +
                "\nscore: " + score +
                "\nlink: " + link +
                "\ntitle: " + title;
    }
}

