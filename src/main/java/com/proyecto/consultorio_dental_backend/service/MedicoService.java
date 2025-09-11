package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.request.MedicoRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.response.MedicoResponseGeneralDTO;
import com.proyecto.consultorio_dental_backend.dto.response.MedicoResponseSimpleDTO;

import java.util.List;

public interface MedicoService {

    MedicoResponseSimpleDTO findResponseSimpleById(Integer id);

    MedicoResponseGeneralDTO findResponseGeneralById(Integer id);

    MedicoResponseSimpleDTO findByDni(String dni);

    List<MedicoResponseSimpleDTO> findByNombreCompletoLike(String nombre);

    List<MedicoResponseSimpleDTO> findByEspecialidad(String especialidad);

    List<MedicoResponseSimpleDTO> findAll();

    MedicoResponseSimpleDTO save(MedicoRequestDTO medico);

    void delete(Integer id);

    void updateEspecialidad(Integer medicoId, String especialidad);

    void updateCodigoColegiatura(Integer medicoId, String codigoColegiatura);

}
