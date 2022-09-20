package com.xiaocai.bootreview.mapDemo;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName MapDemo
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/20
 */
public class MapDemo {


    public static void main(String[] args) {

        //测试了下hashMap，并且复习了下hashmap的存值逻辑和扩容逻辑
        //testHashMap();
        //
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        map.put("xiao","cai");
        map.put("han","meimei");
        map.forEach((key,v)-> System.out.printf("key--\t %s \t value---%s",key,v));
    }

    private static void testHashMap() {
        //构造hashMap，内部使用了默认容量和默认加载因子loadFactor，容量CAPACITY*加载因子是扩容的阈值threshold
        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("xiaocai","cai");
        //put方法执行过程：
        /*
        1.首先进行hash运算：第一步 key.hash()^(h>>16)
        2.putVal方法
            .1 如果table<Node>是空,调用resize设置容量：
                resize方法：初始化数组容量，或者扩容方法
                    a。如果Node类型的数组rable容量是空，容量=默认容量16 ，阈值=默认加载因子0.75f*默认容量16 =12
                    b。容量是否超过最大值2^31 -1 ，若是，容量是旧容量 ；
                                               若否，阈值《《1
                    c。如果原阈值》0 初始容量被置于阈值 默认情况第一次扩容后，新容量是12
                    d、如果新阈值==0 ，新阈值 = 新容量*加载因子
                    e：将扩容前的数组元素放到新数组中
                        .1 如果元素e只有一个元素，newTab[e.hash & (newCap - 1)] = e; 及，将元素e放到下表为e的哈希与容量的与运算中
                        .2 如果元素数据红黑树：进行树的拆分
                                如果重新运算后的下标不变：进入低头低尾的运算 (e.hash & oldCap) == 0 ，否则进入高位运算，并重新计算低位高位的容量
                                低位运算后元素任处于原位置，高位放到tab[index + bit]的数组元素位置上（bit这里是原容量的意思）
                                如果拆分后的容量低于非树阈值，则树转链表，如果
                        .3 如果元素是链表，则遍历链表中的每一个元素
                                如果重新运算后的下标不变：进入低头低尾的运算 (e.hash & oldCap) == 0
                                低位放到原位置，高位放到原下表+原容量的位置
             .2计算下标：(n - 1) & hash：
             .3如果下标位置没有元素，是空的，则放到该位置
             .4：进入替换逻辑：
                如果新值的hash 和原值的哈希相等且key值相等，则用新值替换旧值
                如果新值是一个树的话，进入放树的逻辑
                如果是链表的话：遍历链表
                    新建一个p.next = newNode(hash, key, value, null);node 放到最后位null的位置，尾插法
                    此时，如果链表长度》树化阈值8，则进行树化
        */
        map.put("li","mei");
        map.forEach((key,v)-> System.out.printf("key-----%s\t\t,value------%s%n",key,v));
    }
}
