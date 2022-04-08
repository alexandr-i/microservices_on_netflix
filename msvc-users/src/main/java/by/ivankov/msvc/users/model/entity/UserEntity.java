package by.ivankov.msvc.users.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author al.ivankov@outlook.com
 */
@Entity
@Table(name = "USERS")
@Setter
@Getter
public class UserEntity implements Serializable {

    public static final long serialVersionUID = -4981621984621981981L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 120, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false, unique = true)
    private String encryptedPassword;
}
