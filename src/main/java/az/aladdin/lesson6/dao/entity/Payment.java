package az.aladdin.lesson6.dao.entity;

import az.aladdin.lesson6.model.enums.PaymentType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {

    String paymentId;
    PaymentType paymentType;
    double amount;
    LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Double.compare(amount, payment.amount) == 0 && Objects.equals(paymentId, payment.paymentId) && paymentType == payment.paymentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, paymentType, amount);
    }


}
