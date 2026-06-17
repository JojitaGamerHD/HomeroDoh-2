package com.example.homerodoh.service;

import com.example.homerodoh.model.Marca;
import com.example.homerodoh.repository.MarcaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MarcaServiceTest {

    @Mock
    private MarcaRepository marcaRepository;

    @InjectMocks
    private MarcaService marcaService;

    @Test
    void testGetAll() {

        Marca marca1 = new Marca(1, "Duff", "Chile", null);
        Marca marca2 = new Marca(2, "Corona", "Mexico", null);

        when(marcaRepository.findAll())
                .thenReturn(Arrays.asList(marca1, marca2));

        assertEquals(2, marcaService.getAll().size());
    }

    @Test
    void testGetById() {

        Marca marca = new Marca(1, "Duff", "Chile", null);

        when(marcaRepository.findById(1))
                .thenReturn(Optional.of(marca));

        assertNotNull(marcaService.getById(1));
        assertEquals("Duff", marcaService.getById(1).getNombre());
    }

    @Test
    void testSave() {

        Marca marca = new Marca(null, "Heineken", "Holanda", null);

        when(marcaRepository.save(marca))
                .thenReturn(new Marca(1, "Heineken", "Holanda", null));

        Marca resultado = marcaService.save(marca);

        assertNotNull(resultado);
        assertEquals("Heineken", resultado.getNombre());
    }

    @Test
    void testDelete() {

        doNothing().when(marcaRepository).deleteById(1);

        marcaService.delete(1);

        verify(marcaRepository, times(1))
                .deleteById(1);
    }
}