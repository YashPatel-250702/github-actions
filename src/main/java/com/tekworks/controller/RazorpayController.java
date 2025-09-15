package com.tekworks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekworks.dto.OrderDto;
import com.tekworks.service.RazorpayService;

@RestController
@RequestMapping("/payment")
public class RazorpayController {
	
	@Autowired
	private RazorpayService razorpayService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createPayemnt(@RequestBody OrderDto dto){
		try {
			String order = razorpayService.createOrder(dto.getAmount(), dto.getCurrency(), dto.getUserName());
			return ResponseEntity.status(HttpStatus.OK).body("Order Id: "+order);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server eroor while createing order");
		}
	}

}
