package com.payandpark.payandpark.controllers;

import com.payandpark.payandpark.models.VehicleModel;
import com.payandpark.payandpark.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
public class VehiclesController {

    @Autowired
    VehiclesService vehiclesService;

    @GetMapping
    public ArrayList<VehicleModel> getVehicles() {
        return vehiclesService.getAllVehicles();
    }

    @GetMapping(path = "/{id}")
    public Optional<VehicleModel> getVehicleById(@PathVariable("id") Long id){
        return this.vehiclesService.getVehicleById(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<VehicleModel> getVehiclesByQuery(
            @RequestParam(value = "user", required = false) String user,
            @RequestParam(value = "vehicleLoc", required = false) String vehicleLocation) {
        if (user != null) {
            return vehiclesService.getVehicleByUser(user);
        } else if (vehicleLocation != null) {
            return vehiclesService.getVehicleByLoc(vehicleLocation);
        } else {
            return new ArrayList<>();
        }
    }

    @PostMapping
    public VehicleModel saveVehicle(@RequestBody VehicleModel vehicle) {
        return this.vehiclesService.saveVehicle(vehicle);
    }
}
