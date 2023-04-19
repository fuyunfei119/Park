package com.example.parkplatz.Controller;

import com.example.parkplatz.Entity.Car;
import com.example.parkplatz.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/GetAllCar")
    public List<Car> getOneCar() {
        return carService.getAllCars();
    }

    @PutMapping("/updateOne")
    public Car updateByName(@RequestBody Car car) throws Exception {
        Car updatedCar = carService.updateByName(car);
        if (updatedCar == null) {
            throw new Exception("Update Failed.");
        }

        return updatedCar;
    }

    @PostMapping("/insertOne")
    public Car insertOne(@RequestBody Car car) throws Exception {
        Car insertedCar = carService.insertOne(car);
        if (insertedCar == null) {
            throw new Exception("Insert Failed");
        }

        return insertedCar;
    }

    @DeleteMapping("/deleteOneByName/{name}")
    public List<Car> deleteOneByName(@PathVariable String name) throws Exception {
        if (name.equals("")) {
            throw new Exception("Name must have an value.");
        }

        List<Car> cars = carService.deleteOne(name);
        if (cars.isEmpty()) {
            throw new Exception("Delete Failed");
        }

        return cars;
    }
}
