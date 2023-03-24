package edu.hami.restfulservices.foodsystem.utils;

import edu.hami.restfulservices.foodsystem.repository.RestaurantRepository;
import edu.hami.restfulservices.foodsystem.repository.person.StaffRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev, test"})
public class DataLoader implements CommandLineRunner {
    private final StaffRepository staffRepository;
    private final RestaurantRepository restaurantRepository;

    private final TestDataGenerator testDataGenerator;

    public DataLoader(StaffRepository staffRepository,
                      RestaurantRepository restaurantRepository,
                      TestDataGenerator testDataGenerator) {
        this.staffRepository = staffRepository;
        this.restaurantRepository = restaurantRepository;
        this.testDataGenerator = testDataGenerator;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
