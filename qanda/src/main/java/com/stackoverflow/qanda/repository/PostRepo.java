package com.stackoverflow.qanda.repository;

import com.stackoverflow.qanda.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo {

    Post postQuestion(Post post);

    List<Post> getPosts();

    boolean postAnswer(Post post);

    boolean postAnswerComment(Post post);

    Post getPostById(long id);

    boolean updateQuestionVotes(long questionId, String voteType);

    boolean updateAnswerVotes(long postId, long answerId, String voteType);

    List<Post> getNewestPosts();

    List<Post> getOldestPosts();

    List<Post> getUnanswered();
}
