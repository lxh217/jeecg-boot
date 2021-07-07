package com.kt.plus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kt.plus.entity.Pet;
import com.kt.plus.service.IPetService;
import com.kt.plus.util.Result;
import com.kt.plus.vo.PetVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类名称:IndexController
 * 类描述:TODO
 * 创建人:李宣宏
 * 创建时间 : 2020/12/10 14:49
 */
@RestController
public class PetController {
    @Resource
    private IPetService iPetService;
    //单表模糊查询,分页
    //这里面Page 是 Ipage
    @GetMapping("/list")
    public Result<IPage<Pet>> list(Pet pet,
                                   @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                   @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize){
        Result<IPage<Pet>> result=new Result<IPage<Pet>>();
        //QueryWrapper：查询条件构造器
        //封装查询条件
        QueryWrapper<Pet> queryWrapper=new QueryWrapper<Pet>();
        //column:列名(实体类)  val:值 like():模糊查询,装入值,可装入多个
        queryWrapper.like("pname",pet.getPname());
        //如果满足什么条件不拼接查询条件的话(就是说你要判断什么,就自己写什么queryWrapper.方法名)，需要自己判断处理   eq()等于
        if(pet.getPmoney()>0){
            queryWrapper.eq("petSex",pet.getPmoney());
        }
        //封装分页参数对象
        Page<Pet> page=new Page<Pet>(pageNo,pageSize);
        //调用分页查询的方法  page():分页
        result.setResult(iPetService.page(page,queryWrapper));
        return result;
        }

        //普通模糊查询 多条件查询自己写
        /*
        * 多条件查询
        * //封装查询条件
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        queryWrapper.eq("uname",user.getUname());
        queryWrapper.eq("upwd",user.getUpwd());
        * */
        @GetMapping("/find")
        public Result<List<Pet>> find(Pet pet){
            Result<List<Pet>> result=new Result<>();
            //封装查询条件
            QueryWrapper<Pet> queryWrapper=new QueryWrapper<Pet>();
            //column:列名(实体类)  val:值 like():模糊查询,装入值,可装入多个
            queryWrapper.like("pname",pet.getPname());
            result.setResult(iPetService.list(queryWrapper));
            return result;
        }
        //普通查询
        @GetMapping("/index")
        public Result<List<Pet>> index(){
            Result<List<Pet>> result=new Result<>();
            result.setResult(iPetService.list());
            return result;
        }
        //新增数据
        @PostMapping("/add")
        public Result add(@RequestBody Pet pet){
            Result result=new Result();
            boolean bool=iPetService.save(pet);
            if (bool){
                result.ok("新增成功");
            }else{
                result.error("新增失败");
            }
            return result;
        }
    //修改数据
    @PostMapping("/upd")
    public Result upd(@RequestBody Pet pet){
        Result result=new Result();
        boolean bool=iPetService.updateById(pet);
        if (bool){
            result.ok("修改成功");
        }else{
            result.error("修改失败");
        }
        return result;
    }
    //删除数据
    @GetMapping("/del")
    public Result del(int id){
        Result result=new Result();
        boolean bool=iPetService.removeById(id);
        if (bool){
            result.ok("删除成功");
        }else{
            result.error("删除失败");
        }
        return result;
    }
    //多表条件查询,分页
    @GetMapping("/findPetVo")
    public Result<IPage<PetVo>> findPetVo(PetVo petVo,
                                          @RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                          @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize){
        Result<IPage<PetVo>> result = new Result<IPage<PetVo>>();
        Page<PetVo> page = new Page<PetVo>(pageNo,pageSize);
        //如果 Page对象不放在第一个 就会报错，获取不到IPage对象
        IPage<PetVo> iPage = iPetService.findPetVo(page,petVo);
        result.setResult(iPage);
        return result;
    }
}

