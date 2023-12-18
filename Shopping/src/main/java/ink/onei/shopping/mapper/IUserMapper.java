package ink.onei.shopping.mapper;

import ink.onei.shopping.entity.User;
import ink.onei.shopping.vo.UserDetailVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserMapper {
    List<User> getUserList(@Param("pageNum") Integer pageNum, @Param("pageSize")Integer pageSize);
    List<UserDetailVO> getUserDetails(@Param("idList") List<Integer> idList);
}
