package model.entity;

import java.time.LocalDateTime;
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
class Store {

    @Id
    @GeneratedValue
    private UUID storeId;

    @Column(nullable = false)
    private String storeName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String avatar = "store-placeholder.jpg";

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
