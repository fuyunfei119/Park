package com.example.parkplatz.Service;

import com.example.parkplatz.Entity.Parkingspot;
import com.example.parkplatz.Repositry.ParkingspotRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpotService {

    @Autowired
    private ParkingspotRepositry parkingspotRepositry;

    public List<Parkingspot> FindSet() {
        return parkingspotRepositry.FindSet();
    }
}
