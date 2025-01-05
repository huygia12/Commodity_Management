package model.entities;

import lombok.*;
import javax.persistence.*;
import java.util.UUID;

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
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String employeeName;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "shiftId", referencedColumnName = "shiftId")
    private Shift shift;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employee employee;
}