package com.cjean.zoo.base.lambda;

import com.cjean.zoo.base.domian.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 在使用 java.util.stream.Collectors 类的 toMap()方法转为 Map 集合时，一定要使
 * 用含有参数类型为 BinaryOperator，参数名为 mergeFunction 的方法，否则当出现相同 key
 * 值时会抛出 IllegalStateException 异常
 */
public class Test2Map {

    private static final Logger log = LoggerFactory.getLogger(Test2Map.class);
    public static void main(String[] args) {
        log.info("collect:{}", " ***nihao*** ");
        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", 12.10));
        pairArrayList.add(new Pair<>("version", 12.19));
        pairArrayList.add(new Pair<>("version", 6.28));
        Map<String, Double> map = pairArrayList.stream().collect(
                // 生成的 map 集合中只有一个键值对：{version=6.28}
                Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(key+"---"+map.get(key));
        }
        System.out.println("-----------");
        Map<String, List<Pair<String, Double>>> map1 = pairArrayList.stream().collect(
                // 生成的 map 集合中只有一个键值对：{version=6.28}
                Collectors.groupingBy(Pair::getKey));
        Iterator<String> iterator1 = map1.keySet().iterator();
        while (iterator1.hasNext()){
            String key = iterator1.next();
            System.out.println(key+"---"+map1.get(key));
        }
        System.out.println("-----------");
    }


}