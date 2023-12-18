package ink.onei.shopping.service;

import ink.onei.shopping.vo.UserDetailVO;

import java.util.List;

public interface IUserService {
    List<UserDetailVO> getUserDetails(Integer pageNum, Integer pageSize);
}
