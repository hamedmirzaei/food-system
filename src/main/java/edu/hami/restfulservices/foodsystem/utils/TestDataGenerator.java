package edu.hami.restfulservices.foodsystem.utils;

import com.github.javafaker.Faker;
import edu.hami.restfulservices.foodsystem.model.Order;
import edu.hami.restfulservices.foodsystem.model.Restaurant;
import edu.hami.restfulservices.foodsystem.model.enums.RestaurantType;
import edu.hami.restfulservices.foodsystem.model.enums.VehicleType;
import edu.hami.restfulservices.foodsystem.model.menu.*;
import edu.hami.restfulservices.foodsystem.model.payment.CreditCard;
import edu.hami.restfulservices.foodsystem.model.payment.DebitCard;
import edu.hami.restfulservices.foodsystem.model.payment.PaymentInfo;
import edu.hami.restfulservices.foodsystem.model.person.Customer;
import edu.hami.restfulservices.foodsystem.model.person.CustomerDetails;
import edu.hami.restfulservices.foodsystem.model.person.Delivery;
import edu.hami.restfulservices.foodsystem.model.person.Staff;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
@Profile("dev")
public class TestDataGenerator {

    private final Faker faker;

    public TestDataGenerator(Faker faker) {
        this.faker = faker;
    }

    public Restaurant generateRestaurant() {
        RestaurantType[] restaurantTypes = RestaurantType.values();
        Restaurant restaurant = new Restaurant();
        restaurant.setName(faker.company().name());
        restaurant.setAddress(faker.address().fullAddress());
        restaurant.setPhoneNumber(faker.phoneNumber().phoneNumber());
        restaurant.setType(restaurantTypes[faker.random().nextInt(restaurantTypes.length)]);
        restaurant.setOrders(new ArrayList<>());
        restaurant.setDeliveries(new ArrayList<>());
        restaurant.setRestaurantStaffs(new ArrayList<>());
        restaurant.setMenuItems(new ArrayList<>());
        return restaurant;
    }

    public MenuItem generateMenuItem() {
        Random random = new Random();
        int n = random.nextInt(12);
        if (n % 4 == 0) {
            return generateAppetizer();
        } else if (n % 4 == 1) {
            return generateDrink();
        } else if (n % 4 == 2) {
            return generateMainMeal();
        } else {
            return generateSide();
        }
    }

    private Side generateSide() {
        Side side = new Side();
        side.setName(faker.food().dish());
        side.setPrice(faker.number().randomDouble(2, 8, 30));
        side.setOrders(new ArrayList<>());
        return side;
    }

    private MainMeal generateMainMeal() {
        MainMeal mainMeal = new MainMeal();
        mainMeal.setName(faker.food().dish());
        mainMeal.setPrice(faker.number().randomDouble(2, 8, 80));
        mainMeal.setOrders(new ArrayList<>());
        return mainMeal;
    }

    private Drink generateDrink() {
        Drink drink = new Drink();
        drink.setName(faker.food().dish());
        drink.setPrice(faker.number().randomDouble(2, 8, 20));
        drink.setOrders(new ArrayList<>());
        return drink;
    }

    private Appetizer generateAppetizer() {
        Appetizer appetizer = new Appetizer();
        appetizer.setName(faker.food().dish());
        appetizer.setPrice(faker.number().randomDouble(2, 8, 30));
        appetizer.setOrders(new ArrayList<>());
        return appetizer;
    }

    public Delivery generateDelivery() {
        VehicleType[] vehicleTypes = VehicleType.values();
        Delivery delivery = new Delivery();
        delivery.setFirstName(faker.name().firstName());
        delivery.setLastName(faker.name().lastName());
        delivery.setSalary(faker.number().randomDouble(2, 1, 3000));
        delivery.setVehicle(vehicleTypes[faker.random().nextInt(vehicleTypes.length)]);
        delivery.setRestaurants(new ArrayList<>());
        return delivery;
    }

    public Staff generateStaff() {
        Staff staff = new Staff();
        staff.setFirstName(faker.name().firstName());
        staff.setLastName(faker.name().lastName());
        staff.setSalary(faker.number().randomDouble(2, 1, 5000));
        staff.setRestaurantStaffs(new ArrayList<>());
        return staff;
    }

    public Customer generateCustomer() {
        Customer customer = new Customer();
        customer.setCustomerDetails(generateCustomerDetails());
        customer.setEmail(faker.internet().emailAddress());
        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setPaymentInfos(new ArrayList<>());
        customer.setOrders(new ArrayList<>());
        return customer;
    }

    public PaymentInfo generatePaymentInfo() {
        Random random = new Random();
        int n = random.nextInt(4);
        if (n % 2 == 0) {
            return generateDebitCard();
        } else {
            return generateCreditCard();
        }
    }

    public CustomerDetails generateCustomerDetails() {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAddress(faker.address().fullAddress());
        customerDetails.setPhoneNumber(faker.phoneNumber().cellPhone());
        return customerDetails;
    }

    public Order generateOrder() {
        Order order = new Order();
        order.setDate(faker.date().birthday());
        order.setMenuItems(new ArrayList<>());
        return order;
    }

    public CreditCard generateCreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.setFullName(faker.name().fullName());
        creditCard.setCardNumber(faker.business().creditCardNumber());
        creditCard.setCardType(faker.business().creditCardType());
        creditCard.setExpiryDate(faker.business().creditCardExpiry());
        return creditCard;
    }

    public DebitCard generateDebitCard() {
        DebitCard debitCard = new DebitCard();
        debitCard.setFullName(faker.name().fullName());
        debitCard.setCardNumber(faker.business().creditCardNumber());
        return debitCard;
    }
}
