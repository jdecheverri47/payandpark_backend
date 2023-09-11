package com.payandpark.payandpark.services;

import com.payandpark.payandpark.models.VehicleModel;
import com.payandpark.payandpark.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VehiclesService {

    @Autowired
    VehiclesRepository vehiclesRepository;

    public ArrayList<VehicleModel> getAllVehicles() {
        return (ArrayList<VehicleModel>) vehiclesRepository.findAll();
    }

    public Optional<VehicleModel> getVehicleById(Long id) {
        return vehiclesRepository.findById(id);
    }

    public ArrayList<VehicleModel> getVehicleByUser(String user) {
        return vehiclesRepository.findByUser(user);
    }

    public ArrayList<VehicleModel> getVehicleByLoc(String vehicleLocation) {
        return vehiclesRepository.findByVehicleLoc(vehicleLocation);
    }

    public VehicleModel saveVehicle(VehicleModel vehicle) {
        return vehiclesRepository.save(vehicle);
    }
}
