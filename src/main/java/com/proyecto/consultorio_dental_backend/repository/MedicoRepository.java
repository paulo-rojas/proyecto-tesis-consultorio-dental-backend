package com.proyecto.consultorio_dental_backend.repository;

import com.proyecto.consultorio_dental_backend.entity.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoEntity, Integer> {

    Optional<MedicoEntity> findByDni(String dni);

    @Query("SELECT p FROM MedicoEntity p " +
            "WHERE CONCAT(p.nombres, ' ', p.apellidoPaterno, ' ', COALESCE(p.apellidoMaterno, '')) " +
            "LIKE :nombreCompleto")
    List<MedicoEntity> findByNombreCompletoLike(String nombreCompleto);

    List<MedicoEntity> findByEspecialidad(String especialidad);

    @Query("SELECT p FROM MedicoEntity p WHERE p.dni = :dni")
    boolean existsByDni(String dni);
}
