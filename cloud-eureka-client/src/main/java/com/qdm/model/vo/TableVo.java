package com.qdm.model.vo;

/**
 * @author qiudm
 * @date 2018/4/26 18:51
 * @desc
 */
public class TableVo {

    private Integer id;

    private String name;

    private Long createTime;

    private Long sort;

    public TableVo(Integer id, String name, Long sort) {
        this.id = id;
        this.name = name;
        this.sort = sort;
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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }


    @Override
    public String toString() {
        return "TableVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", sort=" + sort +
                '}';
    }
}
