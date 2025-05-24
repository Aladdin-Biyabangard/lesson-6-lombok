package az.aladdin.lesson6.controller;

import az.aladdin.lesson6.dao.entity.Payment;
import az.aladdin.lesson6.model.dto.PaymentRequest;
import az.aladdin.lesson6.service.PaymentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PaymentController {

    PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> savePayment(@RequestBody PaymentRequest paymentRequest) {
        Payment payment = paymentService.savePayment(paymentRequest);
        return ResponseEntity.ok(payment);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @GetMapping(path = "{paymentId}")
    public ResponseEntity<Payment> getPayment(@PathVariable String paymentId) {
        Payment payment = paymentService.getPayment(paymentId);
        return ResponseEntity.ok(payment);
    }

    @DeleteMapping(path = "{paymentId}")
    public ResponseEntity<String> deletePayment(@PathVariable String paymentId) {
        paymentService.deletePayment(paymentId);
        return ResponseEntity.ok("Payment successfully deleted!");
    }

}
