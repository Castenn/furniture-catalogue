package ua.borovyk.catalogue.data.entity;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
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
        name = "type",
        uniqueConstraints = {
                @UniqueConstraint(name = "type_name_ukey", columnNames = {"name"})
        }
)
public class Type {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

}

