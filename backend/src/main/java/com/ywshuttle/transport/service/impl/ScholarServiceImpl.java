package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.Scholar;
import com.ywshuttle.transport.repository.ScholarRepository;
import com.ywshuttle.transport.service.ScholarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScholarServiceImpl implements ScholarService {
    private final ScholarRepository repository;

    public ScholarServiceImpl(ScholarRepository repository) {
        this.repository = repository;
    }

    @Override
    public Scholar createScholar(Scholar entity) {
        return repository.save(entity);
    }

    @Override
    public List<Scholar> getAllScholars() {
        return repository.findAll();
    }

    @Override
    public Optional<Scholar> getScholarById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Scholar updateScholar(Integer id, Scholar entityDetails) {
        Scholar entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scholar not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteScholar(Integer id) {
        Scholar entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scholar not found with id: " + id));
        repository.delete(entity);
    }
}
