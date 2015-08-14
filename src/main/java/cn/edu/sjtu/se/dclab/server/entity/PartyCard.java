package cn.edu.sjtu.se.dclab.server.entity;

import java.util.Date;

/**
 * Created by kevin on 15-8-14.
 */
public class PartyCard {
    private int partycard_id;
    private String relation;
    private String party_branch;
    private String position;
    private int type;
    private int status;
    private Date join_date;
    private Date confirm_date;
    private String inspection_person;
    private String application_id;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPartycard_id() {
        return partycard_id;
    }

    public void setPartycard_id(int partycard_id) {
        this.partycard_id = partycard_id;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getParty_branch() {
        return party_branch;
    }

    public void setParty_branch(String party_branch) {
        this.party_branch = party_branch;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public Date getConfirm_date() {
        return confirm_date;
    }

    public void setConfirm_date(Date confirm_date) {
        this.confirm_date = confirm_date;
    }

    public String getInspection_person() {
        return inspection_person;
    }

    public void setInspection_person(String inspection_person) {
        this.inspection_person = inspection_person;
    }

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

}
