package com.stackoverflow.qanda.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Document(collection = "posts")
public class Answer {
    @Transient
    public static final String seq_name="posts_seq";
    @Id
    private long answerId;
    private String answerBody;
    private List<Comment> comments;
    private long votes;
    private Date dateCreated;
    private Date dateLastupdated;

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
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

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answerBody='" + answerBody + '\'' +
                ", comments=" + comments +
                '}';
    }



    public String getAnswerBody() {
        return answerBody;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public void setAnswerBody(String answerBody) {
        this.answerBody = answerBody;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
