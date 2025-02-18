package rany.com.api.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rany.com.api.config.jpa.Auditable;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User extends Auditable<String > {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false,unique = true)
    private String userName;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 50)
    private String email;

    @Column(length = 50)
    private String password;

    private LocalDate dob;

    @Column(length = 10)
    private String gender;

    @Column(columnDefinition = "TEXT")
    private String address;

    @OneToOne
//    @Column(nullable = false,unique = true)
    private Role role;

}
