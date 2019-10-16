package project_up.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {


//    @GetMapping
//    public String main()
//    {
//        return "home";
//    }
//
//    @PostMapping("/main")
//    public String main1()
//    {
//        return "main";
//    }
//    @PostMapping("login")
//    public String log(){
//        return  "login";
//    }
@GetMapping(value = {"/", "/home"})
public String home() {
    return "/home";
}

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}
