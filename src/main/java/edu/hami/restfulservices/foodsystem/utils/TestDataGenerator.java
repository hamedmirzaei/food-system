package edu.hami.restfulservices.foodsystem.utils;

import com.github.javafaker.Faker;
import edu.hami.restfulservices.foodsystem.model.Order;
import edu.hami.restfulservices.foodsystem.model.Restaurant;
import edu.hami.restfulservices.foodsystem.model.enums.Position;
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
import java.util.List;
import java.util.Random;

@Component
@Profile({"dev, test"})
public class TestDataGenerator {

    private final Faker faker;

    public TestDataGenerator(Faker faker) {
        this.faker = faker;
    }

    public Restaurant generateRestaurant() {
        RestaurantType[] restaurantTypes = RestaurantType.values();
        Restaurant restaurant = new Restaurant();
        restaurant.setId(faker.random().nextLong());
        restaurant.setName(faker.company().name());
        restaurant.setAddress(faker.address().fullAddress());
        restaurant.setPhoneNumber(faker.phoneNumber().phoneNumber());
        restaurant.setType(restaurantTypes[faker.random().nextInt(restaurantTypes.length)]);
        Random random = new Random();

        List<MenuItem> menuItems = new ArrayList<>();
        for (int i = 0; i < random.nextInt(10, 30); i++) {
            MenuItem mi = generateMenuItem();
            mi.setRestaurant(restaurant);
            menuItems.add(mi);
        }
        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

    private MenuItem generateMenuItem() {
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
        side.setId(faker.random().nextLong());
        side.setName(faker.food().dish());
        side.setPrice(faker.number().randomDouble(2, 8, 30));
        return side;
    }

    private MainMeal generateMainMeal() {
        MainMeal mainMeal = new MainMeal();
        mainMeal.setId(faker.random().nextLong());
        mainMeal.setName(faker.food().dish());
        mainMeal.setPrice(faker.number().randomDouble(2, 8, 80));
        return mainMeal;
    }

    private Drink generateDrink() {
        Drink drink = new Drink();
        drink.setId(faker.random().nextLong());
        drink.setName(faker.food().dish());
        drink.setPrice(faker.number().randomDouble(2, 8, 20));
        return drink;
    }

    private Appetizer generateAppetizer() {
        Appetizer appetizer = new Appetizer();
        appetizer.setId(faker.random().nextLong());
        appetizer.setName(faker.food().dish());
        appetizer.setPrice(faker.number().randomDouble(2, 8, 30));
        return appetizer;
    }

    public Delivery generateDelivery() {
        VehicleType[] vehicleTypes = VehicleType.values();
        Delivery delivery = new Delivery();
        delivery.setId(faker.random().nextLong());
        delivery.setFirstName(faker.name().firstName());
        delivery.setLastName(faker.name().lastName());
        delivery.setSalary(faker.number().randomDouble(2, 1, 3000));
        delivery.setVehicle(vehicleTypes[faker.random().nextInt(vehicleTypes.length)]);
        return delivery;
    }

    public Staff generateStaff() {
        Staff staff = new Staff();
        staff.setId(faker.random().nextLong());
        staff.setFirstName(faker.name().firstName());
        staff.setLastName(faker.name().lastName());
        staff.setSalary(faker.number().randomDouble(2, 1, 5000));
        return staff;
    }

    public Customer generateCustomer() {
        Customer customer = new Customer();
        customer.setId(faker.random().nextLong());
        customer.setCustomerDetails(generateCustomerDetails());
        customer.setEmail(faker.internet().emailAddress());
        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        Random random = new Random();
        List<PaymentInfo> paymentInfos = new ArrayList<>();
        for (int i = 0; i < random.nextInt(3); i++) {
            PaymentInfo pi = generatePaymentInfo();
            pi.setCustomer(customer);
            paymentInfos.add(pi);
        }
        customer.setPaymentInfos(paymentInfos);
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
        customerDetails.setId(faker.random().nextLong());
        customerDetails.setAddress(faker.address().fullAddress());
        customerDetails.setPhoneNumber(faker.phoneNumber().cellPhone());
        return customerDetails;
    }

    public Order generateOrder() {
        Order order = new Order();
        order.setId(faker.random().nextLong());
        order.setDate(faker.date().birthday());
        return order;
    }

    public CreditCard generateCreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.setId(faker.random().nextLong());
        creditCard.setFullName(faker.name().fullName());
        creditCard.setCardNumber(faker.business().creditCardNumber());
        creditCard.setCardType(faker.business().creditCardType());
        creditCard.setExpiryDate(faker.business().creditCardExpiry());
        return creditCard;
    }

    public DebitCard generateDebitCard() {
        DebitCard debitCard = new DebitCard();
        debitCard.setId(faker.random().nextLong());
        debitCard.setFullName(faker.name().fullName());
        debitCard.setCardNumber(faker.business().creditCardNumber());
        return debitCard;
    }
}
