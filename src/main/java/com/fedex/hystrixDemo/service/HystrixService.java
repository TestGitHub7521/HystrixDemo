package com.fedex.hystrixDemo.service;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixService {
	
	// This is used to get the  RestTemplate object from controller layer.
	
	/*private final RestTemplate restTemplate;
	
	public HystrixService(RestTemplate rest) {
	    this.restTemplate = rest;
	  }*/
	
	@HystrixCommand(fallbackMethod = "reliable")
	  public String readingList() {
		RestTemplate restTemplate = new RestTemplate();
	    URI uri = URI.create("http://localhost:8992/hello");

	    return restTemplate.getForObject(uri, String.class);
	  }

	  public String reliable() {
	    return "Cloud Native Java (O'Reilly)";
	  }

}