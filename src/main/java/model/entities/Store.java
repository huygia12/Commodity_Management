package model.entities;

import java.time.LocalDateTime;
import java.util.List;
import lombok.*;
import javax.persistence.*;
import java.util.UUID;

/**
 *
 * @author huy
 */
@Entity
@Table(name = "Store")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Store {
    @Id
    @GeneratedValue
    private UUID storeId;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Builder.Default
    private String avatar = "data/avatar.png";

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Product> products;

    @OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Shift> shifts;
    
    @OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Employee> employees;
}
