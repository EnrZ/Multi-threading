package dev.ez.MTproj.main;

import dev.ez.MTproj.RunnableObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.concurrent.*;

//first exclude because I was getting an error after changing java 20 to 18, second to disable automatic login page
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class })



public class MTprojApplication {

	public static void main(String[] args) {

		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

		System.out.println("");
		System.out.println("First scheduled threat pool will run for 30 seconds");

		executorService.schedule(new RunnableObject("my one-off delayed task "), 10, TimeUnit.SECONDS);
		executorService.scheduleAtFixedRate(new RunnableObject("my fixed rate task"), 15, 5, TimeUnit.SECONDS);
			SpringApplication.run(MTprojApplication.class, args);
		try {
			Thread.sleep(30000);  // let run 30 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		executorService.shutdown();

		while (!executorService.isTerminated())	{
			// wait
		}
		System.out.println("All threads from first thread pool completed successfully");


		System.out.println("");
		System.out.println("Second scheduled threat pool will run for 30 seconds");

		executorService = Executors.newScheduledThreadPool(10);
		executorService.scheduleWithFixedDelay(new RunnableObject("my fixed delay task"), 5, 5, TimeUnit.SECONDS);


		try {
			Thread.sleep(30000);  // let run 30 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		executorService.shutdown();

		while (!executorService.isTerminated())	{
			// wait
		}
		System.out.println("All threads from second thread pool completed successfully");
		}


}
