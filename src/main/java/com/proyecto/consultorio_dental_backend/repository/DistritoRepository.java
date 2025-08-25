package com.proyecto.consultorio_dental_backend.repository;

import com.proyecto.consultorio_dental_backend.entity.DistritoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistritoRepository extends JpaRepository<DistritoEntity, Integer> {
    List<DistritoEntity> findAllByProvinciaId(Integer provinciaId);

    @Query("SELECT d FROM Distrito d WHERE d.provincia.departamento.id = :departamentoId")
    List<DistritoEntity> findAllByDepartamentoId(@Param("departamentoId") Integer departamentoId);
}
