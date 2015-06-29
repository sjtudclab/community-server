package cn.edu.sjtu.se.dclab.server.controller.rest;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.entity.Payment;
import cn.edu.sjtu.se.dclab.server.service.PaymentService;
import cn.edu.sjtu.se.dclab.server.transfer.PaymentMerchantTransfer;
import cn.edu.sjtu.se.dclab.server.transfer.PaymentUserTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Huiyi on 2015/6/29.
 */
@Controller
@RequestMapping(value = Constants.REST + "/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void save(@RequestBody Payment payment) {
        paymentService.save(payment);
    }

    @ResponseBody
    @RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
    public Collection<PaymentUserTransfer> getUserPaymentInfo(@PathVariable int userId) {
        return paymentService.getUserPaymentInfo(userId);
    }

    @ResponseBody
    @RequestMapping(value = "merchant/{merchantId}", method = RequestMethod.GET)
    public Collection<PaymentMerchantTransfer> getMerchantExpenseInfo(@PathVariable int merchantId) {
        return paymentService.getMerchantExpenseInfo(merchantId);
    }
}
