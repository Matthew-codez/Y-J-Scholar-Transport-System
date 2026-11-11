package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Vehicle createVehicle( Vehicle entity );

    List<Vehicle> getAllVehicles();

    Optional<Vehicle> getVehicleById(Integer id);

    Vehicle updateVehicle(Integer id, Vehicle entityDetails);

    void deleteVehicle(Integer id);
}
