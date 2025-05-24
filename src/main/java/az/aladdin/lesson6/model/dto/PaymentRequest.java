package az.aladdin.lesson6.model.dto;

import az.aladdin.lesson6.model.enums.PaymentType;
import lombok.Data;

@Data
public class PaymentRequest {
    private PaymentType paymentType;
    private double amount;
}
