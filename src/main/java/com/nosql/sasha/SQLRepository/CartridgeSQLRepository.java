package com.nosql.sasha.SQLRepository;

import com.nosql.sasha.SQLEntity.CartridgeSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartridgeSQLRepository extends JpaRepository<CartridgeSQL, Long> {
    Optional<CartridgeSQL> findFirstByTittle(String tittle);
}
