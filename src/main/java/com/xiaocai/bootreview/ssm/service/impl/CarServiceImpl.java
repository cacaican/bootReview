package com.xiaocai.bootreview.ssm.service.impl;

import com.xiaocai.bootreview.ssm.entity.Car;
import com.xiaocai.bootreview.ssm.mapper.CarMapper;
import com.xiaocai.bootreview.ssm.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CarServiceImpl
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/11
 */
@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public Car getById(Integer id) {

        Car car = carMapper.getCarById(id);
        return car;
    }

    @Override
    public List<Car> getCarsByBrand(String brand) {
        List car = carMapper.getCarByBrand("%"+brand+"%");
        return car;
    }

    @Override
    public boolean createCar(Car car) {
        boolean car1 = carMapper.createCar(car);
        return car1;
    }
}
