package kimiko.demo.mapper;

import kimiko.demo.dto.BrandDto;
import kimiko.demo.entity.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BrandMapper {
    public BrandDto toBrandDto(Brand brand){
        return new BrandDto().builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();
    }
}
