package com.company.design.newsFeed.mapper;

import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.entites.*;

public class ObjectMapper {

    ObjectMapper(){}
    
    public static UserDTO mapUserToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        mapBasic(user, userDTO);
        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmailId(user.getEmailId());
        userDTO.setUserType(user.getUserType());
        userDTO.setUserStatus(user.getUserStatus());
        return userDTO;
    }

    public static PostDTO mapPostToPostDTO(Post post){
        PostDTO postDTO = new PostDTO();
        mapBasic(post, postDTO);
        postDTO.setText(post.getText());
        postDTO.setStatus(post.getStatus());
        postDTO.setUser(post.getUser());
        return postDTO;
    }

    public static FollowDTO mapFollowToFollowDTO(Follow follow){
        FollowDTO followDTO = new FollowDTO();
        mapBasic(follow, followDTO);
        followDTO.setFollowedUser(follow.getFollowedUser());
        followDTO.setFollowerUser(follow.getFollowedUser());
        followDTO.setStatus(follow.getStatus());
        return followDTO;
    }

    public static PostCommentDTO mapPostCommentToPostCommentDTO(PostComment postComment){
        PostCommentDTO postCommentDTO = new PostCommentDTO();
        mapBasic(postComment, postCommentDTO);
        postCommentDTO.setPostDTO( mapPostToPostDTO(postComment.getPost()));
        postCommentDTO.setText(postComment.getText());
        postCommentDTO.setUser(mapUserToUserDTO(postComment.getUser()));
        if(postComment.getParentPostComment() != null) {
            postCommentDTO.setParentPostComment(mapPostCommentToPostCommentDTO(postComment.getParentPostComment()));
        }
        postCommentDTO.setStatus(postComment.getStatus());
        return postCommentDTO;
    }

    public static VoteDTO mapVoteToVoteDTO(Vote vote){
        VoteDTO voteDTO = new VoteDTO();
        mapBasic(vote, voteDTO);
        voteDTO.setUpVote(vote.isUpVote());
        if(vote.getPost() != null) {
            voteDTO.setPost(mapPostToPostDTO(vote.getPost()));
        }
        if(vote.getComment() != null) {
            voteDTO.setComment(mapPostCommentToPostCommentDTO(vote.getComment()));
        }
        voteDTO.setUser(mapUserToUserDTO(vote.getUser()));
        return voteDTO;
    }
    
    private static <T, R> void mapBasic(T sEntity, R tDTO){
        BaseEntity baseEntity = (BaseEntity) sEntity;
        BaseDto baseDto = (BaseDto) tDTO;
        baseDto.setId(baseEntity.getId());
        baseDto.setCreatedAt(baseEntity.getCreatedAt());
        baseDto.setModifiedAt(baseDto.getModifiedAt());
    }
    
}
