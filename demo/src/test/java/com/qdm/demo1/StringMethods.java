package com.qdm.demo1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author qiudm
 * @date 2018/3/22 14:34
 * @desc
 */
public class StringMethods {

    @Test
    public void join() {
        Set<String> params = new HashSet<>();
        params.add("a");
        params.add("b");
        params.add("c");

        List<String> listParams = new ArrayList<>();
        listParams.add("a");
        listParams.add("b");
        listParams.add("c");
        listParams.add("d");

        String s = String.join(",", listParams);
        System.out.println("s = " + s);
    }




}
