package kimiko.demo.api.controller;

import kimiko.demo.api.error.ErrorResponse;
import kimiko.demo.dto.CarDto;
import kimiko.demo.entity.Car;
import kimiko.demo.exception.BrandNotFoundException;
import kimiko.demo.mapper.CarMapper;
import kimiko.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/cars")
public class RestCarController extends BaseController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarMapper carMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void  saveCar(@Valid @RequestBody CarDto newCar){
        Car carEntity = carMapper.toCar(newCar);
        carService.save(carEntity);
    }

    @ExceptionHandler({BrandNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse brandNotFoundHandler(BrandNotFoundException exception){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

}
