package com.example.parkplatz.Controller;

import com.example.parkplatz.Entity.Parker;
import com.example.parkplatz.Entity.Parkingspot;
import com.example.parkplatz.Entity.Result;
import com.example.parkplatz.Service.ParkerService;
import com.example.parkplatz.Service.ParkingManagement;
import com.example.parkplatz.Service.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private ParkingManagement service;
    @Autowired
    private ParkerService parkerService;
    @Autowired
    private ParkingSpotService parkingSpotService;

    @GetMapping("/")
    public String request() {
        return "Plase take rest api.";
    }

    @PostMapping("/CheckIn")
    public Result test(Parker parker) {
        try {
            service.CheckIn(parker);
        } catch (Exception e) {
            return new Result(500,e.getMessage());
        }

        return new Result(200,"Check In Successfully!");
    }

    @PostMapping("/CheckOut")
    public Result Checkout(Parkingspot parkingspot) {
        Double parkingFee;

        try {
            parkingFee = service.CheckOut(parkingspot);
        } catch (Exception e) {
            return new Result(500,e.getMessage());
        }

        return new Result(200,"Check Out Successfully! Please pay your parking fee " + parkingFee + '€');
    }

    @GetMapping("/AllParkers")
    public List<Parker> FindSet() {
        return parkerService.FindSet();
    }

    @GetMapping("/AllParkingspots")
    public List<Parkingspot> FindSet1() {
        return parkingSpotService.FindSet();
    }
}
