package cn.edu.sjtu.se.dclab.server.mapper;

import cn.edu.sjtu.se.dclab.server.entity.Payment;
import cn.edu.sjtu.se.dclab.server.transfer.PaymentMerchantTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.PaymentUserTransfer;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/6/29.
 */
public interface PaymentMapper {
    public void save(Payment payment);

    public Collection<PaymentUserTransfer> getUserPaymentInfo(int userId);

    public Collection<PaymentMerchantTransfer> getMerchantExpenseInfo(int merchantId);
}
