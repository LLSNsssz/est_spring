package net.chimaek.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user/max")
  public User getUser(@PathVariable String key) {
    return userService.getUser(key);
  }

  @GetMapping("/user")
  public String getUser() {
    return "Hello";
  }
}
