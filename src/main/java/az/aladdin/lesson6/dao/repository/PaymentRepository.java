package az.aladdin.lesson6.dao.repository;

import az.aladdin.lesson6.dao.entity.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PaymentRepository {
    private final ConcurrentHashMap<String, Payment> payments = new ConcurrentHashMap<>();


    public Payment savePayment(Payment payment) {
        payments.put(payment.getPaymentId(), payment);
        return payment;
    }

    public List<Payment> getAllPayments() {
        return new ArrayList<>(payments.values());
    }

    public Payment getPaymentById(String paymentId) {
        return payments.get(paymentId);
    }

    public void deletePaymentById(String paymentId) {
        payments.remove(paymentId);
    }
}
