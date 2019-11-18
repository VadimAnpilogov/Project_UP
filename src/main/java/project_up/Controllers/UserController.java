package project_up.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project_up.Entity.User;
import project_up.Repository.PersonalUserRepository;
import project_up.Repository.UserRepository;

import java.util.Map;

@Controller
public class UserController {
    public String username1="One";
    @Autowired
    private PersonalUserRepository userRepository;

    @GetMapping("/PersonalUser")
    public String personalUser(Map<String, Object> model){

        Iterable<User> user1 = userRepository.findByUsername(username1);
        model.put("users", user1);
        return "PersonalUser";
    }


    @GetMapping("FilterUsernameUser/{username}")
    public String FilterFioUser (@PathVariable String username, Map<String, Object> model){
        username1 = username;
        Iterable<User> user1 = userRepository.findByUsername(username);
        model.put("users", user1);

        return "redirect:/PersonalUser";
    }



}
