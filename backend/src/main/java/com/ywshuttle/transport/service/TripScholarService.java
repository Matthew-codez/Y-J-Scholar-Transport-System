package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.TripScholar;

import java.util.List;
import java.util.Optional;

public interface TripScholarService {
    TripScholar createTripScholar( TripScholar entity );

    List<TripScholar> getAllTripScholars();

    Optional<TripScholar> getTripScholarById(Integer id);

    TripScholar updateTripScholar(Integer id, TripScholar entityDetails);

    void deleteTripScholar(Integer id);
}
