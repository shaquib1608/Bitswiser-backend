package com.bitwiser.service;

import com.bitwiser.entity.ServiceEntity;
import com.bitwiser.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    private final ServiceRepository repository;

    public ServiceService(ServiceRepository repository) {
        this.repository = repository;
    }

    public List<ServiceEntity> getAll() {
        return repository.findAll();
    }

    public ServiceEntity save(ServiceEntity service) {
        return repository.save(service);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


    public ServiceEntity update(
            Long id,
            ServiceEntity updatedService) {

        ServiceEntity service = repository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Service not found"));
        service.setTitle(updatedService.getTitle());
        service.setDescription(updatedService.getDescription());
        service.setIcon(updatedService.getIcon());
        service.setPrice(updatedService.getPrice());
        return repository.save(service);

    }
}