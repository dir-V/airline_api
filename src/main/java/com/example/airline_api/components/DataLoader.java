package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws  Exception{

//        Passengers
        Passenger passenger1 = new Passenger("Vincent", 761616);
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger("John", 716161);
        passengerRepository.save(passenger2);

        Passenger passenger3 = new Passenger("Alice", 71614545);
        passengerRepository.save(passenger3);

//        Flights
        Flight uae = new Flight("Dubai", 2, "12th Feb", 2100);
        flightRepository.save(uae);

        Flight sweeden = new Flight("Stockholm", 15, "19th Nov", 1200);
        flightRepository.save(sweeden);

        Flight usa = new Flight("New York City", 10, "17th April", 1000);
        flightRepository.save(usa);

        Flight southAfrica = new Flight("Cape Town", 2, "22th Dec", 1800);
        flightRepository.save(southAfrica);

        Flight austrailia = new Flight("Sydney", 25, "30th June", 1700);
        flightRepository.save(austrailia);

        passenger1.addFlight(sweeden);
        passenger1.addFlight(uae);
        passenger1.addFlight(usa);
        passenger2.addFlight(sweeden);
        passenger2.addFlight(southAfrica);
        passenger3.addFlight(austrailia);

        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);
        passengerRepository.save(passenger3);

    }
}
