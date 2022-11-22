package kimiko.demo.dto;

import kimiko.demo.entity.Brand;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandDto {
    private int id;
    private String name;
}
