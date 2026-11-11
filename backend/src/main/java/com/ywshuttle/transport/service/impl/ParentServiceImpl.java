package com.ywshuttle.transport.service.impl;

import com.ywshuttle.transport.domain.Parent;
import com.ywshuttle.transport.repository.ParentRepository;
import com.ywshuttle.transport.service.ParentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService {
    private final ParentRepository repository;

    public ParentServiceImpl(ParentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Parent createParent(Parent entity) {
        return repository.save(entity);
    }

    @Override
    public List<Parent> getAllParents() {
        return repository.findAll();
    }

    @Override
    public Optional<Parent> getParentById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Parent updateParent(Integer id, Parent entityDetails) {
        Parent entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));
        return repository.save(entity);
    }

    @Override
    public void deleteParent(Integer id) {
        Parent entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parent not found with id: " + id));
        repository.delete(entity);
    }
}
