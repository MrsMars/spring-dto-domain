package com.aoher;

import com.aoher.dto.OrderDTO;
import com.aoher.entity.Address;
import com.aoher.entity.Customer;
import com.aoher.entity.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public OrderDTO mapEntity2DTO() throws JsonProcessingException {
        Address address = new Address();
        address.setCity("Bbsr");
        address.setStreet("Rasulgarha");

        Customer customer = new Customer();
        customer.setFirstName("Basanta");
        customer.setLastName("Hota");

        Order order = new Order();
        order.setCustomer(customer);
        order.setAddress(address);

        ModelMapper modelMapper = new ModelMapper();
        log.info(new ObjectMapper().writeValueAsString(order));
        return modelMapper.map(order, OrderDTO.class);
    }

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(App.class, args);

        App app = new App();
        log.info("result => {}", app.mapEntity2DTO());
    }
}
