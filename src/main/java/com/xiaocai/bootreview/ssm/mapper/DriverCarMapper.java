package com.xiaocai.bootreview.ssm.mapper;

import com.xiaocai.bootreview.ssm.po.DriverCarsPo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DriverCarMapper {
    List<DriverCarsPo> getDriverCarByDriverName(String driverName);

    List<DriverCarsPo> getDriverCarByDriverName2(String driverName);

//    @Select(
//            "select * from driver where name like #{driverName}"
//    )
//    @Results({
//            @Result(property = "",
//                column = "",
////                    one = @One(select = "com.kimzing.data.repository.AddressRepository.findAddressById"))
//                many = @Many(select = "com.kimzing.data.repository.CarRepository.findCarsByUserId"))
//    })
//    List<DriverCarsPo> getDriverCarByDriverName2(String driverName);
}
