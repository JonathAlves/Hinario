package com.newagesoft.hinario.repositories;

import com.newagesoft.hinario.model.Hino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HinoRepository extends JpaRepository<Hino, Long> {
    Optional<Hino> findByName(String name);
    Optional<Hino> findByNumber(long number);
}
