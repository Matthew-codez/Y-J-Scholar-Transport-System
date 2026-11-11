package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.ScholarRouteAssignment;
import com.ywshuttle.transport.repository.ScholarRouteAssignmentRepository;
import com.ywshuttle.transport.service.ScholarRouteAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScholarRouteAssignmentServiceImpl implements ScholarRouteAssignmentService {
    private final ScholarRouteAssignmentRepository repository;

    public ScholarRouteAssignmentServiceImpl(ScholarRouteAssignmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public ScholarRouteAssignment createScholarRouteAssignment(ScholarRouteAssignment entity) {
        return repository.save(entity);
    }

    @Override
    public List<ScholarRouteAssignment> getAllScholarRouteAssignments() {
        return repository.findAll();
    }

    @Override
    public Optional<ScholarRouteAssignment> getScholarRouteAssignmentById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public ScholarRouteAssignment updateScholarRouteAssignment(Integer id, ScholarRouteAssignment entityDetails) {
        ScholarRouteAssignment entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ScholarRouteAssignment not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteScholarRouteAssignment(Integer id) {
        ScholarRouteAssignment entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ScholarRouteAssignment not found with id: " + id));
        repository.delete(entity);
    }
}
