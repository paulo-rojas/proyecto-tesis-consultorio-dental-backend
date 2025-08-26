package com.proyecto.consultorio_dental_backend.repository;

import com.proyecto.consultorio_dental_backend.entity.DistritoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistritoRepository extends JpaRepository<DistritoEntity, Integer> {
    List<DistritoEntity> findAllByProvinciaId(Integer provinciaId);

    @Query("SELECT d FROM DistritoEntity d WHERE d.provincia.departamento.id = :departamentoId")
    List<DistritoEntity> findAllByDepartamentoId(@Param("departamentoId") Integer departamentoId);

    @Query("SELECT d FROM DistritoEntity d")
    Page<DistritoEntity> findAllCustomPaging(Pageable pageable);

}
