package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.School;
import com.ywshuttle.transport.repository.SchoolRepository;
import com.ywshuttle.transport.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository repository;

    public SchoolServiceImpl(SchoolRepository repository) {
        this.repository = repository;
    }

    @Override
    public School createSchool(School entity) {
        return repository.save(entity);
    }

    @Override
    public List<School> getAllSchools() {
        return repository.findAll();
    }

    @Override
    public Optional<School> getSchoolById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public School updateSchool(Integer id, School entityDetails) {
        School entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteSchool(Integer id) {
        School entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found with id: " + id));
        repository.delete(entity);
    }
}
