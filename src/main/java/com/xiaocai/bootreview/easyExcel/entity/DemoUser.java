package com.xiaocai.bootreview.easyExcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName DemoUser
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/19
 */
@Data
public class DemoUser {

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("性别")
    private String sex;

    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty("生日")
    private Date birthday;

    @ColumnWidth(10)
    @ExcelProperty("年龄")
    private int age;

    @ExcelProperty("工资")
    @ContentStyle(dataFormat = 2)
    private double salary;


}
