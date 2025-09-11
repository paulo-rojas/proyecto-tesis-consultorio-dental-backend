package com.proyecto.consultorio_dental_backend.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MedicoServiceImplTest {

    /*
    // El objeto que vamos a simular (mock)
    @Mock
    private MedicoRepository medicoRepository;

    // El objeto real que queremos probar, Mockito le inyectará los mocks.
    @InjectMocks
    private MedicoServiceImpl medicoService;

    private MedicoEntity medicoEntity;
    private MedicoResponseSimpleDTO medicoDTO;

    @BeforeEach
    void setUp() {
        // Preparamos datos de prueba que usaremos en varios tests
        medicoEntity = new MedicoEntity();
        medicoEntity.setId(1);
        medicoEntity.setNombres("CARLOS");
        medicoEntity.setApellidoPaterno("SANCHEZ");
        medicoEntity.setDni("12345678");
        medicoEntity.setEspecialidad("ODONTOLOGIA GENERAL");

        medicoDTO = new MedicoResponseSimpleDTO();
        medicoDTO.setId(1);
        medicoDTO.setNombreCompleto("CARLOS SANCHEZ");
        medicoDTO.setEspecialidad("ODONTOLOGIA GENERAL");
    }

    @Test
    @DisplayName("Debería encontrar un médico por DNI cuando existe")
    void deberiaEncontrarMedicoPorDni() {
        // --- GIVEN (Dado) ---
        // Programamos el comportamiento de nuestro mock.
        // Cuando se llame a medicoRepository.findByDni con cualquier string,
        // debe devolver nuestro medicoEntity de prueba.
        when(medicoRepository.findByDni(anyString())).thenReturn(Optional.of(medicoEntity));

        // --- WHEN (Cuando) ---
        // Ejecutamos el método que queremos probar.
        MedicoResponseSimpleDTO resultado = medicoService.findByDni("12345678");

        // --- THEN (Entonces) ---
        // Verificamos que el resultado no sea nulo y que los datos sean correctos.
        assertNotNull(resultado);
        assertEquals("CARLOS SANCHEZ", resultado.getNombreCompleto());
        assertEquals(1, resultado.getId());

        // Verificamos que el método del repositorio fue llamado exactamente 1 vez.
        verify(medicoRepository, times(1)).findByDni(anyString());
    }

    @Test
    @DisplayName("Debería lanzar PersonaNoEncontradaException cuando el DNI no existe")
    void deberiaLanzarExcepcionCuandoDniNoExiste() {
        // --- GIVEN (Dado) ---
        // Programamos el mock para que simule que no encontró nada.
        when(medicoRepository.findByDni(anyString())).thenReturn(Optional.empty());

        // --- WHEN / THEN (Cuando / Entonces) ---
        // Verificamos que al ejecutar el método, se lanza la excepción esperada.
        assertThrows(PersonaNoEncontradaException.class, () -> {
            medicoService.findByDni("00000000");
        });

        // Verificamos que el método del repositorio fue llamado, aunque no encontrara nada.
        verify(medicoRepository, times(1)).findByDni(anyString());
    }

     */
}