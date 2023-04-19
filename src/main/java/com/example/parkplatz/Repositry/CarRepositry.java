package com.example.parkplatz.Repositry;

import com.example.parkplatz.Entity.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarRepositry {

    @Select("SELECT * FROM car")
    List<Car> getAllCars();

    @Update("UPDATE car\n" +
            "SET modell = #{modell}\n" +
            "WHERE id = #{id}")
    int updateByName(@Param("modell") String modell,@Param("id") String id);

    @Select("SELECT * FROM car WHERE id = #{id}")
    Car getOneById(@Param("id")String id);

    @Insert("INSERT INTO car VALUES(#{id},#{name},#{modell})")
    int insertOne(Car car);

    @Delete("DELETE FROM car WHERE name =#{name}")
    int deleteOne(@Param("name")String name);
}
