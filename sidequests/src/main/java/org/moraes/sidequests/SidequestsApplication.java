package org.moraes.sidequests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SidequestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SidequestsApplication.class, args);

        System.out.println("App runnning at port 8080.");
    }

}
