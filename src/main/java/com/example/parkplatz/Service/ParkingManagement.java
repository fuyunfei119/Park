package com.example.parkplatz.Service;

import com.example.parkplatz.Entity.Parker;
import com.example.parkplatz.Entity.Parkingspot;
import com.example.parkplatz.Repositry.ParkerRepositry;
import com.example.parkplatz.Repositry.ParkingspotRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class ParkingManagement {

    @Autowired
    private ParkingspotRepositry parkingspotRepositry;
    @Autowired
    private ParkerRepositry parkerRepositry;

    public Double CheckOut(Parkingspot parkingspot) throws Exception {

        Parker parker = parkerRepositry.GetParkerByID(parkingspot.getParkerId());

        parker.setExitDate(new Timestamp(System.currentTimeMillis()));

        long differentTime = parker.getExitDate().getTime() - parker.getEntryDate().getTime();

        Timestamp timestamp = new Timestamp(differentTime);

        parker.setParkingFee(timestamp.getHours() * 1.5);

        parkerRepositry.UpdateParkerOnAfterCheckOut(parker);

        parkingspot.setParkerId(null);
        Integer Removed = parkingspotRepositry.RemoveParkerFromParkingSpot(parkingspot.getId());

        if (Removed == 0 ) throw new Exception("Remove Parker From ParkingSpot Failed.");

        return parker.getParkingFee();
    }

    public void CheckIn(Parker parker) throws Exception {

        Integer ParkingSpotId = null;

        if (parkingspotRepositry.ParkerWithSameLicensePlateExists(parker.getLicensePlate()) == 1) {
            throw new Exception("Es gibt bereits ein Auto mit diesem Kennzeichen");
        }

        if (parker.getSeasonParker()) {
            ParkingSpotId = parkingspotRepositry.FindFirstSeasonParkingSpot();
        }

        if (ParkingSpotId == null) {
            ParkingSpotId = FindFirstNormalParkingSpot();
        }

        parker.setId(UUID.randomUUID().toString());
        parker.setEntryDate(new Timestamp(System.currentTimeMillis()));

        Integer Result = parkerRepositry.InsertNewParker(parker);

        if (Result == 1) {
            Integer modified = parkingspotRepositry.ModifyParkingSpotWithParkerID(parker.getId(), ParkingSpotId);

            if (modified == 0) {
                throw new Exception("Failed to parking.");
            }
        }

    }


    private Integer FindFirstNormalParkingSpot() throws Exception {
        Integer Count = parkingspotRepositry.GetNumberOfNormalParkingSpt();

        if (Count > 4) {
            return parkingspotRepositry.FindFirstNormalParkingSpot();
        }

        throw new Exception("There is no enough parkingspot for you. sorry!!!");
    }
}
