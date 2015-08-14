package cn.edu.sjtu.se.dclab.server.entity;

/**
 * Created by kevin on 15-8-14.
 */
public class LivingCard {
    private int livingcard_id;
    private String name;
    private String address;
    private String zip_code;
    private String house_number;
    private int user_id;

    public int getLivingcard_id() {
        return livingcard_id;
    }

    public void setLivingcard_id(int livingcard_id) {
        this.livingcard_id = livingcard_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
