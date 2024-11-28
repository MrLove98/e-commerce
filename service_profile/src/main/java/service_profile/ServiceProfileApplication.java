package service_profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients
public class ServiceProfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProfileApplication.class, args);
    }

}
