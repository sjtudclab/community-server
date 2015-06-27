package cn.edu.sjtu.se.dclab.server.controller.rest;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sjtu.se.dclab.server.common.Constants;
import cn.edu.sjtu.se.dclab.server.transfer.TransactionTransfer;

/**
 *2015年6月27日 下午8:36:55
 *@author changyi yuan
 */
@Controller
@RequestMapping(value=Constants.REST + "/transactions")
public class TransactionController {
	
	@RequestMapping(value = "user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<TransactionTransfer> getPurchaseRecords(@PathVariable long userId){
		return getData();
	}
	
	@RequestMapping(value = "merchant/{merchantId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<TransactionTransfer> getIncomeRecords(@PathVariable long merchantId){
		return getData2();
	}
	
	private Collection<TransactionTransfer> getData(){
		Collection<TransactionTransfer> transfers = new ArrayList<TransactionTransfer>();
		String merchantName = "商家";
		Random rand = new Random();
		DecimalFormat df = new DecimalFormat("#.00");
		String accountId = getRandInt(6) + "******" + getRandInt(6);
		for(int i = 1;i <= 10;i++){
			TransactionTransfer transfer = new TransactionTransfer();
			transfer.setTransactionId(String.valueOf(i*100 + rand.nextInt(100)));
			transfer.setAccountId(accountId);
			transfer.setAmount(df.format(rand.nextDouble() * 100));
			transfer.setTime(getRandDate(null, null));
			transfer.setMerchantName(merchantName + i);
			transfers.add(transfer);
		}
		return transfers;
	}
	
	private Collection<TransactionTransfer> getData2(){
		Collection<TransactionTransfer> transfers = new ArrayList<TransactionTransfer>();
		Random rand = new Random();
		DecimalFormat df = new DecimalFormat("#.00");
		for(int i = 1;i <= 10;i++){
			TransactionTransfer transfer = new TransactionTransfer();
			transfer.setTransactionId(String.valueOf(i*100 + rand.nextInt(100)));
			transfer.setAccountId(String.valueOf(getRandInt(6)) + "******" + String.valueOf(getRandInt(6)));
			transfer.setAmount(df.format(rand.nextDouble() * 100));
			transfer.setTime(getRandDate(null, null));
			transfers.add(transfer);
		}
		return transfers;
	}
	
	private int getRandInt(int num){
		int result = 0;
		Random rand = new Random();
		result = rand.nextInt(9) + 1;
		for(int i = 0;i < num -1;i++)
			result = result * 10 + rand.nextInt(10);
		return result;
	}
	
	private Date getRandDate(String startDate, String endDate){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		Date start = null;
		Date end = null;
		try{
	        start = format.parse(startDate);
	        end = format.parse(endDate);
		}catch(Exception e){
			try{
				start = format.parse("2000-01-01");
				end = format.parse("2015-05-01");
			}catch(Exception e1){
				e.printStackTrace();
			}
		}

		Random rand = new Random();
		long date = start.getTime() + (long)(Math.random() *(end.getTime() - start.getTime()));
		return new Date(date);
	}
}
