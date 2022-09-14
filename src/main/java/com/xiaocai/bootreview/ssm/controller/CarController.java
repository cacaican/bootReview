package com.xiaocai.bootreview.ssm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaocai.bootreview.ssm.entity.Car;
import com.xiaocai.bootreview.ssm.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName CarController
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/11
 */
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private ICarService carService;



    @RequestMapping("/getCarById")
    public String getById(@RequestParam(value = "id") String id) throws  Exception {
        System.out.println("调用了controller中的/getCarById方法");
        Car car = carService.getById(Integer.valueOf(id));
        Optional.ofNullable(car).orElseThrow(() -> new RuntimeException(String.format("id为%s的车辆记录不存在",id)));
        return new ObjectMapper().writeValueAsString(car);
    }

    @RequestMapping("/createCar")
    public String getById(Car car) throws  Exception {
        System.out.println("调用了controller中的/createCar方法");
        boolean f = carService.createCar(car);

        Optional.ofNullable(car).orElseThrow(() -> new RuntimeException(String.format("新增车辆失败",car)));
        return new ObjectMapper().writeValueAsString(car);
    }

    @RequestMapping("/getCarsByBrand")
    public String getCarsByBrand(@RequestParam(value = "brand") String brand) throws  Exception {
        System.out.println("调用了controller中的/getCarsByBrand方法");
        List<Car> cars = carService.getCarsByBrand(brand);
        Optional.ofNullable(cars).orElseThrow(() -> new RuntimeException(String.format("brand为%s的车辆记录不存在",brand)));
        return new ObjectMapper().writeValueAsString(cars);
    }

    @RequestMapping("/getCarsByDriverId")
    public String getCarsByDriverId(@RequestParam(value = "driverId") String driverId) throws  Exception {
        System.out.println("调用了controller中的/getCarsByDriverId");
        List<Car> cars = carService.getCarsByDriverId(driverId);
        Optional.ofNullable(cars).orElseThrow(() -> new RuntimeException(String.format("driverId为%s的车辆记录不存在",driverId)));
        return new ObjectMapper().writeValueAsString(cars);
    }


}
