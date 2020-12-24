package com.nosql.sasha.SQLRepository;

import com.nosql.sasha.SQLEntity.ModelSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelSQLRepository extends JpaRepository<ModelSQL, Long> {
    Optional<ModelSQL> findFirstByTypeName(String typeName);
}
