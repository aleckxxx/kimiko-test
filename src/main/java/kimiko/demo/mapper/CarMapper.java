package kimiko.demo.mapper;

import kimiko.demo.dto.CarDto;
import kimiko.demo.entity.Car;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class CarMapper {
    @Autowired
    private BrandMapper brandMapper;

    public CarDto toCarDto(Car car){
        return new CarDto().builder().
                id(car.getId())
                .year(car.getYear())
                .model(car.getModel())
                .picture(car.getPicture())
                .brand(brandMapper.toBrandDto(car.getBrand()))
                .build();
    }
}
