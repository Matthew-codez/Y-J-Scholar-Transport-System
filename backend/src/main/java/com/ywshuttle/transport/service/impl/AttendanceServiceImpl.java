package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.Attendance;
import com.ywshuttle.transport.repository.AttendanceRepository;
import com.ywshuttle.transport.service.AttendanceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository repository;

    public AttendanceServiceImpl(AttendanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Attendance createAttendance(Attendance entity) {
        return repository.save(entity);
    }

    @Override
    public List<Attendance> getAllAttendances() {
        return repository.findAll();
    }

    @Override
    public Optional<Attendance> getAttendanceById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Attendance updateAttendance(Integer id, Attendance entityDetails) {
        Attendance entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteAttendance(Integer id) {
        Attendance entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with id: " + id));
        repository.delete(entity);
    }
}
