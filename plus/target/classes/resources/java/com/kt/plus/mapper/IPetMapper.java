package com.kt.plus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kt.plus.entity.Pet;
import com.kt.plus.vo.PetVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 接口名称: IPetMapper
 * 接口描述: 持久层宠物表
 * 创建人:李宣宏
 * 创建时间: 2020/12/10 14:27
 */
@Mapper   // extends BaseMapper<Pet>
public interface IPetMapper extends BaseMapper<Pet> {
    //@Param("page") Page<PetVo> page:只要mapper层方法存在page参数，并且参数名称叫page,
    // myBatis plus会自动拼接分页关键字，并且会自动根据自己写的sql生成(统计总行数的Sql语句)并且执行
    //多表模糊查询,分页
    //如果 Page对象不放在第一个 就会报错，获取不到IPage对象
    IPage<PetVo> findPetVo( @Param("page") Page<PetVo> page,@Param("petVo") PetVo petVo);
}
