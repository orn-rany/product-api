package rany.com.api.domain;

import jakarta.persistence.*;
import lombok.*;
import rany.com.api.config.jpa.Auditable;

import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false)
    private Double totalPrice;

    @Column(nullable = false)
    private OrderStatus orderStatus;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
//    @JoinColumn(name = "customer_id")
    private  User customer;

    @ManyToOne
//    @JoinColumn(name = "employee_id")
    private  User employee;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Set<OrderDetail> orderDetails;

}
