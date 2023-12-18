package ink.onei.aspect;

import ink.onei.annotation.Clear;
import ink.onei.mapper.IUserDao;
import ink.onei.entity.User;
import ink.onei.exception.UserException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @Author: nekotako
 * @Description: 用户增强类
 * @Date: 14/12/2023 15:09 Thursday
 */

@Aspect
@Component
public class UserInterceptor {

    @Autowired
    IUserDao userDao;

    @Pointcut("execution(public * ink.onei.service.UserService.add(..))")
    public void add() {

    }

    @Pointcut("execution(public * ink.onei.dao.UserDao.getUserById(..))")
    public void getUserById() {

    }

    @Before("add()")
    public void addBefore(JoinPoint joinPoint) {
        User user = (User) joinPoint.getArgs()[0];
        // 用户存在则抛出用户已存在异常
        try {
            User existUser = userDao.getSingleUser(user.getUsername(), "%");
            if (user.getUsername().equals(existUser.getUsername())) {
                throw new UserException("用户已存在");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @After("add()")
    public void addAfter(JoinPoint joinPoint) {
        User user = (User) joinPoint.getArgs()[0];
        System.out.println(user.getUsername() + "添加成功");

    }

    @After("getUserById()")
    public void clearPassword(JoinPoint joinPoint) {
        Object arg = null;
        try {
            arg = joinPoint.getArgs()[0];
            Object target = joinPoint.getTarget();

            System.out.println(target.getClass());
            Class<?> aClass = arg.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields) {
                Clear clear = field.getAnnotation(Clear.class);
                if (clear != null && clear.clearStatus()) {
                    field.setAccessible(true);
                    field.set(arg, null);
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
