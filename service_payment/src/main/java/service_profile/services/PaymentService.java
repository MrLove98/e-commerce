package service_profile.services;

import org.springframework.stereotype.Service;
import service_profile.repositories.PaymentRepository;

import java.util.List;

@Service
public class PaymentService implements IPaymentService{

    private final PaymentRepository paymentRepository;

//    private final ProfileClient profileClient;
//
//    public PaymentService(PaymentRepository paymentRepository, ProfileClient profileClient) {
//        this.paymentRepository = paymentRepository;
//        this.profileClient = profileClient;
//    }


    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public <T> List<T> getAll() {
//        var dataProfile = profileClient.getHello();
//        System.out.println(dataProfile);
        return List.of();
    }

    @Override
    public String getHello() {
//        return profileClient.getHello();
        return "xin chao";
    }
}
