package model.entity;

import java.time.LocalDateTime;
import lombok.*;
import javax.persistence.*;
import java.util.UUID;
import model.enums.PaymentOption;

/**
 *
 * @author huy
 */
@Entity
@Table(name = "Order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Order {

    @Id
    @GeneratedValue
    private UUID orderId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shiftId", referencedColumnName = "shiftId")
    private Shift shift;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentOption paymentMethod = PaymentOption.CASH;

    @Column(nullable = false)
    private Integer vat = 0;

    @Column(nullable = false)
    private Integer customerMoney = 0;

    @Column(nullable = false)
    private Float discount = 0.0f;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}