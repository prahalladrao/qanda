package com.stackoverflow.qanda.repository;

import com.stackoverflow.qanda.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CrudRepository extends MongoRepository<Post,Long> {
}
