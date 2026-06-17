package com.example.homerodoh.repository;

import com.example.homerodoh.model.Cerveza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CervezaRepository extends JpaRepository<Cerveza, Integer> {
}