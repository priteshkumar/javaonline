package com.example.consumingrest;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
/*
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
			HashMap<String,String> params = new HashMap<>();
			String queryURL = "https://api.jdoodle.com/v1/execute/";
			params.put("clientId","897ecf21be30faf3b108e047795e8ee3");
			params.put("clientSecret", "a4195f2f8e03cde574d313c70c9708eb9791ebb0789e13d41b7fc430c1b1354");
			params.put("language","java");
			params.put("versionIndex","0");
			String code = "public class AceDemo {public static void main(String[] args){System.out"
					+ ".println(\"hello acejava\");}}";
			params.put("script",code);
       //"script": request.body.decode("utf-8")
    	String output = restTemplate.postForObject(queryURL,params,String.class);
    	log.info(output);
		};
	}*/
}
