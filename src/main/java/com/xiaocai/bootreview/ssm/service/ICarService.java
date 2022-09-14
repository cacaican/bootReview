package com.xiaocai.bootreview.ssm.service;

import com.xiaocai.bootreview.ssm.entity.Car;

import java.util.List;
//import org.springframework.stereotype.Service;

public interface ICarService {
    Car getById(Integer id);

    List<Car> getCarsByBrand(String brand);

    boolean createCar(Car car);

    List<Car> getCarsByDriverId(String driverId);
}
