package ink.onei.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ink.onei.dto.Message;
import ink.onei.entity.User;
import ink.onei.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 20/12/2023 15:30 Wednesday
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpSession session;

    private Message message;
    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/login")
    @ResponseBody
    public String login(User user) {
        User u = userService.getUserDynamic(user);
        if (u == null) {
            message = new Message(-1, "用户不存在");
            try {
                return objectMapper.writeValueAsString(message);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            session.setAttribute("user", u);
            message = new Message(1, "登陆成功");
            try {
                return objectMapper.writeValueAsString(message);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @RequestMapping("/userList")
    public String userList(){
        return "WEB-INF/info";
    }
    @RequestMapping("/info")
    @ResponseBody
    public String info() throws JsonProcessingException {
        List<User> allUsers = userService.getAllUsers();
        String users = objectMapper.writeValueAsString(allUsers);
        return users;
    }
}
