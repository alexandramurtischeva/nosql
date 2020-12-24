package com.nosql.sasha.MongoRepository;


import com.nosql.sasha.MongoEntity.ModelMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ModelMongoRepository extends MongoRepository<ModelMongo, ObjectId> {

    Optional<ModelMongo> findFirstByTypeName(String typeName);
}
