package com.stackoverflow.qanda.controller;

import com.stackoverflow.qanda.model.Answer;
import com.stackoverflow.qanda.model.Post;
import com.stackoverflow.qanda.repository.PostRepo;
import com.stackoverflow.qanda.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class PostController {
    @Autowired
    private PostService postService;
    private Post post;
    @PostMapping
    public ResponseEntity<Post> postQuestion(@RequestBody Post post)
     {
         System.out.println("posting...");
         post=postService.postQuestion(post);
         if(post==null)
             return new ResponseEntity<Post>(HttpStatus.BAD_REQUEST);
         else
             return new ResponseEntity<Post>(HttpStatus.OK);
     }

     @PostMapping("/answer")
     public ResponseEntity postAnswer(@RequestBody Post post)
     {
       if(postService.postAnswer(post))
           return new ResponseEntity(HttpStatus.OK);
         return new ResponseEntity(HttpStatus.BAD_REQUEST);
     }
    @PostMapping("/answer/comment")
    public ResponseEntity postAnswerComment(@RequestBody Post post)
    {
        if(postService.postAnswerComment(post))
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/{id}")
    public ResponseEntity getPostById(@PathVariable long id)
    {
        post=postService.getPostById(id);
        if(post!=null)
            return new ResponseEntity<Post>(post,HttpStatus.OK);
         return new ResponseEntity(post,HttpStatus.BAD_REQUEST);
    }
    @GetMapping
    public List<Post> getAll()
    {
        return postService.getAll();

    }
    @PostMapping("/{postId}/{voteType}")
    public ResponseEntity updateQuestionVotes(@PathVariable long postId,@PathVariable String voteType)
    {
        if(postService.updateQuestionVotes(postId,voteType))
            return new ResponseEntity<Post>(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/{postId}/{answerId}/{voteType}")
    public ResponseEntity updateAnswerVotes(@PathVariable long postId,@PathVariable long answerId,@PathVariable String voteType)
    {
        if(postService.updateAnswerVotes(postId,answerId,voteType))
            return new ResponseEntity<Post>(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/newest")
    public List<Post> getNewestPosts()
    {
        return postService.getNewestPosts();
    }
    @GetMapping("/oldest")
    public List<Post> getOldestPosts()
    {
        return postService.getOldestPosts();
    }
    @GetMapping("/unanswered")
    public List<Post> getUnansweredPosts()
    {
        return postService.getUnanswered();
    }

}
