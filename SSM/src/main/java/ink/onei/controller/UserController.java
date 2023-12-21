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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
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
    public String login(User user) throws JsonProcessingException {
        User u = userService.getUserDynamic(user);
        if (u == null) {
            message = new Message(-1, "用户不存在");
            return objectMapper.writeValueAsString(message);
        } else {
            session.setAttribute("user", u);
            message = new Message(1, "登陆成功");
            return objectMapper.writeValueAsString(message);
        }
    }

    @RequestMapping("user/list")
    public String userList() {
        List<User> allUsers = userService.getAllUsers();
        session.setAttribute("users", allUsers);
        return "WEB-INF/info";
    }

    @RequestMapping("/getDetail")
    public String getDetail() {
        List<User> allUsers = userService.getAllUsers();
        session.setAttribute("users", allUsers);
        return "WEB-INF/info";
    }

    @RequestMapping("user/detail")
    public String detail(User user) {
        user = userService.getUserDynamic(user);
        session.setAttribute("userDetail", user);
        return "WEB-INF/detail";
    }

    @RequestMapping("user/modify")
    @ResponseBody
    public String modify(MultipartFile file) {
        String filename = file.getOriginalFilename();
        User userDetail = (User) session.getAttribute("userDetail");
        userDetail.setAvatar(filename);
        userService.updateUserDynamic(userDetail);
        File localFile = new File("C:\\Users\\荣耀\\IdeaProjects\\Loafer\\SSM\\src\\main\\resources\\avatars" + File.separator + filename);
        try {
            file.transferTo(localFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filename;
    }
}
