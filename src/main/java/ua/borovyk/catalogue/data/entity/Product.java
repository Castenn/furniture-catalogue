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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(
        name = "product",
        uniqueConstraints = {
                @UniqueConstraint(name = "product_article_ukey", columnNames = {"article"})
        }
)
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer article;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double height;

    @Column(nullable = false)
    private Double width;

    @Column(nullable = false)
    private Double deep;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

}
