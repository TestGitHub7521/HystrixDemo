package com.fedex.hystrixDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fedex.hystrixDemo.service.HystrixService;

@SpringBootApplication
@EnableCircuitBreaker
@RestController
public class HystrixDemoApplication {
	
	@Autowired
	private HystrixService hystrixService;
	
	// This is basically used to send the RestTemplate object to the service layer
	
	/*@Bean
	  public RestTemplate rest(RestTemplateBuilder builder) {
	    return builder.build();
	  }
*/
	public static void main(String[] args) {
		SpringApplication.run(HystrixDemoApplication.class, args);
	}
	
	@RequestMapping("/to-read")
	  public String toRead() {
	    return hystrixService.readingList();
	  }
	
	/*@HystrixCommand(fallbackMethod = "defaultMethod")
	public String method() {
		try {
			Thread.sleep(1001);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String defaultMethod() {
	    return "this is the default";
	}*/
}


