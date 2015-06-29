package cn.edu.sjtu.se.dclab.server.entity;

/**
 * Created by Huiyi on 2015/6/29.
 */
public class Merchant {
    private int merchantId;
    private String address;
    private String merchantName;
    private String note;

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
