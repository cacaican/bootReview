package com.xiaocai.bootreview.ssm.po;

import com.xiaocai.bootreview.ssm.entity.Car;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @ClassName DriverCarsPo
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/14
 */
@Data
public class DriverCarsPo {
    private int id;
    private String name;
    private String license;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    /**
     * 用户拥有的车，和用户是一对多的关系
     */
    private List<Car> cars;
}
