package com.nosql.sasha.MongoRepository;

import com.nosql.sasha.AggragionEntity.Count;
import com.nosql.sasha.MongoEntity.PrinterMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PrinterMongoRepository extends MongoRepository<PrinterMongo, ObjectId> {

    Optional<PrinterMongo> findFirstByName(String name);

    @Aggregation("{ $group: {_id :'$model.brand', count  : {$sum : 1}  } }")
    List<Count> countAllByModelMongo_Brand();

    @Aggregation("{ $group: {_id : '$model.country', count  : {$sum : 1}  } }")
    List<Count> countAllByModelMongo_Country();

    @Aggregation("{ $group: { id :$id , price  : {$min : $price}  } }")
    List<PrinterMongo> findAllByPriceMin();
}
