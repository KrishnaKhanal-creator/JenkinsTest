package com.practise.vendorandclients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Scanner;


@SpringBootApplication
@EnableSwagger2
public class VendorAndClientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendorAndClientsApplication.class, args);
    }


}
