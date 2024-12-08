package service_profile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/payment")
@RestController
public class PaymentController {

    @GetMapping("/h")
    public String getHello() {
        return "Payment Service Xin chao";
    }

}
