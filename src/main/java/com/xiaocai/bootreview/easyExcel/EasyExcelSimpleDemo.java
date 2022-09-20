package com.xiaocai.bootreview.easyExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.xiaocai.bootreview.easyExcel.entity.DemoUser;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName EasyExcelSimpleDemo
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/19
 */
public class EasyExcelSimpleDemo {

    public static void main(String[] args) {

        //测试excel写数据
//        testWrite();

        String filePath = "D:/workspace/idea/bootReview/target/classes";
        String fileName = "1663583629507.xlsx";
//测试写数据
        testRead(filePath, fileName);
    }

    private static void testRead(String filePath, String fileName) {
        System.out.println("路径为" + filePath + "/" + fileName);
        List<DemoUser> list = new LinkedList<>();
        EasyExcel.read(filePath + "/" + fileName)
                .head(DemoUser.class)    //指定对象
                .sheet(0)

                .registerReadListener(new AnalysisEventListener<DemoUser>() {    //使用类对象
                    @Override
                    public void invoke(DemoUser testModel2, AnalysisContext analysisContext) {
                        list.add(testModel2);
                    }

                    @Override
                    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                        System.out.println("数据读取完毕");
                    }
                }).doRead();
        for (DemoUser model : list) {
            System.out.println(model.toString());
//            原文链接：https://blog.csdn.net/quietbxj/article/details/113766870

        }
    }

    private static void testWrite() {
        ArrayList<Object> list = new ArrayList<>();
        String[] strings = {"男", "女", "不详"};
        for (int i = 0; i < 10; i++) {
            DemoUser demoUSer = new DemoUser();
            demoUSer.setAge((int) (Math.random() * 80));
            demoUSer.setName("xiao" + i);
            demoUSer.setBirthday(new Date());
            demoUSer.setSex(strings[(int) (Math.random() * 3)]);
            demoUSer.setSalary(Math.random() * 5000);
            list.add(demoUSer);
            System.out.println(demoUSer);
        }

//        设置文件路径+文件名称
        String filePath = EasyExcelSimpleDemo.class.getClassLoader().getResource("").getPath();
        System.out.println(filePath);
        String fileName = System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(new File(filePath + "/" + fileName), DemoUser.class).sheet(0, "测试用户").doWrite(list);
    }

}
