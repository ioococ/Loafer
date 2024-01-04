package ink.onei.bootstarter.controller;

import ink.onei.bootstarter.entity.User;
import ink.onei.bootstarter.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2024-01-04 09:33:58
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private IUserService userService;

//    @GetMapping("userList")
//    public List<User> userList(User user, Model model) {
//        List<User> userList = userService.getUserList(user);
//        model.addAttribute("userList",userList);
//        return userList;
//    }

    @RequestMapping("list")
    public String userList(User user, Model model) {
        List<User> userList = userService.getUserList(user);
        model.addAttribute("userList",userList);
        return "list";
    }

    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

}

