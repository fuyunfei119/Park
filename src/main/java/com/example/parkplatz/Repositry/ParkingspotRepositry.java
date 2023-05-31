package com.example.parkplatz.Repositry;

import com.example.parkplatz.Entity.Parkingspot;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ParkingspotRepositry {

    @Select("SELECT * FROM parkingspot")
    List<Parkingspot> FindSet();

    @Select("SELECT id FROM parkingspot WHERE reserved = true AND parkerID is null LIMIT 1")
    Integer FindFirstSeasonParkingSpot();

    @Select("SELECT EXISTS (SELECT id FROM parkingspot WHERE id IN (SELECT id FROM parker WHERE licensePlate = #{licensePlate}))")
    Integer ParkerWithSameLicensePlateExists(@Param("licensePlate") String licensePlate);

    @Select("SELECT count(id) FROM parkingspot WHERE reserved = false AND parkerID is null")
    Integer GetNumberOfNormalParkingSpt();

    @Select("SELECT id FROM parkingspot WHERE reserved = false AND parkerID is null LIMIT 1")
    Integer FindFirstNormalParkingSpot();

    @Update("UPDATE parkingspot SET parkerID = #{parkerID} WHERE id = #{parkingSpotID}")
    Integer ModifyParkingSpotWithParkerID(@Param("parkerID") String parkerID,@Param("parkingSpotID") Integer parkingSpotID);

    @Update("UPDATE parkingspot SET parkerID = null WHERE id = #{parkingSpotID}")
    Integer RemoveParkerFromParkingSpot(@Param("parkingSpotID") Integer parkingSpotID);
}
