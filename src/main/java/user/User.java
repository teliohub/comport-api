package user;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Table(name = "users")
public class User {

    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
