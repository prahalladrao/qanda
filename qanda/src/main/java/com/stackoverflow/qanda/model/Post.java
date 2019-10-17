package com.stackoverflow.qanda.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
@Document(collection = "posts")
public class Post {
    @Transient
    public static final String seq_name="posts_seq";

    @Id
    private long postId;
    private Question question;
    private List<Answer> answers;
    private Date dateCreated;
    private Date dateLastupdated;

    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", question=" + question +
                ", answers=" + answers +
                '}';
    }


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateLastupdated() {
        return dateLastupdated;
    }

    public void setDateLastupdated(Date dateLastupdated) {
        this.dateLastupdated = dateLastupdated;
    }



    public long  getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


}
