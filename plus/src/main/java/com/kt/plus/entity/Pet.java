package com.kt.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
//设置数据表是哪张表
@TableName("pet")
public class Pet {
  //设置主键,和自增,和列名匹配
  @TableId(value = "id",type = IdType.AUTO)
  private long id;
  /*与数据中的字段值匹配*/
  @TableField("pname")
  private String pname;
  private long ptypeid;
  private double pmoney;
  private String psex;
  private String page;

}
