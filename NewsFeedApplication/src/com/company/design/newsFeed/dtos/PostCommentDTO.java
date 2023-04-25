package com.company.design.newsFeed.dtos;

import com.company.design.newsFeed.constants.*;

import java.util.*;

public class PostCommentDTO extends BaseDto {
    private String text;
    private UserDTO user;
    private PostDTO postDTO;
    private PostCommentDTO parentPostComment;
    private PostCommentStatus status;
    private List<PostCommentDTO> replies = new ArrayList<>();
    private List<VoteDTO> votes = new ArrayList<>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public PostDTO getPostDTO() {
        return postDTO;
    }

    public void setPostDTO(PostDTO postDTO) {
        this.postDTO = postDTO;
    }

    public PostCommentDTO getParentPostComment() {
        return parentPostComment;
    }

    public void setParentPostComment(PostCommentDTO parentPostComment) {
        this.parentPostComment = parentPostComment;
    }

    public PostCommentStatus getStatus() {
        return status;
    }

    public void setStatus(PostCommentStatus status) {
        this.status = status;
    }

    public List<PostCommentDTO> getReplies() {
        return replies;
    }

    public void setReplies(List<PostCommentDTO> replies) {
        this.replies = replies;
    }

    public List<VoteDTO> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteDTO> votes) {
        this.votes = votes;
    }
}
