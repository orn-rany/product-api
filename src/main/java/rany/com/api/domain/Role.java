package rany.com.api.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rany.com.api.config.jpa.Auditable;

@NoArgsConstructor
@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
public class Role extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 50)
    private String roleName;

}
