package com.xiaocai.bootreview.ssm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaocai.bootreview.ssm.po.DriverCarsPo;
import com.xiaocai.bootreview.ssm.service.IDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName DriverController
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/13
 */
@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private IDriverService driverService;

    @RequestMapping("/getDriverCarByDriverName")
    public String getCarsByBrand(@RequestParam(value = "driverName") String driverName) throws  Exception {
        System.out.println("调用了controller中的/getDriverCarByDriverName");
        List<DriverCarsPo> driverCarInfos = driverService.getDriverCarByDriverName(driverName);
        Optional.ofNullable(driverCarInfos).orElseThrow(() -> new RuntimeException(String.format("driverName为%s的司机记录不存在",driverName)));
        return new ObjectMapper().writeValueAsString(driverCarInfos);
    }


}
