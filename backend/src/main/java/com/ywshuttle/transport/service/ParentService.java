package com.ywshuttle.transport.service;

import com.ywshuttle.transport.domain.Parent;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    Parent createParent( Parent entity );

    List<Parent> getAllParents();

    Optional<Parent> getParentById(Integer id);

    Parent updateParent(Integer id, Parent entityDetails);

    void deleteParent(Integer id);
}
