package model.entity;

import java.time.LocalDateTime;
import lombok.*;
import javax.persistence.*;
import java.util.UUID;
import model.enums.ShiftState;
/**
 *
 * @author huy
 */
@Entity
@Table(name = "Shift")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Shift {

    @Id
    @GeneratedValue
    private UUID shiftId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "storeId", referencedColumnName = "storeId")
    private Store store;

    @Column(nullable = false)
    private LocalDateTime openAt;

    @Column(nullable = false)
    private LocalDateTime endAt;

    @Column(nullable = false)
    private Integer openingBalance = 0;

    @Column(nullable = false)
    private Integer surcharge = 0;

    @Column(nullable = false)
    private Integer vat = 0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShiftState state = ShiftState.STAGED;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cashierId", referencedColumnName = "employeeId")
    private Employee cashier;
}
