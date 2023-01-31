package com.academia.repository;

import com.academia.entity.FichaTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaTreinoRepository extends JpaRepository<FichaTreino, Long> {
}
