package com.kt.plus.service.impl;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kt.plus.entity.Pet;
import com.kt.plus.mapper.IPetMapper;
import com.kt.plus.service.IPetService;
import com.kt.plus.vo.PetVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类名称:PetServiceImpl
 * 类描述:TODO
 * 创建人:李宣宏
 * 创建时间 : 2020/12/10 14:37
 */
@Service
public class PetServiceImpl extends ServiceImpl<IPetMapper, Pet> implements IPetService {
    @Resource
    private IPetMapper iPetMapper;
    @Override
    public IPage<PetVo> findPetVo(Page<PetVo> page,PetVo petVo) {
        return iPetMapper.findPetVo(page,petVo);
    }
}
