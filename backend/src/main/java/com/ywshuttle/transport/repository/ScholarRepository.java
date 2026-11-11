package com.ywshuttle.transport.repository;

import com.ywshuttle.transport.domain.Scholar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarRepository extends JpaRepository<Scholar, Integer> {
}
