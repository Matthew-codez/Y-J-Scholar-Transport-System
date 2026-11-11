package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.VehicleMaintenance;

import java.util.List;
import java.util.Optional;

public interface VehicleMaintenanceService {
    VehicleMaintenance createVehicleMaintenance( VehicleMaintenance entity );

    List<VehicleMaintenance> getAllVehicleMaintenances();

    Optional<VehicleMaintenance> getVehicleMaintenanceById(Integer id);

    VehicleMaintenance updateVehicleMaintenance(Integer id, VehicleMaintenance entityDetails);

    void deleteVehicleMaintenance(Integer id);
}
