package com.stackoverflow.qanda.repository;


import com.stackoverflow.qanda.model.*;
import com.stackoverflow.qanda.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    PostCrudRepo postCrudRepo;
    private Post postInDb;
    private Question questionInDb;
    private Answer answerInDb;
    private Answer answer;
    private Comment comment;
    private MongoOperations mongoOperations;

    public Post postQuestion(Post post)
    {
        post.setPostId(sequenceGenerator.generateSequence(Question.seq_name));
        //System.out.println(post.getQuestion());
        post.getQuestion().setQuestionId(sequenceGenerator.generateSequence(Question.seq_name));
        return mongoTemplate.save(post);
    }

    @Override
    public List<Post> getPosts()
    {
        return mongoTemplate.findAll(Post.class,"posts");
    }




    @Override
    public boolean postAnswer(Post post) {
       // System.out.println(post);

        postInDb =mongoTemplate.findOne(new Query().addCriteria(Criteria.where("_id").is(post.getPostId())),Post.class);
        //postInDb=postList.get(0);
        //System.out.println(post+" "+post.getAnswers().get(post.getAnswers().size()-1));
       // System.out.println(questionInDb+" "+null);
        //System.out.println(postInDb);
        if(post.getAnswers()!=null)
        answer=post.getAnswers().get(0);
        if(answer!=null)
        answer.setAnswerId(sequenceGenerator.generateSequence(Answer.seq_name));
        postInDb.setAnswers(post.getAnswers());
        postInDb=mongoTemplate.save(postInDb);
        //System.out.println(postInDb.getAnswers().get(0));
//        if(postInDb.getAnswers().get(postInDb.getAnswers().size()-1).equals(post.getAnswers().get(0)))
        if(postInDb!=null)
        return true;
        return false;
    }
    

    @Override
    public boolean postAnswerComment(Post post) {
        //System.out.println(post);
        postInDb =mongoTemplate.findOne(new Query().addCriteria(Criteria.where("_id").is(post.getPostId())),Post.class);
        //System.out.println(postInDb);
        List<Answer> answers=postInDb.getAnswers();
        for(Answer answer:answers)
        {
                    if (answer.getAnswerId()==post.getAnswers().get(0).getAnswerId())
                    {
                        post.getAnswers().get(0).getComments().get(0).setCommentId(sequenceGenerator.generateSequence(Comment.seq_name));
                        if(answer.getComments()==null)
                            answer.setComments(new ArrayList<Comment>());
                        answer.getComments().add(post.getAnswers().get(0).getComments().get(0));
                    }
        }

        post=mongoTemplate.save(postInDb);
//        Optional<Answer> answers=answerRepo.findById(post.getAnswers().get(0).getAnswerId());
//        if(answers.isPresent())
//            System.out.println(answers.get());
//         answerRepo.findAll().stream().forEach(a->System.out.print(a));
//        UnwindOperation unwind =  Aggregation.unwind("answers");
//        MatchOperation match = Aggregation.match(Criteria.where("postId").is(post.getPostId()).and("answers.answerId").is(post.getAnswers().get(0).getAnswerId()));
//        Aggregation aggregation = Aggregation.newAggregation(unwind,match);
//        AggregationResults<PostUnwind> results = mongoOperations.aggregate(aggregation, "postUnwind",
//                PostUnwind.class);
//         for(PostUnwind:results.getMappedResults())
//         {
//             System.out.println();
//         }
//        postInDb.getAnswers().add(post.getAnswers().get(0));
//        if(postInDb.getComments().equals(null))
//            answerInDb.setComments(new ArrayList<Comment>());
        if(post!=null)
            return true;
        return false;
    }

    @Override
    public Post getPostById(long id) {
        postInDb=mongoTemplate.findOne(new Query().addCriteria(Criteria.where("_id").is(id)),Post.class);
        return postInDb;
    }

    @Override
    public boolean updateQuestionVotes(long postId, String voteType) {
        postInDb=mongoTemplate.findOne(new Query().addCriteria(Criteria.where("_id").is(postId)),Post.class);
        if(postInDb!=null)
        {
          if((voteType!=null)&&voteType.equals("upvote"))
              postInDb.getQuestion().setVotes( postInDb.getQuestion().getVotes()+1);
          else if((voteType!=null)&&voteType.equals("downvote"))
              postInDb.getQuestion().setVotes( postInDb.getQuestion().getVotes()-1);
          else
              return false;
          mongoTemplate.save(postInDb);
          return true;
        }

        return false;
    }

    @Override
    public boolean updateAnswerVotes(long postId, long answerId, String voteType) {

        postInDb=mongoTemplate.findOne(new Query().addCriteria(Criteria.where("_id").is(postId)),Post.class);
        if(postInDb!=null)
        {

                List<Answer> answers = postInDb.getAnswers();
                if(answers.isEmpty())
                    return false;
                for(Answer answer: answers)
                {
                    if(answer.getAnswerId()==answerId)
                    {
                        if((voteType!=null)&&voteType.equals("upvote"))
                        answer.setVotes(answer.getVotes()+1);
                        else if((voteType!=null)&&voteType.equals("downvote"))
                        answer.setVotes(answer.getVotes()-1);
                    }
                }
                postInDb=mongoTemplate.save(postInDb);
                if(postInDb!=null)
                    return true;
                return false;
        }
        return false;
    }

    @Override
    public List<Post> getNewestPosts() {
        Sort sort=Sort.by("dateCreated").descending();
        return postCrudRepo.findAll(sort);
    }

    @Override
    public List<Post> getOldestPosts() {
        Sort sort=Sort.by("dateCreated").ascending();
        return postCrudRepo.findAll(sort);
    }

    @Override
    public List<Post> getUnanswered()
    {
//       QPost.ans
        return null;
    }
}
