package org.example.springboot.controller;


import org.example.springboot.model.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.example.springboot.model.User;
import org.example.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {


    @Autowired
    private LoginService loginService;


    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }


    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") User user,Model model ){
        System.out.println("from signup"+user);
        if(loginService.register(user)){
            return "redirect:/home";
        }
        model.addAttribute("error", "No user");
        return "signup";
    }


//    @GetMapping("/login")
//    public String login(Model model){
//        model.addAttribute("user", new User());
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute("user") User user,Model model ){
//
//        if(loginService.login(user)){
//            return "redirect:/home";
//        }
//        model.addAttribute("error", "Invalid credentials");
//        return "login";
//    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Long userId = userDetails.getUserid();
        model.addAttribute("name" ,authentication.getName() );
        model.addAttribute("isAuthenticated" ,authentication.isAuthenticated() );
        model.addAttribute("roles" ,authentication.getAuthorities() );
        model.addAttribute("id" ,userId);

        return "CheckRole";
    }


    @GetMapping("/role")
    public String role() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        boolean isAuthenticated = authentication.isAuthenticated();
        return "username" + " " + username + " " +"authorities" + " " + authentication.getAuthorities() + "isAuthenticated" + " " +isAuthenticated;
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String user(){
        return "check";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "check";
    }

    @GetMapping("/author")
    @PreAuthorize("hasRole('AUTHOR')")
    public String author(){
        return "check";
    }


    @GetMapping("/accessdenied")
    public String accessDenied(){
        return "accessdenied";
    }
//k
}
