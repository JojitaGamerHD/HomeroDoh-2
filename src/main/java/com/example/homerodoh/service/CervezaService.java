package com.example.homerodoh.service;

import com.example.homerodoh.dto.CervezaDTO;
import com.example.homerodoh.exception.ResourceNotFoundException;
import com.example.homerodoh.model.Cerveza;
import com.example.homerodoh.repository.CervezaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CervezaService {

    private final CervezaRepository cervezaRepository;

    public CervezaService(CervezaRepository cervezaRepository) {
        this.cervezaRepository = cervezaRepository;
    }

    public List<Cerveza> getAll() {

        log.info("Listando todas las cervezas");

        return cervezaRepository.findAll();
    }

    public Cerveza getById(Integer id) {

        log.info("Buscando cerveza con ID: {}", id);

        return cervezaRepository.findById(id)
                .orElseThrow(() -> {

                    log.warn("Cerveza no encontrada con ID: {}", id);

                    return new ResourceNotFoundException(
                            "Cerveza no encontrada con ID: " + id);
                });
    }

    public Cerveza save(Cerveza cerveza) {

        try {

            log.info("Guardando cerveza: {}", cerveza.getNombre());

            return cervezaRepository.save(cerveza);

        } catch (Exception e) {

            log.error("Error guardando cerveza: {}", e.getMessage());

            throw new RuntimeException("Error guardando cerveza");
        }
    }

    public Cerveza update(Cerveza cerveza) {

        log.info("Actualizando cerveza con ID: {}", cerveza.getId());

        if (!cervezaRepository.existsById(cerveza.getId())) {

            log.warn("No se encontró cerveza para actualizar");

            throw new ResourceNotFoundException(
                    "Cerveza no encontrada para actualizar");
        }

        return cervezaRepository.save(cerveza);
    }

    public void delete(Integer id) {

        log.info("Eliminando cerveza con ID: {}", id);

        if (!cervezaRepository.existsById(id)) {

            log.warn("No se pudo eliminar. ID no encontrado: {}", id);

            throw new ResourceNotFoundException(
                    "Cerveza no encontrada para eliminar");
        }

        cervezaRepository.deleteById(id);

        log.info("Cerveza eliminada correctamente");
    }

    public List<CervezaDTO> getCervezasDTO() {

        log.info("Listando cervezas DTO");

        return cervezaRepository.findAll().stream()

                .filter(c -> c.getMarca() != null)

                .map(c -> new CervezaDTO(
                        c.getNombre(),
                        c.getPrecio(),
                        c.getMarca().getNombre()
                ))

                .toList();
    }
}