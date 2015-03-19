package cn.edu.sjtu.se.dclab.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vote {
    private long id;
    private String vote_title;
    private String vote_detail; 
    private String vote_choice; 
    private String vote_choice_limit;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVote_title() {
        return vote_title;
    }

    public void setVote_title(String vote_title) {
        this.vote_title = vote_title;
    }
    
    public String getVote_detail() {
        return vote_detail;
    }

    public void setVote_detail(String vote_detail) {
        this.vote_detail = vote_detail;
    }
    
    public String getVote_choice() {
        return vote_choice;
    }

    public void setVote_choice(String vote_choice) {
        this.vote_choice = vote_choice;
    }
    
    public String getVote_choice_limit() {
        return vote_choice_limit;
    }

    public void setVote_choice_limit(String vote_choice_limit) {
        this.vote_choice_limit = vote_choice_limit;
    }

    
}
