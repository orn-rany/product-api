package rany.com.api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rany.com.api.config.jpa.Auditable;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
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
    @JoinColumn(name = "customer_id")
    private  User customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private  User employee;


}
