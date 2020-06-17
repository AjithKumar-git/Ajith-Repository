package com.cap.Assignment1.Endpoints;

import java.net.HttpURLConnection;
import java.net.URL;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {

	@Override
	public Health health() {
		try {
			URL url=new URL("https://youtube.com");
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			int code=connection.getResponseCode();			
			if(code==200) {
				return Health.up().build();
			}
			else {
				return Health.down().withDetail("Error", "Service is down").build();
			}
		}
		catch(Exception e){
			return Health.down().withDetail("Error", "Service is down with Exception "+e.getMessage()).build();
		}
		
	}

	
}