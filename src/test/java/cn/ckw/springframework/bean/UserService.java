package cn.ckw.springframework.bean;

import static org.junit.Assert.*;

/**
 * 在 UserService 中注入 UserDao，这样就能体现出Bean属性的依赖
 */
public class UserService {
    private String uId;

    private UserDao userDao;

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}