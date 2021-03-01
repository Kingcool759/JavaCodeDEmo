package com.example.javacode;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap基础用法
 */
public class HashMapBaseUse {

    public static void main(String[] args) {

        //测试方法
        System.out.println("hello world~"); //hello world~

        /**
         * HashMap的存值方法：
         * .put(k,v)，
         * return : 这个key以前对应的value值,如果没有返回null
         */
        HashMap<Integer, String> companyMap = new HashMap<>();
        System.out.println(companyMap.put(1, "腾讯")); //null
        companyMap.put(1, "腾讯");
        companyMap.put(1, "字节");
        companyMap.put(2, "百度");
        companyMap.put(3, "阿里");
        System.out.println(companyMap); //{1=字节, 2=百度, 3=阿里}
        System.out.println(companyMap.put(2, "快手")); //"百度"

        /**
         * HashMap的取值方法：
         * .get(k)，
         * return : 这个key当前对应的value值，如果没有返回null
         */
        System.out.println(companyMap.get(1));  //字节

        /**
         * HashMap的判空方法：
         * .isEmpty(），
         * return : boolean值
         */
        HashMap<Integer, String> starHashMap = new HashMap<>();
        System.out.println(starHashMap.isEmpty());  //true
        starHashMap.put(1, "詹姆斯");
        System.out.println(starHashMap.isEmpty());  //false

        /**
         * HashMap判断是否含有key：
         * .containsKey(k)，
         * return : boolean值
         */
        System.out.println(companyMap.containsKey(4));  //false
        companyMap.put(4, "高德");
        System.out.println(companyMap.containsKey(4));  //true

        /**
         * HashMap判断是否含有value：
         * .containsValue("value")，
         * return : boolean值
         */
        System.out.println(companyMap.containsValue("头条"));  //false
        companyMap.put(5,"头条");
        System.out.println(companyMap.containsValue("头条"));  //true

        /**
         * HashMap删除这个key值下的value值:
         * .remove(5),
         * return : 删除的value值
         */
        System.out.println(companyMap.remove(5));  //"头条"

        /**
         * Hashmap显示所有的value值:
         * .values()
         * return : array(所有的value值)
         */
        System.out.println(companyMap.values());  //[字节, 快手, 阿里, 高德]

        /**
         * Hashmap的元素个数:
         * .size()
         * return : int
         */
        System.out.println(companyMap.size());  //4

        /**
         * HashMap显示所有的key:
         * .keySet()
         * return : array(所有的key值)
         */
        System.out.println(companyMap.keySet());  //[1, 2, 3, 4]

        /**
         * Hashmap显示所有的key和value：
         * .entrySet()
         * return : array(形如：key = value)
         */
        System.out.println(companyMap.entrySet()); //[1=字节, 2=快手, 3=阿里, 4=高德]

        /**
         * Hashmap添加另一个同一类型的map下的所有制：key值相同则被覆盖，不同则新增
         * .putAll(hashMap)
         * return : Map
         */
        //hashMap1
        HashMap<Integer,String> hashMap1 = new HashMap<>();
        hashMap1.put(1,"aaa");
        hashMap1.put(2,"bbb");
        //hashMap2
        HashMap<Integer,String> hashMap2 = new HashMap<>();
        hashMap2.put(1,"111");
        hashMap2.put(3,"222");
        System.out.println(hashMap1);  //{1=aaa, 2=bbb}
        hashMap1.putAll(hashMap2);
        System.out.println(hashMap1);  //{1=111, 2=bbb, 3=222}

        /**
         * Hashmap删除这个key-value键值对：
         * .remove(key,value)
         * return : boolean
         */
        System.out.println(companyMap);  //{1=字节, 2=快手, 3=阿里, 4=高德}
        System.out.println(companyMap.remove(4,"高德"));  //true
        System.out.println(companyMap);;  //{1=字节, 2=快手, 3=阿里}

        /**
         * Hashmap替换这个key的value：(java8)
         * .replace(key,value)
         * return : value (被替换调的value值)
         */
        System.out.println(companyMap);  //{1=字节, 2=快手, 3=阿里}
        System.out.println(companyMap.replace(3,"蘑菇街"));  //阿里
        System.out.println(companyMap);  //{1=字节, 2=快手, 3=蘑菇街}

        /**
         * HashMap清空：
         * .clear()
         * return : hashmap
         */
        System.out.println(starHashMap); //{1=詹姆斯}
        starHashMap.clear();
        System.out.println(starHashMap); //{}

        /**
         * Hashmap的克隆：
         * .clone()
         * return : hashmap
         */
        System.out.println(companyMap);  //{1=字节, 2=快手, 3=蘑菇街}
        System.out.println(companyMap.clone());  //{1=字节, 2=快手, 3=蘑菇街}
        Object clone = companyMap.clone();
        System.out.println(clone);  //{1=字节, 2=快手, 3=蘑菇街}

        /**
         * 如果当前 Map 不存在键 key 或者该 key 关联的值为 null，那么就执行 put(key, value)；否则，便不执行 put 操作：（java8新增方法）:
         * .putIfAbsent(key,value)
         * return : value
         */
        System.out.println(companyMap); //1=字节, 2=快手, 3=蘑菇街}
        System.out.println(companyMap.putIfAbsent(3,"猿辅导")); //蘑菇街
        System.out.println(companyMap); //{1=字节, 2=快手, 3=蘑菇街}
        System.out.println(companyMap.putIfAbsent(4,"猿辅导")); //null,key = 4对应之前的value
        System.out.println(companyMap);  //{1=字节, 2=快手, 3=蘑菇街, 4=猿辅导}
    }

    private void hashMapBaseUse(){

    }
}