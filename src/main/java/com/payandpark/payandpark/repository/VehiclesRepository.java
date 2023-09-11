package com.payandpark.payandpark.repository;

import com.payandpark.payandpark.models.VehicleModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface VehiclesRepository extends CrudRepository<VehicleModel, Long> {
    public abstract ArrayList<VehicleModel> findByUser(String user);
    public abstract ArrayList<VehicleModel> findByVehicleLoc(String vehicleLoc);

}
