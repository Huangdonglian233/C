package com.huang.proxy.demo02;
//真实对象
public class UserServiceProxy implements UserService {
    private UserServiceImp userService;

    public void setUserService(UserServiceImp userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void del() {
        log("del");
        userService.del();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }
    public void log(String msg){
        System.out.println("使用了"+msg+"方法");
    }
}
