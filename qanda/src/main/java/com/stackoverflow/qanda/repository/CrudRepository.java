package com.stackoverflow.qanda.repository;

import com.stackoverflow.qanda.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CrudRepository extends MongoRepository<Post,Long> {
//    @Query("{'Post.Answer'}")
//     public Post getAnswerByPostId(long answerId);
}
