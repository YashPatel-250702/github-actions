package com.tekworks.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class RazorpayService {

	   private final RazorpayClient razorpayClient;

	    public RazorpayService(RazorpayClient razorpayClient) {
	        this.razorpayClient = razorpayClient;
	    }
	    
	    public String createOrder(Double amount,String currency,String name) throws RazorpayException {
	    	
	    	JSONObject jsonObject=new JSONObject();
	    	jsonObject.put("amount", amount*100);
	    	jsonObject.put("currency", currency);
	    	jsonObject.put("payment_capture", 1);
	    	
	    	return razorpayClient.Orders.create(jsonObject).get("id").toString();
	    }
}
