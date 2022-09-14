package com.xiaocai.bootreview.ssm.service.impl;

import com.xiaocai.bootreview.ssm.mapper.DriverCarMapper;
import com.xiaocai.bootreview.ssm.po.DriverCarsPo;
import com.xiaocai.bootreview.ssm.service.IDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DriverServiceImpl
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/13
 */
@Service
public class DriverServiceImpl implements IDriverService {

    @Autowired
    private DriverCarMapper driverCarMapper;

    @Override
    public List<DriverCarsPo> getDriverCarByDriverName(String driverName) {
        List<DriverCarsPo> driverCarInfos;
        /*
        * 方法一使用在mappper.xml文件中定义的方式
        * */
//        driverCarInfos = driverCarMapper.getDriverCarByDriverName(driverName);

        driverCarInfos = driverCarMapper.getDriverCarByDriverName2(driverName);

        return driverCarInfos;
    }
}
