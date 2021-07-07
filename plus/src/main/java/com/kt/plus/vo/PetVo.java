package com.kt.plus.vo;


import lombok.Data;

@Data
public class PetVo {
    /**
     * 宠物id主键自增长
     */
    private long id;
    /**
     * 宠物名称
     */
    private String pname;
    /**
     * 宠物类型
     */
    private long ptypeid;
    /**
     * 价格
     */
    private double pmoney;
    /**
     * 宠物性别
     */
    private String psex;
    /**
     * 宠物年龄
     */
    private String page;
    /**
     * 类型id主键自增长
     */
    private long tid;
    /**
     * 类型名称
     */
    private String tname;
}
