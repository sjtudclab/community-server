package cn.edu.sjtu.se.dclab.server.transfer;

import java.util.Date;

/**
 * Created by Huiyi on 2015/6/29.
 */
public class PaymentMerchantTransfer {
    private String paymentId;
    private double sum;
    private Date timestamp;
    private String cardId;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
