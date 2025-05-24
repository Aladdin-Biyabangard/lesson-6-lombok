package az.aladdin.lesson6.service;

import az.aladdin.lesson6.dao.entity.Payment;
import az.aladdin.lesson6.dao.repository.PaymentRepository;
import az.aladdin.lesson6.model.dto.PaymentRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
@Slf4j
public class PaymentService {

    PaymentRepository paymentRepository;


    public Payment savePayment(PaymentRequest paymentRequest) {
        Payment payment = createPayment(paymentRequest);
        return paymentRepository.savePayment(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.getAllPayments();
    }

    public Payment getPayment(String paymentId) {
        Payment payment = paymentRepository.getPaymentById(paymentId);
        if (payment == null) {
            throw new RuntimeException("Payment not found exception!");
        }
        return payment;
    }

    public void deletePayment(String paymentId) {
        paymentRepository.deletePaymentById(paymentId);
    }


    private Payment createPayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        LocalDateTime now = LocalDateTime.now();
        log.info("Payment is being created");
        payment.setCreatedAt(now);
        payment.setAmount(paymentRequest.getAmount());
        payment.setPaymentType(paymentRequest.getPaymentType());
        payment.setPaymentId(UUID.randomUUID().toString());
        log.info("Payment created!");
        return payment;
    }
}
