package com.stackoverflow.qanda.service;

import com.stackoverflow.qanda.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService
{

    Post postQuestion(Post post);

    List<Post> getAll();

    boolean postAnswer(Post post);

    boolean postAnswerComment(Post post);

    Post getPostById(long id);

    boolean updateQuestionVotes(long questionId, String voteType);

    boolean updateAnswerVotes(long postId, long answerId, String voteType);

    List<Post> getNewestPosts();

    List<Post> getOldestPosts();

    List<Post> getUnanswered();
}
