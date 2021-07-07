package com.kt.plus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kt.plus.entity.Pet;
import com.kt.plus.vo.PetVo;
import org.apache.ibatis.annotations.Param;

/**
 * 接口名称: IPetService
 * 接口描述: TODO
 * 创建人:李宣宏
 * 创建时间: 2020/12/10 14:32
 */
//extends BaseMapper<Pet>  mapper层
// extends IService<Pet>   service层
public interface IPetService extends IService<Pet> {
    IPage<PetVo> findPetVo( @Param("page") Page<PetVo> page,@Param("petVo") PetVo petVo);

}
