package service_profile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service_profile.services.IPaymentService;

@RequestMapping(path = "/payment")
@RestController
public class PaymentController {
    private final IPaymentService iPaymentService;

    public PaymentController(IPaymentService iPaymentService) {
        this.iPaymentService = iPaymentService;
    }

    @GetMapping("/all_profiles")
    public void getAllProfile() {
        iPaymentService.getAll();
    }

//    @GetMapping("/profile")
//    public String getHello() {
//        return iPaymentService.getHello();
//    }

    @GetMapping("xinchao")
    public String xinchao(){
        return "Thi is payment_service";
    }
}
