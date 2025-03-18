package com.motoshkin.apptrack.controllers;

import com.motoshkin.apptrack.models.Application;
import com.motoshkin.apptrack.models.Department;
import com.motoshkin.apptrack.models.User;
import com.motoshkin.apptrack.services.ApplicationService;
import com.motoshkin.apptrack.services.DepartmentService;
import com.motoshkin.apptrack.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/applications")
@PreAuthorize("isAuthenticated()")
public class ApplicationsController {
    private final UserService userService;
    private final ApplicationService applicationService;
    private final DepartmentService departmentService;

    public ApplicationsController(UserService userService, ApplicationService applicationService, DepartmentService departmentService) {
        this.userService = userService;
        this.applicationService = applicationService;
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/")
    public String getAppPage(Model model, Authentication authentication) {
        model.addAttribute("userApplication", new Application());

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = user.getId();
        List<Application> userApplications = this.applicationService.getApplicationsOfUser(userId);

        model.addAttribute("userApplications", userApplications);


        return "applications";
    }

    @GetMapping(value = "/addApplication")
    public String goApplication(Model model) {
        model.addAttribute("department", new Department());
        List<Department> allDepartments = this.departmentService.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "application";
    }

    @PostMapping("/addApplication")
    public String addApplication(@RequestParam Integer departmentId, @RequestParam String applicationText) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (applicationService.addApplication(user, departmentId, applicationText))
            return "redirect:/applications/";

        return "redirect:/badPage";
    }

    @GetMapping("/delete/{id}")
    public String deleteApplication(@PathVariable("id") Long id) {
        applicationService.deleteApplication(id);

        return "redirect:/applications/";
    }

}
