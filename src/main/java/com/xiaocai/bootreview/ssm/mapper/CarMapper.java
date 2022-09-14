package com.xiaocai.bootreview.ssm.mapper;

import com.xiaocai.bootreview.ssm.entity.Car;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.DateTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface CarMapper {
   List getAllCar();

    Car getCarById(int id);

    List getCar(@Param("condition")Map condition);

   /*  boolean updateCar(int id, Car car);

    boolean deleteCar(int id);*/

    boolean createCar(Car car);

    List getCarsByCondition(@Param("from") int from ,@Param("limit") int limit  ,@Param("condition")Map Condition);

    @Select("select count(1) from car")
    int  count();

    List<Car> getCarByBrand(String brand);

    @Select("select * from car where driverId = #{driverId}")
    List<Car> getCarByDriverId(String driverId);


}
