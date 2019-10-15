package com.stackoverflow.qanda.service;


import com.stackoverflow.qanda.model.Post;
import com.stackoverflow.qanda.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Override
    public Post postQuestion(Post post) {
       return postRepo.postQuestion(post);
    }

    @Override
    public List<Post> getAll() {
        return postRepo.getPosts();
    }

    @Override
    public boolean postAnswer(Post post) {
        return postRepo.postAnswer(post);
    }

    @Override
    public boolean postAnswerComment(Post post) {
        return postRepo.postAnswerComment(post);
    }

    @Override
    public Post getPostById(long id) {
        return postRepo.getPostById(id);
    }

    @Override
    public boolean updateQuestionVotes(long postId, String voteType) {
        return postRepo.updateQuestionVotes(postId,voteType);
    }

    @Override
    public boolean updateAnswerVotes(long postId, long answerId, String voteType) {
        return postRepo.updateAnswerVotes(postId, answerId, voteType);
    }

    @Override
    public List<Post> getNewestPosts() {
        return postRepo.getNewestPosts();
    }

    @Override
    public List<Post> getOldestPosts() {
        return postRepo.getOldestPosts();
    }

    @Override
    public List<Post> getUnanswered() {
        return postRepo.getUnanswered();
    }
}
