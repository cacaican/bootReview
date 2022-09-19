package com.xiaocai.bootreview.easyExcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;
import com.xiaocai.bootreview.easyExcel.entity.DemoUser;
import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DemoUserListener
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/19
 */
public class DemoUserListener implements ReadListener<DemoUser>  {

    /**
     * 缓存的数据
     */
    private List<DemoUser> cachedDataList = new ArrayList<DemoUser>();

    @Override
    public void onException(Exception e, AnalysisContext analysisContext) throws Exception {
        System.out.println("发生异常拉");
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param o    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param analysisContext
     */
    @Override
    public void invoke(DemoUser data, AnalysisContext analysisContext) {
        cachedDataList.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= 100) {
//            saveData();
            // 存储完成清理 list
//            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
        System.out.println("Object---------"+data);
        System.out.println("调用invoke方法");

    }

    @Override
    public void extra(CellExtra cellExtra, AnalysisContext analysisContext) {
        System.out.println("调用extra方法");

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("解析完成后的方法");

    }

    @Override
    public boolean hasNext(AnalysisContext analysisContext) {
        return false;
    }

    @Override
    public void invokeHead(Map map, AnalysisContext analysisContext) {
        System.out.println("invokeHead方法");
        System.out.println(analysisContext);


    }
}
