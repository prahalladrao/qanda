package com.stackoverflow.qanda.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Document(collection = "posts")
public class Question {
    @Transient
    public static final String seq_name="posts_seq";
    @Id
    private long questionId;
    private String questionText;
    private String questionBody;
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

    public Question(long questionId, String questionText, String questionBody, List<Comment> comments) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.questionBody = questionBody;
        this.comments = comments;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
