package com.example.homerodoh.controller;

import com.example.homerodoh.model.Marca;
import com.example.homerodoh.service.MarcaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/marcas")
public class MarcaController {

    private static final Logger logger =
            LoggerFactory.getLogger(MarcaController.class);

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public ResponseEntity<List<Marca>> listar() {

        logger.info("Listando todas las marcas");

        return ResponseEntity.ok(marcaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {

        logger.info("Buscando marca con ID: {}", id);

        Marca marca = marcaService.getById(id);

        if (marca == null) {

            logger.warn("Marca no encontrada con ID: {}", id);

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(marca);
    }

    @PostMapping
    public ResponseEntity<Marca> crear(
            @Valid @RequestBody Marca marca) {

        logger.info("Creando marca: {}", marca.getNombre());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(marcaService.save(marca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody Marca marca) {

        logger.info("Actualizando marca con ID: {}", id);

        marca.setId(id);

        Marca actualizada = marcaService.update(marca);

        if (actualizada == null) {

            logger.warn("No se pudo actualizar. ID no encontrado: {}", id);

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        logger.warn("Eliminando marca con ID: {}", id);

        if (marcaService.getById(id) == null) {

            logger.warn("No se pudo eliminar. ID no encontrado: {}", id);

            return ResponseEntity.notFound().build();
        }

        marcaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}