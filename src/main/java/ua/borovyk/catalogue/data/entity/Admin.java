package ua.borovyk.catalogue.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(
        name = "admin",
        uniqueConstraints = {
                @UniqueConstraint(name = "admin_login_ukey", columnNames = {"login"})
        }
)
public class Admin {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

}
