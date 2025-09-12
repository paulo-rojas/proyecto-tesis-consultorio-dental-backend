package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.request.MedicoRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.response.MedicoResponseGeneralDTO;
import com.proyecto.consultorio_dental_backend.dto.response.MedicoResponseSimpleDTO;

import java.util.List;

public interface MedicoService {

    MedicoResponseGeneralDTO findById(Integer id);

    MedicoResponseGeneralDTO findByDni(String dni);

    List<MedicoResponseGeneralDTO> findByNombreCompletoLike(String nombre);

    List<MedicoResponseGeneralDTO> findByEspecialidad(String especialidad);

    List<MedicoResponseGeneralDTO> findAll();

    MedicoResponseGeneralDTO save(MedicoRequestDTO medico);

    boolean delete(Integer id);

    boolean updateEspecialidad(Integer medicoId, String especialidad);

    boolean updateCodigoColegiatura(Integer medicoId, String codigoColegiatura);

}
