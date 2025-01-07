package model.entities;

import java.time.LocalDateTime;
import java.util.List;
import lombok.*;
import javax.persistence.*;
import model.enums.ShiftState;

@Entity
@Table(name = "Shift")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shiftId;

    private LocalDateTime openAt;

    private LocalDateTime endAt;

    @Column(nullable = false)
    @Builder.Default
    private Integer openingBalance = 0;

    @Column(nullable = false)
    @Builder.Default
    private Integer surcharge = 0;

    private String cashierName;
    
    private Long cashierId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private ShiftState state = ShiftState.STAGED;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "storeId", referencedColumnName = "storeId")
    private Store store;

    @OneToMany(mappedBy = "shift", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "shift", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<ShiftEmployee> employees;
}
