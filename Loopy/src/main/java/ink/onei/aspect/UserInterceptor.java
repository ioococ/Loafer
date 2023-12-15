package ink.onei.aspect;

import ink.onei.dao.IUserDao;
import ink.onei.entity.User;
import ink.onei.exception.UserException;
import org.aspectj.lang.JoinPoint;

/**
 * @Author: nekotako
 * @Description: 用户方法切面
 * @Date: 14/12/2023 15:09 Thursday
 */

//@Aspect
//@Component
public class UserInterceptor {

//    @Autowired
    IUserDao userDao;

//    @Pointcut("execution(public * ink.onei.service.UserService.add(..))")
    public void add() {

    }

//    @Pointcut("execution(public * ink.onei.dao.UserDao.getUserById(..))")
    public void getUserById() {

    }

//    @Before("add()")
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

//    @After("add()")
    public void addAfter(JoinPoint joinPoint) {
        User user = (User) joinPoint.getArgs()[0];
        System.out.println(user.getUsername() + "添加成功");

    }
}
