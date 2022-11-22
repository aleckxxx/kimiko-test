package kimiko.demo.controller;

import kimiko.demo.dto.CarDto;
import kimiko.demo.entity.Car;
import kimiko.demo.mapper.CarMapper;
import kimiko.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class CarController {
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private CarService carService;

    @RequestMapping(value="/cars",method = RequestMethod.GET)
    public ModelAndView carList(@RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "10") Integer pageLimit){
        ModelAndView modelAndView = new ModelAndView();
        Page<Car> carPage = carService.findAll(pageNo,pageLimit);
        modelAndView.addObject("totalPage",carPage.getTotalPages());
        modelAndView.addObject("currentPage",pageNo);
        List<CarDto> list = carPage.getContent()
                                   .stream()
                                   .map((value)-> carMapper.toCarDto(value))
                                   .collect(Collectors.toList());
        modelAndView.addObject("cars",list);
        modelAndView.setViewName("car/index");
        return modelAndView;
    }
}
