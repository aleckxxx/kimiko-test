package kimiko.demo.dto;

import kimiko.demo.entity.Brand;
import lombok.*;

import java.util.List;


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
    private List<CommentDto> comments;
}
