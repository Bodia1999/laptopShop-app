package bohdan.papizhanskiy.laptops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@Controller
public class HtmlPageController {

    @RequestMapping("/main")
        public String mainPage(){
            return "main.page/index.html";
    }
//    @RequestMapping("/")
//        public String mainPage(){
//            return "main.page/profile.html";
//    }

//    @RequestMapping("/")
//    public String productPage(){
//        return "main.page/productPage.html";
//    }
//
    @RequestMapping("/sign")
    public String singPage(){
        return "main.page/sign.html";
    }

    @RequestMapping("/profile")
public String profilePage(){
        return "main.page/profile.html";
    }
//    @RequestMapping("/")
//    public String registration(){
//        return "main.page/registration.html";
//    }
//    @RequestMapping("/")
//    public String mainPage(){
//        return "main.html";
//    }
}
