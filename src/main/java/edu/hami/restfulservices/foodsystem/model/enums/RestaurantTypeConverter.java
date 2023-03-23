package edu.hami.restfulservices.foodsystem.model.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RestaurantTypeConverter implements AttributeConverter<RestaurantType, String> {
    @Override
    public String convertToDatabaseColumn(RestaurantType restaurantType) {
        return restaurantType.name();
    }

    @Override
    public RestaurantType convertToEntityAttribute(String name) {
        return RestaurantType.valueOf(name);
    }
}
