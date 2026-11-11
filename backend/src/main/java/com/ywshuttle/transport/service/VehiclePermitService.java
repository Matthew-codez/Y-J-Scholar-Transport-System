package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.VehiclePermit;

import java.util.List;
import java.util.Optional;

public interface VehiclePermitService {
    VehiclePermit createVehiclePermit( VehiclePermit entity );

    List<VehiclePermit> getAllVehiclePermits();

    Optional<VehiclePermit> getVehiclePermitById(Integer id);

    VehiclePermit updateVehiclePermit(Integer id, VehiclePermit entityDetails);

    void deleteVehiclePermit(Integer id);
}
