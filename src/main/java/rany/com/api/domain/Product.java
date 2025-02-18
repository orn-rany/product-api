package rany.com.api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import rany.com.api.config.jpa.Auditable;

@NoArgsConstructor
@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
public class Product  extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    private String name;

    @Column(length = 255)
    private String image;

    @Column(nullable = false)
    @PositiveOrZero
    private Double price;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer qty;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private Category category;
}
