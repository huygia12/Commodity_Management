package model.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import model.enums.Gender;

/**
 *
 * @author huy
 */
@Entity
@Table(name = "Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Employee {

    @Id
    @GeneratedValue
    private UUID employeeId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "storeId", referencedColumnName = "storeId")
    private Store store;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private Integer salary;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
