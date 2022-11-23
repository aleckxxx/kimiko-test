package kimiko.demo.service;

import kimiko.demo.dto.CarDto;
import kimiko.demo.entity.Car;
import kimiko.demo.exception.BrandNotFoundException;
import kimiko.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Value("${fileupload.default}")
    private String defaultPicture;
    private CarRepository carRepository;


    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }


    public Page<Car> findAll(int pageNo, int pageLimit){
        Pageable paging = PageRequest.of(pageNo, pageLimit);
        return carRepository.findAll(paging);
    }

    public Car findById(int id){
        return carRepository.findById(id);
    }

    public void save(Car car){
        if(car.getPicture()==null){
            car.setPicture(defaultPicture);
        }
        carRepository.save(car);
    }
}

