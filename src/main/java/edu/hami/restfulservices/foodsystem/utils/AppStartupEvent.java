package edu.hami.restfulservices.foodsystem.utils;

import edu.hami.restfulservices.foodsystem.model.person.Staff;
import edu.hami.restfulservices.foodsystem.repository.person.StaffRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final StaffRepository staffRepository;

    public AppStartupEvent(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Staff> staffs = this.staffRepository.findAll();
        staffs.forEach(System.out::println);
    }
}
