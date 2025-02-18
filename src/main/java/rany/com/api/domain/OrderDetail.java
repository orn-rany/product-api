package rany.com.api.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rany.com.api.config.jpa.Auditable;

@NoArgsConstructor
@Entity
@Table(name = "order_details")
@Getter
@Setter
@ToString
public class OrderDetail extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @PositiveOrZero
    private Integer qty;

    @Column(nullable = false)
    @PositiveOrZero
    private Double price;

    @Column(nullable = false)
    @PositiveOrZero
    private Double subtotal;

    @ManyToOne
//    @Column(nullable = false)
    private Order order;

    @ManyToOne
    protected Product product;

}
