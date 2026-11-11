package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.Attendance;

import java.util.List;
import java.util.Optional;

public interface AttendanceService {
    Attendance createAttendance( Attendance entity );

    List<Attendance> getAllAttendances();

    Optional<Attendance> getAttendanceById(Integer id);

    Attendance updateAttendance(Integer id, Attendance entityDetails);

    void deleteAttendance(Integer id);
}
