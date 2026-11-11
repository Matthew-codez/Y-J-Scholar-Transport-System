package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.Scholar;

import java.util.List;
import java.util.Optional;

public interface ScholarService {
    Scholar createScholar( Scholar entity );

    List<Scholar> getAllScholars();

    Optional<Scholar> getScholarById(Integer id);

    Scholar updateScholar(Integer id, Scholar entityDetails);

    void deleteScholar(Integer id);
}
