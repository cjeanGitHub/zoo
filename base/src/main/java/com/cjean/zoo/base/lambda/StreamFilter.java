package com.cjean.zoo.base.lambda;


import com.cjean.zoo.base.domian.User01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    static void testFilterEntity(){
        User01 user01 = new User01();
        user01.setId(1);
        user01.setName("tom");
        user01.setAge(11);
        User01 user02 = new User01();
        user02.setId(1);
        user02.setName("tom");
        user02.setAge(11);
        User01 user21 = new User01();

        List<User01> todayNew = new ArrayList<>();
        todayNew.add(user01);
        todayNew.add(user02);

        List<User01> todayNew2 = new ArrayList<>();


    }
}
