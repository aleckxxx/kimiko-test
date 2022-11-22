package kimiko.demo.dto;

import kimiko.demo.entity.Brand;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {

    private int id;
    private String model;
    private String picture;
    private Integer year;
    private String averagePrice;
    private BrandDto brand;
}
