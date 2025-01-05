package model.entities;

import java.time.LocalDateTime;
import java.util.List;
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
public class Shift {
    @Id
    @GeneratedValue
    private UUID shiftId;

    @Column(nullable = false)
    private LocalDateTime openAt;

    @Column(nullable = false)
    private LocalDateTime endAt;

    @Column(nullable = false)
    @Builder.Default
    private Integer openingBalance = 0;

    @Column(nullable = false)
    @Builder.Default
    private Integer surcharge = 0;
    
    @Column(nullable = false)
    private String cashierName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private ShiftState state = ShiftState.STAGED;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "storeId", referencedColumnName = "storeId")
    private Store store;
    
    @OneToMany(mappedBy = "shift", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Invoice> invoices;
    
    @OneToMany(mappedBy = "shift", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ShiftEmployee> employees;
}
