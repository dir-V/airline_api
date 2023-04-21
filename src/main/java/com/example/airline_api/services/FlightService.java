package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public void createFlight(Flight flight){
        flightRepository.save(flight);
    }

    public Flight getFlight(Long id){
        return flightRepository.findById(id).get();
    }

    public List<Flight> showAllFlights(){
        return flightRepository.findAll();
    }

    public void cancelFlight (Long id){
        Flight flight = flightRepository.findById(id).get();
        for(Passenger passenger: flight.getPassengers()){
            passenger.removeFlight(flight);
            passengerRepository.save(passenger);
        }
        flightRepository.deleteById(id);
    }

}
