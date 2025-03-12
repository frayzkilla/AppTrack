package com.motoshkin.apptrack.services;

import com.motoshkin.apptrack.models.Application;
import com.motoshkin.apptrack.models.ApplicationStates;
import com.motoshkin.apptrack.models.User;
import com.motoshkin.apptrack.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application getById(Long id) {
        return applicationRepository.getById(id);
    }

    public List<Application> getApplicationsOfUser(Long userId) {
        return applicationRepository.findAllByUserId(userId);
    }

    public List<Application> getApplicationsOfDepartment(Long deptId) {
        return applicationRepository.findAllByDepartmentId(deptId);
    }

    public boolean addApplication(User userId, Integer departmentId, String applicationText) {
        LocalDate today = LocalDate.now();
        Application application = new Application();
        application.setText(applicationText);
        application.setState(ApplicationStates.ПРИНЯТО);
        application.setUser(userId);
        application.setDate(today.toString());
        application.setDepartment(departmentService.loadDepartmentById(departmentId));
        applicationRepository.save(application);

        return true;
    }

    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    public List<String> getAllApplicationsId() {
        List<Application> applications = applicationRepository.findAll();
        List<String> applicationsId = new ArrayList<>();

        for (int i = 0; i < applications.size(); i++) {
            applicationsId.add(String.valueOf(applications.get(i).getId()));
        }

        return applicationsId;
    }

    public List<String> getAllApplicationsDates() {
        List<Application> applications = applicationRepository.findAll();
        List<String> applicationsDates = new ArrayList<>();

        for (int i = 0; i < applications.size(); i++) {
            applicationsDates.add(String.valueOf(applications.get(i).getDate()));
        }

        return applicationsDates;
    }

    public List<String> getAllApplicationsStates() {
        List<Application> applications = applicationRepository.findAll();
        List<String> applicationsStates = new ArrayList<>();

        for (int i = 0; i < applications.size(); i++) {
            applicationsStates.add(String.valueOf(applications.get(i).getState()));
        }

        return applicationsStates;
    }


}