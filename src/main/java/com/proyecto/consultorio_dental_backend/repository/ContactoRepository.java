package com.proyecto.consultorio_dental_backend.repository;

import com.proyecto.consultorio_dental_backend.entity.ContactoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<ContactoEntity, Integer> {
}
