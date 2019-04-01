//package bohdan.papizhanskiy.laptops.controller;
//
//import bohdan.papizhanskiy.laptops.dto.request.UserRequest;
//import bohdan.papizhanskiy.laptops.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@CrossOrigin
//@RestController
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/public/register")
//    public String saveUser(@RequestBody UserRequest userRequest) throws Exception {
//        return userService.save(userRequest);
//    }
//
//    @PostMapping("/public/login")
//    public String login(@RequestBody UserRequest userRequest) throws Exception {
//        return userService.findOneByRequest(userRequest);
//    }
//}
