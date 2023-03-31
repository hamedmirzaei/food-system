package edu.hami.restfulservices.foodsystem.utils;

import edu.hami.restfulservices.foodsystem.model.Order;
import edu.hami.restfulservices.foodsystem.model.Restaurant;
import edu.hami.restfulservices.foodsystem.model.RestaurantStaff;
import edu.hami.restfulservices.foodsystem.model.menu.MenuItem;
import edu.hami.restfulservices.foodsystem.model.payment.PaymentInfo;
import edu.hami.restfulservices.foodsystem.model.person.Customer;
import edu.hami.restfulservices.foodsystem.model.person.Delivery;
import edu.hami.restfulservices.foodsystem.model.person.Staff;
import edu.hami.restfulservices.foodsystem.repository.OrderRepository;
import edu.hami.restfulservices.foodsystem.repository.RestaurantRepository;
import edu.hami.restfulservices.foodsystem.repository.RestaurantStaffRepository;
import edu.hami.restfulservices.foodsystem.repository.menu.MenuItemRepository;
import edu.hami.restfulservices.foodsystem.repository.payment.PaymentInfoRepository;
import edu.hami.restfulservices.foodsystem.repository.person.CustomerDetailsRepository;
import edu.hami.restfulservices.foodsystem.repository.person.CustomerRepository;
import edu.hami.restfulservices.foodsystem.repository.person.DeliveryRepository;
import edu.hami.restfulservices.foodsystem.repository.person.StaffRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
@Profile("dev")
public class DataLoader implements CommandLineRunner {

    private final TestDataGenerator testDataGenerator;
    private final RestaurantRepository restaurantRepository;
    private final StaffRepository staffRepository;
    private final RestaurantStaffRepository restaurantStaffRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final DeliveryRepository deliveryRepository;
    private final MenuItemRepository menuItemRepository;
    private final PaymentInfoRepository paymentInfoRepository;
    private final CustomerDetailsRepository customerDetailsRepository;

    public DataLoader(TestDataGenerator testDataGenerator,
                      RestaurantRepository restaurantRepository,
                      StaffRepository staffRepository,
                      RestaurantStaffRepository restaurantStaffRepository,
                      CustomerRepository customerRepository,
                      OrderRepository orderRepository,
                      DeliveryRepository deliveryRepository, MenuItemRepository menuItemRepository, PaymentInfoRepository paymentInfoRepository, CustomerDetailsRepository customerDetailsRepository) {
        this.testDataGenerator = testDataGenerator;
        this.restaurantRepository = restaurantRepository;
        this.staffRepository = staffRepository;
        this.restaurantStaffRepository = restaurantStaffRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.deliveryRepository = deliveryRepository;
        this.menuItemRepository = menuItemRepository;
        this.paymentInfoRepository = paymentInfoRepository;
        this.customerDetailsRepository = customerDetailsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0 ; i < 100 ; i++) {
            Customer customer = testDataGenerator.generateCustomer();
            customers.add(customer);
        }
        customerRepository.saveAll(customers);
        for(Customer customer: customers) {
            customer.getCustomerDetails().setCustomer(customer);
            customerDetailsRepository.save(customer.getCustomerDetails());
        }

        List<PaymentInfo> paymentInfos = new ArrayList<>();
        Random random = new Random();
        for (Customer customer: customers) {
            int rnd = random.nextInt(2) + 1;
            for (int i = 0 ; i < rnd ; i++) {
                PaymentInfo paymentInfo = testDataGenerator.generatePaymentInfo();
                paymentInfo.setCustomer(customer);
                paymentInfos.add(paymentInfo);
            }
        }
        paymentInfoRepository.saveAll(paymentInfos);

        List<Staff> staffs = new ArrayList<>();
        for (int i = 0 ; i < 50 ; i++) {
            Staff staff = testDataGenerator.generateStaff();
            staffs.add(staff);
        }
        staffRepository.saveAll(staffs);

        List<Restaurant> restaurants = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            Restaurant restaurant = testDataGenerator.generateRestaurant();
            List<Delivery> deliveries = new ArrayList<>();
            for (int j = 0 ; j < 5 ; j++) {
                deliveries.add(testDataGenerator.generateDelivery());
            }
            deliveryRepository.saveAll(deliveries);
            restaurant.setDeliveries(deliveries);
            restaurants.add(restaurant);
        }
        restaurantRepository.saveAll(restaurants);
        for (Restaurant restaurant: restaurants) {
            for (Delivery delivery: restaurant.getDeliveries()) {
                delivery.addRestaurant(restaurant);
            }
            deliveryRepository.saveAll(restaurant.getDeliveries());
            int rnd = random.nextInt(30) + 4;
            List<MenuItem> menuItems = new ArrayList<>();
            for (int i = 0 ; i < rnd ; i++){
                MenuItem menuItem = testDataGenerator.generateMenuItem();
                menuItem.setRestaurant(restaurant);
                menuItems.add(menuItem);
            }
            restaurant.setMenuItems(menuItems);
            menuItemRepository.saveAll(menuItems);
            restaurantRepository.save(restaurant);
        }

        List<RestaurantStaff> restaurantStaffs = new ArrayList<>();
        for (Staff staff: staffs) {
            RestaurantStaff restaurantStaff = new RestaurantStaff();
            restaurantStaff.setStaff(staff);
            int randomIndex = random.nextInt(restaurants.size());
            restaurantStaff.setRestaurant(restaurants.get(randomIndex));
            restaurantStaffs.add(restaurantStaff);
        }
        restaurantStaffRepository.saveAll(restaurantStaffs);

        List<Order> orders = new ArrayList<>();
        for (int i = 0 ; i < 200 ; i++) {
            Order order = testDataGenerator.generateOrder();
            int randomIndex = random.nextInt(restaurants.size());
            order.setRestaurant(restaurants.get(randomIndex));
            restaurants.get(randomIndex).addOrder(order);

            List<MenuItem> menuItems = restaurants.get(randomIndex).getMenuItems();
            Collections.shuffle(menuItems);
            order.setMenuItems(menuItems.subList(0, Math.min(random.nextInt(menuItems.size()), 4)));

            randomIndex = random.nextInt(customers.size());
            order.setCustomer(customers.get(randomIndex));
            customers.get(randomIndex).addOrder(order);

            orders.add(order);
        }

        orderRepository.saveAll(orders);
        customerRepository.saveAll(customers);
        restaurantRepository.saveAll(restaurants);
        staffRepository.saveAll(staffs);
        restaurantStaffRepository.saveAll(restaurantStaffs);
    }
}
