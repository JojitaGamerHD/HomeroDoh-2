package com.example.homerodoh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.homerodoh.model.Marca;
import com.example.homerodoh.repository.MarcaRepository;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> getAll() {
        return marcaRepository.findAll();
    }

    public Marca getById(Integer id) {
        return marcaRepository.findById(id).orElse(null);
    }

    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    public Marca update(Marca marca) {
        if (!marcaRepository.existsById(marca.getId())) {
            return null;
        }
        return marcaRepository.save(marca);
    }

    public void delete(Integer id) {
        marcaRepository.deleteById(id);
    }
}