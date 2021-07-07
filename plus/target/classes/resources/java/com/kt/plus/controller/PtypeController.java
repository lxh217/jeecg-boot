package com.kt.plus.controller;

import com.kt.plus.entity.Ptype;
import com.kt.plus.service.IPtypeService;
import com.kt.plus.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类名称:PtypeController
 * 类描述:TODO
 * 创建人:李宣宏
 * 创建时间 : 2020/12/12 14:01
 */
@RestController
public class PtypeController {
    @Resource
    private IPtypeService iPtypeService;
    @GetMapping("/listPtype")
   public Result<List<Ptype>> listPtype(){
        Result<List<Ptype>> result=new Result<List<Ptype>>();
        result.setResult(iPtypeService.list());
        return result;
    }
}
