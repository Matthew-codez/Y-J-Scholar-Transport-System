package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.Vehicle;
import com.ywshuttle.transport.repository.VehicleRepository;
import com.ywshuttle.transport.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository repository;

    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vehicle createVehicle(Vehicle entity) {
        return repository.save(entity);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Vehicle updateVehicle(Integer id, Vehicle entityDetails) {
        Vehicle entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteVehicle(Integer id) {
        Vehicle entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));
        repository.delete(entity);
    }
}
