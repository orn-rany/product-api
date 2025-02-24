package rany.com.api.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rany.com.api.config.jpa.Auditable;

@NoArgsConstructor
@Entity
@Table(name = "categories")
@Getter
@Setter
@ToString
public class Category extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false,length = 100)
    private String categoryName;

    @Column(columnDefinition = "TEXT")
    private String description;
}
