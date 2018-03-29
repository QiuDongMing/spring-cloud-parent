package com.qdm.test.demo;

/**
 * @author qiudm
 * @date 2018/3/28 9:41
 * @desc
 */
public class Student {

    private Integer id;

    private String name;

    private Integer score;

    public Student() {
    }

    public Student(Integer id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
