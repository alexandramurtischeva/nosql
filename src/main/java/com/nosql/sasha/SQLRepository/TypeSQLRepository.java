package com.nosql.sasha.SQLRepository;


import com.nosql.sasha.SQLEntity.TypeSQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeSQLRepository extends JpaRepository<TypeSQL, Long> {
    List<TypeSQL> findAllByName(String name);

    Optional<TypeSQL> findFirstByName(String Name);
}
