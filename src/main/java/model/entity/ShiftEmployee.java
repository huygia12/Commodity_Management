package model.entity;

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
class ShiftEmployee {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shiftId", referencedColumnName = "shiftId")
    private Shift shift;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;
}