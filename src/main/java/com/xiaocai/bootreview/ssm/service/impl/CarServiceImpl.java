package com.xiaocai.bootreview.ssm.service.impl;

import com.xiaocai.bootreview.ssm.entity.Car;
import com.xiaocai.bootreview.ssm.mapper.CarMapper;
import com.xiaocai.bootreview.ssm.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
