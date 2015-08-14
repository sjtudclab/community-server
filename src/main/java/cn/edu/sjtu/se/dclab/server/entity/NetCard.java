package cn.edu.sjtu.se.dclab.server.entity;

/**
 * Created by kevin on 15-8-13.
 */
public class NetCard {
    private int netcard_id;
    private String nickname;
    private String image;
    private int community_user_id;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getNetcard_id() {
        return netcard_id;
    }

    public void setNetcard_id(int netcard_id) {
        this.netcard_id = netcard_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCommunity_user_id() {
        return community_user_id;
    }

    public void setCommunity_user_id(int community_user_id) {
        this.community_user_id = community_user_id;
    }
}
