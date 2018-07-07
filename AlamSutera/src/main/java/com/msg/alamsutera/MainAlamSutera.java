package com.msg.alamsutera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yoga.wiguna on 4/21/2018.
 */

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.msg.alamsutera"})

public class MainAlamSutera {

    public static void main (String[]args) throws Exception {
        SpringApplication.run(MainAlamSutera.class, args);
    }

}
