package kimiko.demo.controller;
import kimiko.demo.dto.UserDto;
import kimiko.demo.entity.User;
import kimiko.demo.security.services.SecurityService;
import kimiko.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    UserService userService;
    @Autowired
    SecurityService securityService;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/login");
        return modelAndView;
    }

    @RequestMapping(value="/registration",method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        UserDto user = new UserDto();
        modelAndView.setViewName("auth/registration");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") UserDto user, BindingResult result){
        User existingUser = userService.findUserByEmail(user.getEmail());
        if(existingUser!=null){
            result.rejectValue("email","error.user","Cet email a déjà un compte enregistré.");
        }
        if(result.hasErrors()){
            return "auth/registration";
        }
        userService.saveUser(user);
        securityService.doLogin(user.getEmail(),user.getPassword());
        return "redirect:/";
    }

}
