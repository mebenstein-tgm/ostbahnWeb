package ostbahn.Controller;


import ostbahn.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ostbahn.Entity.Benutzer;

import javax.validation.Valid;

@Controller
public class LoginController {



    @Autowired
    private UserService userService;

    @GetMapping(value = {"/login"})
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        return modelAndView;
    }


    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        Benutzer user = new Benutzer();

        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView createUser(@Valid Benutzer user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Benutzer userExists = userService.findUserByEMail(user.geteMail());

        if (userExists != null)
            bindingResult.rejectValue("email", "error.user", "Account with this email already exists! " + user.geteMail());
        else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Successfully registered");
            modelAndView.addObject("user", new Benutzer());
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }

}