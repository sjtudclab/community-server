package cn.edu.sjtu.se.dclab.server.service.impl;

import cn.edu.sjtu.se.dclab.server.entity.Payment;
import cn.edu.sjtu.se.dclab.server.mapper.CardMapper;
import cn.edu.sjtu.se.dclab.server.mapper.PaymentMapper;
import cn.edu.sjtu.se.dclab.server.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Huiyi on 2015/6/29.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentMapper paymentMapper;
    private final CardMapper cardMapper;

    @Autowired
    public PaymentServiceImpl(final PaymentMapper paymentMapper,
                              final CardMapper cardMapper) {
        this.paymentMapper = paymentMapper;
        this.cardMapper = cardMapper;
    }

    @Override
    public void save(Payment payment) {
        // first generate a unique payment id for this payment
        payment.setPaymentId(getPaymentId());

        paymentMapper.save(payment);
        cardMapper.updateBalance(payment.getCardId(), payment.getBalance());
    }

    private String getPaymentId() {
        synchronized (PaymentServiceImpl.class) {
            return String.valueOf(System.currentTimeMillis());
        }
    }
}
