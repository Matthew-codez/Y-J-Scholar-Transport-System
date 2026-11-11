package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.DriverRouteAssignment;
import com.ywshuttle.transport.repository.DriverRouteAssignmentRepository;
import com.ywshuttle.transport.service.DriverRouteAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverRouteAssignmentServiceImpl implements DriverRouteAssignmentService {
    private final DriverRouteAssignmentRepository repository;

    public DriverRouteAssignmentServiceImpl(DriverRouteAssignmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public DriverRouteAssignment createDriverRouteAssignment(DriverRouteAssignment entity) {
        return repository.save(entity);
    }

    @Override
    public List<DriverRouteAssignment> getAllDriverRouteAssignments() {
        return repository.findAll();
    }

    @Override
    public Optional<DriverRouteAssignment> getDriverRouteAssignmentById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public DriverRouteAssignment updateDriverRouteAssignment(Integer id, DriverRouteAssignment entityDetails) {
        DriverRouteAssignment entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("DriverRouteAssignment not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteDriverRouteAssignment(Integer id) {
        DriverRouteAssignment entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("DriverRouteAssignment not found with id: " + id));
        repository.delete(entity);
    }
}
