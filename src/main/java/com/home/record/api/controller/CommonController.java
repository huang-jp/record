package com.home.record.api.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.home.record.entity.GoWithFriend;
import com.home.record.entity.User;
import com.home.record.service.FileService;
import com.home.record.service.GoWithFriendService;
import com.home.record.service.TourCityService;
import com.home.record.service.UserService;
import com.home.record.common.Result;
import com.home.record.vo.TourCityVo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Resource
    private UserService userService;

    @Resource
    private FileService fileService;

    @Resource
    private GoWithFriendService goWithFriendService;

    @Resource
    private TourCityService tourCityService;

    /**
     * 登陆方法
     * @param user
     * @return
     */
    @PostMapping("/user/login")
    public Result login(@RequestBody User user){
        //在数据库中查询与传来的用户名和密码系统的数据
        User res = userService.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername,user.getUsername()).eq(User::getPassword,user.getPassword()));
        if (res==null){
            return Result.error("-1","用户名或密码错误");
        }else {
            return Result.success(res);
        }
    }

    /**
     * 注册方法
     * @param user
     * @return
     */
    @PostMapping("/user/register")
    public Result Register(@RequestBody User user){
        //在数据库中查询与传来的用户名和密码系统的数据
        User res = userService.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername,user.getUsername()));
        if (res!=null){
            return Result.error("-1","用户名重复");
        }else {
            userService.insert(user);
            return Result.success(res);
        }
    }


    /**
     * 新增数据操作
     *
     * @param user
     * @return
     */
    @Transactional
    @PostMapping("/user/add")
    //@RequestBody注解，将传入的json数据转换为对象
    public Result saveUser(@RequestBody User user) {
        int i = userService.saveUser(user);
        if(i==-1){
            return Result.error("-1","用户名重复");
        }
        return Result.success(i);
    }

    /**
     * 根据ID删除数据
     * @param
     * @return
     */
    @Transactional
    @DeleteMapping("/user/del/{userId}")
    public Result deleteUser(@PathVariable Integer userId){
        userService.deleteById(userId);
        return Result.success();
    }

    /**
     * 分页查询User表
     * 根据前端传来的搜索值进行模糊擦查询
     *
     * @param pageNum
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/user/findPage")
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String search) {
        Page<User> page = userService.selectPage(pageNum, pageSize, search);
        return Result.success(page);
    }

    @GetMapping("/city/tourCityPage")
    public Result tourCityPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String search,
                           @RequestParam(defaultValue = "") String strTime,
                           @RequestParam(defaultValue = "") String endTime) {
        Page<TourCityVo> page = tourCityService.tourCityPage(pageNum, pageSize, search, strTime, endTime);
        return Result.success(page);
    }

    @PostMapping("/city/selectCity")
    public Result selectCity(@RequestBody String level){
        return Result.success(tourCityService.getById(level));
    }

    @GetMapping("/welcome")
    public Result welcome() {
        return Result.success(fileService.welcomeImg());
    }

    @GetMapping("/friend/friendPage")
    public Result friendPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String search,
                           @RequestParam(defaultValue = "") String placeList) {
        Page<GoWithFriend> page = goWithFriendService.selectPage(pageNum, pageSize, search, placeList);
        return Result.success(page);
    }

    @PostMapping("/friend/placeList")
    public Result placeList() {
        return Result.success(goWithFriendService.placeList());
    }

}
