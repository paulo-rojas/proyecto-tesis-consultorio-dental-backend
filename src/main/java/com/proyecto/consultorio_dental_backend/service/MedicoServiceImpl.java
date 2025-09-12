package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.request.MedicoRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.response.MedicoResponseGeneralDTO;
import com.proyecto.consultorio_dental_backend.entity.MedicoEntity;
import com.proyecto.consultorio_dental_backend.exception.DniInvalidoException;
import com.proyecto.consultorio_dental_backend.exception.PersonaNoEncontradaException;
import com.proyecto.consultorio_dental_backend.mapper.MedicoMapper;
import com.proyecto.consultorio_dental_backend.repository.MedicoRepository;
import com.proyecto.consultorio_dental_backend.util.CommonUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService{

    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public MedicoResponseGeneralDTO findById(Integer id) {
        return medicoRepository.findById(id)
                .map(MedicoMapper::toGeneralDTO)
                .orElseThrow( () -> new PersonaNoEncontradaException(id));
    }

    @Override
    public MedicoResponseGeneralDTO findByDni(String dni) {

        if (!CommonUtils.isValidDni(dni)){
            throw new DniInvalidoException(dni);
        }

        return medicoRepository.findByDni(dni)
                .map(MedicoMapper::toGeneralDTO)
                .orElseThrow();
    }

    @Override
    public List<MedicoResponseGeneralDTO> findByNombreCompletoLike(String nombreCompleto) {
        return medicoRepository.findByNombreCompletoLike("%"+nombreCompleto+"%")
                .stream()
                .map(MedicoMapper::toGeneralDTO)
                .toList();
    }

    @Override
    public List<MedicoResponseGeneralDTO> findByEspecialidad(String especialidad) {
        return medicoRepository.findByEspecialidad("%"+especialidad+"%")
                .stream()
                .map(MedicoMapper::toGeneralDTO)
                .toList();
    }

    @Override
    public List<MedicoResponseGeneralDTO> findAll() {
        return  medicoRepository.findAll()
                .stream()
                .map(MedicoMapper::toGeneralDTO)
                .toList();
    }

    @Override
    @Transactional
    public MedicoResponseGeneralDTO save(MedicoRequestDTO medico) {
        if (medicoRepository.existsByDni(medico.getDni())){
            throw new RuntimeException("Médico ya tiene una cuenta registrada");
        }

        MedicoEntity medicoEntity = MedicoMapper.toEntity(medico);
        medicoRepository.save(medicoEntity);
        return MedicoMapper.toGeneralDTO(medicoEntity);

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean updateEspecialidad(Integer medicoId, String especialidad) {

        return false;
    }

    @Override
    public boolean updateCodigoColegiatura(Integer medicoId, String codigoColegiatura) {

        return false;
    }
}
