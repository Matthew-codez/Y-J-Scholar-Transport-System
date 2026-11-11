package com.ywshuttle.transport.repository;

import com.ywshuttle.transport.domain.TripScholar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripScholarRepository extends JpaRepository<TripScholar, Integer> {
}
