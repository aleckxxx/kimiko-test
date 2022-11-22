package kimiko.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String picture;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false,name="average_price")
    private String averagePrice;
    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

}
