package com.bitwiser.controller;

import com.bitwiser.entity.ServiceEntity;
import com.bitwiser.service.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServiceEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ServiceEntity create(
            @RequestBody ServiceEntity serviceObj) {

        return service.save(serviceObj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


    @PutMapping("/{id}")
    public ServiceEntity update(
            @PathVariable Long id,
            @RequestBody ServiceEntity serviceObj) {

        return service.update(id, serviceObj);

    }
}