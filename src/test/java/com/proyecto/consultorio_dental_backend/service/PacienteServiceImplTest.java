package com.proyecto.consultorio_dental_backend.service;

import com.proyecto.consultorio_dental_backend.dto.request.PacienteRequestDTO;
import com.proyecto.consultorio_dental_backend.dto.response.PacienteResponseDTO;
import com.proyecto.consultorio_dental_backend.entity.PacienteEntity;
import com.proyecto.consultorio_dental_backend.exception.PersonaNoEncontradaException;
import com.proyecto.consultorio_dental_backend.repository.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PacienteServiceImplTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteServiceImpl pacienteService;

    private PacienteEntity pacienteEntity;

    @BeforeEach
    void setUp() {
        // Preparamos una entidad de paciente que se usará en múltiples pruebas
        pacienteEntity = new PacienteEntity();
        pacienteEntity.setId(1);
        pacienteEntity.setNombres("JUAN CARLOS");
        pacienteEntity.setApellidoPaterno("PEREZ");
        pacienteEntity.setApellidoMaterno("GARCIA");
        pacienteEntity.setDni("87654321");
        pacienteEntity.setFechaNacimiento(LocalDate.of(1990, 5, 15));
    }

    @Test
    @DisplayName("Debería crear un nuevo paciente correctamente")
    void deberiaCrearPaciente() {
        // GIVEN: Un DTO de solicitud para crear un paciente
        PacienteRequestDTO requestDTO = new PacienteRequestDTO();
        requestDTO.setDni("11223344");
        requestDTO.setNombres("NUEVO");
        requestDTO.setApellidoPaterno("PACIENTE");
        requestDTO.setApellidoMaterno("TEST");
        requestDTO.setFechaNacimiento(LocalDate.of(2000, 1, 1));

        // Simulamos que al guardar, el repositorio asigna un ID y devuelve la entidad
        when(pacienteRepository.save(any(PacienteEntity.class))).thenAnswer(invocation -> {
            PacienteEntity entityToSave = invocation.getArgument(0);
            entityToSave.setId(100); // Simulamos que la BD genera el ID 100
            return entityToSave;
        });

        // WHEN: Ejecutamos el método de creación
        PacienteResponseDTO resultado = pacienteService.save(requestDTO);

        // THEN: Verificamos que el resultado es el esperado
        assertNotNull(resultado);
        assertEquals(100, resultado.getId());
        assertEquals("NUEVO PACIENTE TEST", resultado.getNombres());
        assertEquals("11223344", resultado.getDni());

        // Verificamos que el método save del repositorio fue llamado una vez
        verify(pacienteRepository, times(1)).save(any(PacienteEntity.class));
    }

    @Test
    @DisplayName("Debería encontrar un paciente por DNI cuando existe")
    void deberiaEncontrarPacientePorDni() {
        // GIVEN: Simulamos que el repositorio encuentra al paciente por su DNI
        when(pacienteRepository.findByDni("87654321")).thenReturn(Optional.of(pacienteEntity));

        // WHEN: Buscamos al paciente
        PacienteResponseDTO resultado = pacienteService.findByDni("87654321");

        // THEN: Verificamos los datos del paciente encontrado
        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        assertEquals("JUAN CARLOS", resultado.getNombres());

        // Verificamos que el método del repositorio fue llamado una vez con el DNI correcto
        verify(pacienteRepository, times(1)).findByDni("87654321");
    }

    @Test
    @DisplayName("Debería lanzar PersonaNoEncontradaException cuando el DNI no existe")
    void deberiaLanzarExcepcionCuandoDniNoExiste() {
        // GIVEN: Simulamos que el repositorio NO encuentra a nadie con ese DNI
        when(pacienteRepository.findByDni("00000000")).thenReturn(Optional.empty());

        // WHEN / THEN: Verificamos que se lanza la excepción correcta
        assertThrows(PersonaNoEncontradaException.class, () -> {
            pacienteService.findByDni("00000000");
        });

        // Verificamos que el método del repositorio fue llamado
        verify(pacienteRepository, times(1)).findByDni("00000000");
    }

    @Test
    @DisplayName("Debería encontrar pacientes por nombre completo")
    void deberiaEncontrarPacientesPorNombre() {
        // GIVEN: Simulamos que la búsqueda por especificación devuelve una lista con nuestro paciente
        when(pacienteRepository.findAll((Sort) any(Specification.class))).thenReturn(List.of(pacienteEntity));

        // WHEN: Ejecutamos la búsqueda por nombre
        List<PacienteResponseDTO> resultados = pacienteService.findByNombreCompletoLike("Juan Perez");

        // THEN: Verificamos que la lista de resultados es correcta
        assertNotNull(resultados);
        assertFalse(resultados.isEmpty());
        assertEquals(1, resultados.size());
        assertEquals("JUAN CARLOS", resultados.getFirst().getNombres());

        verify(pacienteRepository, times(1)).findAll((Sort) any(Specification.class));
    }

    @Test
    @DisplayName("Debería devolver una lista vacía cuando no hay coincidencias por nombre")
    void deberiaDevolverListaVaciaCuandoNoHayCoincidencias() {
        // GIVEN: Simulamos que la búsqueda no encuentra resultados
        when(pacienteRepository.findAll((Sort) any(Specification.class))).thenReturn(Collections.emptyList());

        // WHEN: Ejecutamos la búsqueda con un término que no existe
        List<PacienteResponseDTO> resultados = pacienteService.findByNombreCompletoLike("NombreInexistente");

        // THEN: Verificamos que el resultado es una lista vacía
        assertNotNull(resultados);
        assertTrue(resultados.isEmpty());

        verify(pacienteRepository, times(1)).findAll((Sort) any(Specification.class));
    }
}