package com.nosql.sasha.MongoRepository;

import com.nosql.sasha.AggragionEntity.Count;
import com.nosql.sasha.MongoEntity.CartridgeMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CartridgeMongoRepository extends MongoRepository<CartridgeMongo, ObjectId> {
    void deleteAllByFirm(String firm);

    Optional<CartridgeMongo> findFirstByTittle(String tittle);

    Optional<CartridgeMongo> findFirstByFirm(String firm);

    @Aggregation("{$match: { 'colors':'black' }}")
    List<CartridgeMongo> matchColors();

    List<CartridgeMongo> findAllByColors(String colors);

    @Aggregation("{ $group: {_id :'$colors', count  : {$sum : 1}  } }")
    List<Count> countAllByColors();
}
