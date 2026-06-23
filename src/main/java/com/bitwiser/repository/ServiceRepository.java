package com.bitwiser.repository;
import com.bitwiser.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository
    extends JpaRepository<ServiceEntity,Long>{

    }

