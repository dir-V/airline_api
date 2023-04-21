package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    FlightService flightService;

    @Autowired
    PassengerRepository passengerRepository;


    public Passenger updateBooking(PassengerDTO passengerDTO, long id){
        Passenger passenger = passengerRepository.findById(id).get();
        passenger.setName(passengerDTO.getName());
        passenger.setPhoneNumber(passengerDTO.getPhoneNumber());
        passenger.setFlights(new ArrayList<>());
        for(long flightID : passengerDTO.getFlightIds()){
            Flight flight = flightService.getFlight(flightID);
            passenger.addFlight(flight);
        }
        return passengerRepository.save(passenger);
    }

    public Passenger findPassengerById(long id){
        return passengerRepository.findById(id).get();
    }
    public List<Passenger> findAllPassengers(){
        return passengerRepository.findAll();
    }

    public void removePasenger(long id){
        passengerRepository.deleteById(id);
    }



}
