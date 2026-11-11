package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.VehicleMaintenance;
import com.ywshuttle.transport.repository.VehicleMaintenanceRepository;
import com.ywshuttle.transport.service.VehicleMaintenanceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMaintenanceServiceImpl implements VehicleMaintenanceService {
    private final VehicleMaintenanceRepository repository;

    public VehicleMaintenanceServiceImpl(VehicleMaintenanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public VehicleMaintenance createVehicleMaintenance(VehicleMaintenance entity) {
        return repository.save(entity);
    }

    @Override
    public List<VehicleMaintenance> getAllVehicleMaintenances() {
        return repository.findAll();
    }

    @Override
    public Optional<VehicleMaintenance> getVehicleMaintenanceById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public VehicleMaintenance updateVehicleMaintenance(Integer id, VehicleMaintenance entityDetails) {
        VehicleMaintenance entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("VehicleMaintenance not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteVehicleMaintenance(Integer id) {
        VehicleMaintenance entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("VehicleMaintenance not found with id: " + id));
        repository.delete(entity);
    }
}
