package com.xiaocai.bootreview.ssm.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DriverCarMapper {
    List getDriverCarByDriverName(String driverName);
}
