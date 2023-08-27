package dev.ez.MTproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//first exclude because I was getting an error after changing java 20 to 18, second to disable automatic login page
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class })




public class MTprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(MTprojApplication.class, args);
	}

}
