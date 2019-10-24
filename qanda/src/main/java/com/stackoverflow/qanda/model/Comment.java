package com.stackoverflow.qanda.model;


import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Document(collection="posts")
public class Comment {
    @Transient
    public static final String seq_name="posts_seq";
    private long commentId;
    private String commentBody;
    private Date dateCreated;
    private Date dateLastupdated;
    private long userName;

    public long getUserName() {
        return userName;
    }

    public void setUserName(long userName) {
        this.userName = userName;
    }

    public Set<String> getSetOfUsersVoted() {
        return setOfUsersVoted;
    }

    public void setSetOfUsersVoted(Set<String> setOfUsersVoted) {
        this.setOfUsersVoted = setOfUsersVoted;
    }

    private Set<String> setOfUsersVoted;

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
        return "Comment{" +
                "commentId=" + commentId +
                ", commentBody='" + commentBody + '\'' +
                '}';
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
}
