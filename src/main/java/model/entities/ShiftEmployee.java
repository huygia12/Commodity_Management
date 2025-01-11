package model.entities;

import lombok.*;
import javax.persistence.*;

/**
 *
 * @author huy
 */
@Entity
@Table(name = "ShiftEmployee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShiftEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String employeeName;

    @ToString.Exclude
    @ManyToOne(optional = true)
    @JoinColumn(name = "shiftId", referencedColumnName = "shiftId")
    private Shift shift;

    @ManyToOne(optional = true)
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employee employee;
}
