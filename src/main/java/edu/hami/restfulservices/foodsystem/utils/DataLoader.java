package edu.hami.restfulservices.foodsystem.utils;

import edu.hami.restfulservices.foodsystem.model.enums.Position;
import edu.hami.restfulservices.foodsystem.model.person.Staff;
import edu.hami.restfulservices.foodsystem.repository.person.StaffRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final StaffRepository staffRepository;

    public DataLoader(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Staff staff = new Staff();
        staff.setId(1L);
        staff.setFirstName("Hamed");
        staff.setLastName("Mirzaei");
        staff.setSalary(2500.0);
        staff.setPosition(Position.MANAGER);

        staffRepository.save(staff);
    }
}
