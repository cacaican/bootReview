package com.xiaocai.bootreview.jvm;

/**
 * @ClassName HeapOom
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/21
 */

import java.util.ArrayList;
import java.util.List;

/*** VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * -Xms20m：堆最小为20M；
 * -Xmx20m：堆最大为20M；
 * 将堆最大值与最小值设置为一样，可避免堆自动扩展。
 * *  */
public class HeapOom {

    public static void main(String[] args) {
        for(;;){
            long l = System.currentTimeMillis();
            List<OOMObject> list = new ArrayList<OOMObject>();
            while (true) {
                list.add(new OOMObject());
            }
        }
    }
    private static class OOMObject {
    }
}
