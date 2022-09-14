package com.xiaocai.bootreview.ssm.service;

import com.xiaocai.bootreview.ssm.po.DriverCarsPo;

import java.util.List;

public interface IDriverService {
    List<DriverCarsPo> getDriverCarByDriverName(String driverName);
}
