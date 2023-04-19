package com.example.parkplatz.Service;

import com.example.parkplatz.Entity.Car;
import com.example.parkplatz.Repositry.CarRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    @Autowired
    private CarRepositry carRepositry;

    public List<Car> getAllCars() {
        return carRepositry.getAllCars();
    }

    public Car updateByName(Car car) {
        int result = carRepositry.updateByName(car.getModell(),car.getId());
        System.out.println(result);
        if (result == 1) {
            return carRepositry.getOneById(car.getId());
        }
        return null;
    }

    public Car insertOne(Car car) {
        if ((car.getId()) == null) {
            car.setId(UUID.randomUUID().toString());
        }

        int result = carRepositry.insertOne(car);
        if (result == 1) {
            return carRepositry.getOneById(car.getId());
        }

        return null;
    }

    public List<Car> deleteOne(String name) {
        int result = 0;
        if (!name.equals("")) {
            result = carRepositry.deleteOne(name);
        }

        if (result > 0) {
            return carRepositry.getAllCars();
        }

        return null;
    }
}
