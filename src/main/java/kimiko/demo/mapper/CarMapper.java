package kimiko.demo.mapper;

import kimiko.demo.dto.CarDto;
import kimiko.demo.dto.CommentDto;
import kimiko.demo.entity.Car;
import kimiko.demo.exception.BrandNotFoundException;
import kimiko.demo.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor

public class CarMapper {
    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private BrandService brandService;

    public CarDto toCarDto(Car car){
        return new CarDto().builder().
                id(car.getId())
                .year(car.getYear())
                .model(car.getModel())
                .picture(car.getPicture())
                .averagePrice(car.getAveragePrice())
                .brand(car.getBrand().getName())
                .brandId(car.getBrand().getId())
                .build();
    }

    public CarDto toCarDtoFull(Car car){
        CarDto carDto = toCarDto(car);
        List<CommentDto> comments = car.getComments().stream()
                .map(value -> commentMapper.toCommentDto(value)).collect(Collectors.toList());
        carDto.setComments(comments);
        return carDto;
    }

    public Car toCar(CarDto car) throws BrandNotFoundException{
        return new Car().builder()
                .id(car.getId())
                .picture(car.getPicture())
                .averagePrice(car.getAveragePrice())
                .year(car.getYear())
                .model(car.getModel())
                .brand(brandService.findById(car.getBrandId()))
                .build();
    }
}
