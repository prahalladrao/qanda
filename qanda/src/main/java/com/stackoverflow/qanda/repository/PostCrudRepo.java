package com.stackoverflow.qanda.repository;

import com.stackoverflow.qanda.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostCrudRepo extends MongoRepository<Post,Long> {

}
