package com.payandpark.payandpark.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String user;

    @Column(name = "vehicle_plate")
    private String vehiclePlate;

    @Column(name = "vehicle_loc")
    private String vehicleLoc;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "state")
    private String state;

    @Column(name = "is_disabled")
    private Boolean isDisabled;
}
