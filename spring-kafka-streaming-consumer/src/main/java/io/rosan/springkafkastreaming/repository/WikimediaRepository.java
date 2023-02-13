package io.rosan.springkafkastreaming.repository;

import io.rosan.springkafkastreaming.model.WikimediaModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WikimediaRepository extends MongoRepository<WikimediaModel,String> {
}
