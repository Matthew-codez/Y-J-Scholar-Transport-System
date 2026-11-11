package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.TripScholar;
import com.ywshuttle.transport.repository.TripScholarRepository;
import com.ywshuttle.transport.service.TripScholarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripScholarServiceImpl implements TripScholarService {
    private final TripScholarRepository repository;

    public TripScholarServiceImpl(TripScholarRepository repository) {
        this.repository = repository;
    }

    @Override
    public TripScholar createTripScholar(TripScholar entity) {
        return repository.save(entity);
    }

    @Override
    public List<TripScholar> getAllTripScholars() {
        return repository.findAll();
    }

    @Override
    public Optional<TripScholar> getTripScholarById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public TripScholar updateTripScholar(Integer id, TripScholar entityDetails) {
        TripScholar entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("TripScholar not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteTripScholar(Integer id) {
        TripScholar entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("TripScholar not found with id: " + id));
        repository.delete(entity);
    }
}
