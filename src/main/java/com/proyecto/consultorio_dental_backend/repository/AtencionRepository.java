package com.proyecto.consultorio_dental_backend.repository;

import com.proyecto.consultorio_dental_backend.entity.AtencionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtencionRepository extends JpaRepository<AtencionEntity, Integer> {
}
