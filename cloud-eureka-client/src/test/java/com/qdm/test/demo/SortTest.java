package com.qdm.test.demo;

import com.google.common.collect.Lists;
import com.qdm.model.vo.TableVo;
import org.junit.Test;

import java.util.*;

/**
 * @author qiudm
 * @date 2018/4/27 14:40
 * @desc
 */
public class SortTest {

    @Test
    public void sortTest() {

        List<TableVo> tableVoList1 = new ArrayList<TableVo>(){{




        }};


        List<TableVo> tableVoList = new ArrayList<TableVo>(){{
            add(new TableVo(1001,"a", 3L));
            add(new TableVo(1002,"b", 5L));
            add(new TableVo(1006,"a", 2L));
            add(new TableVo(1007,"a", 7L));
            add(new TableVo(1004,"a", 6L));
            add(new TableVo(1005,"b", 1L));
            add(new TableVo(1009,"a", 4L));
        }};


        Collections.sort(tableVoList, Comparator.comparing(TableVo::getSort).reversed());

        //排序后
        for(TableVo tableVo : tableVoList) {
            System.out.println("tableVo.toString() = " + tableVo.toString());
        }
        tableVoList = tableVoList.subList(0,5);
        System.out.println(" 切割后= = = = = =" );
        //切割后
        for(TableVo tableVo : tableVoList) {
            System.out.println("tableVo.toString() = " + tableVo.toString());
        }

        String maxa = null;
        String maxb = null;

        for(int i=tableVoList.size()-1; i>0; i--) {
            if(Objects.equals(tableVoList.get(i).getName(), "a") && maxa == null) {
                maxa = tableVoList.get(i).getId() + "";
            }

            if(Objects.equals(tableVoList.get(i).getName(), "b") && maxb == null) {
                maxb = tableVoList.get(i).getId() + "";
            }
            if(Objects.nonNull(maxa) && Objects.nonNull(maxb)) {
                break;
            }
        }

        System.out.println("maxa = " + maxa);
        System.out.println("maxb = " + maxb);









    }



}
