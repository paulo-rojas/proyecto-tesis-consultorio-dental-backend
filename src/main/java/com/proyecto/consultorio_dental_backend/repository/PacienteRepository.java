package com.proyecto.consultorio_dental_backend.repository;

import com.proyecto.consultorio_dental_backend.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacienteEntity,Integer> {
    Optional<PacienteEntity> findByDni(String dni);

    /**
     * Busca pacientes cuyo nombre completo coincida con el término de búsqueda.
     * @param nombreCompleto Término de búsqueda para el nombre completo.
     */
    @Query("SELECT p FROM PacienteEntity p " +
            "WHERE CONCAT(p.nombres, ' ', p.apellidoPaterno, ' ', COALESCE(p.apellidoMaterno, '')) " +
            "LIKE :nombreCompleto")
    List<PacienteEntity> findByNombreCompletoLike(String nombreCompleto);
}
