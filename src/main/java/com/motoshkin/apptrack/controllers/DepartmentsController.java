package com.motoshkin.apptrack.controllers;

import com.motoshkin.apptrack.models.Application;
import com.motoshkin.apptrack.models.ApplicationStates;
import com.motoshkin.apptrack.models.Department;
import com.motoshkin.apptrack.models.User;
import com.motoshkin.apptrack.services.ApplicationService;
import com.motoshkin.apptrack.services.DepartmentService;
import com.motoshkin.apptrack.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Transactional
@Controller
@RequestMapping("/department")
@PreAuthorize("isAuthenticated()")
public class DepartmentsController {
    private final UserService userService;
    private final ApplicationService applicationService;
    private final DepartmentService departmentService;

    public DepartmentsController(UserService userService, ApplicationService applicationService, DepartmentService departmentService) {
        this.userService = userService;
        this.applicationService = applicationService;
        this.departmentService = departmentService;
    }

    @GetMapping(value = "/")
    public String getDeptPage(Model model, Authentication authentication) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Department department = departmentService.loadDepartmentById(userService.getDeptId(user.getId()));
        Long departmentNumber = department.getId();
        String departmentName = department.getName();

        model.addAttribute("departmentNumber", departmentNumber);
        model.addAttribute("departmentName", departmentName);
        model.addAttribute("deptApplication", new Application());
        model.addAttribute("deptApplications", applicationService.getApplicationsOfDepartment(department.getId()));


        return "department";
    }

    @GetMapping("/edit/{id}")
    public String editApplication(@PathVariable("id") Long id, Model model) {
        model.addAttribute("userApp", applicationService.getById(id));
        model.addAttribute("states", ApplicationStates.values());
        model.addAttribute("state", new String());

        return "editApplication";
    }

    @PostMapping("/update/{id}")
    public String updateApplication(@PathVariable("id") Long id, @RequestParam ApplicationStates state) {
        Application application = applicationService.getById(id);
        application.setState(state);

        return "redirect:/department/";
    }


}
