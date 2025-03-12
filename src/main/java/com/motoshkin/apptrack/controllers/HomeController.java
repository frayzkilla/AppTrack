package com.motoshkin.apptrack.controllers;

import com.motoshkin.apptrack.models.User;
import com.motoshkin.apptrack.services.ApplicationService;
import com.motoshkin.apptrack.services.DepartmentService;
import com.motoshkin.apptrack.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/")
    public String index() {

        return "home";
    }

    @GetMapping("/users")
    public String getUsersPage(Model model) {

        model.addAttribute("users", userService.getAllUsers());

        return "users";
    }

    @GetMapping(value = "/login")
    public String goAuth() {
        return "login";
    }

    @GetMapping(value = "/badPage")
    public String goBad() {
        return "badPage";
    }

    @GetMapping(value = "/news")
    public String goNews() {
        return "news";
    }

    @GetMapping(value = "/contacts")
    public String goContacts() {
        return "contacts";
    }


    @GetMapping(value = "/register")
    public String goRegister() {
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute User user, HttpServletRequest request,
                           @CurrentSecurityContext SecurityContext securityContext) {
        userService.save(user);

        //Program authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user, user.getPassword(), user.getAuthorities());

        securityContext.setAuthentication(authentication);

        // Create a new session and add the security context.
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
        return "redirect:/";
    }


}