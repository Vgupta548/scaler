package com.company.design.newsFeed;

import com.company.design.newsFeed.controllers.*;
import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.exceptions.*;
import com.company.design.newsFeed.repository.*;
import com.company.design.newsFeed.services.*;
import com.company.design.newsFeed.session.*;

import java.util.*;

public class Client {
    static SessionManager sessionManager = new SessionManager();
    static SessionService sessionService = new SessionService(sessionManager);
    
    static IUserRepository authRepository = new UserRepositoryImpl();
    static IPostRepository postRepository = new PostRepositoryImpl();
    static IFollowerRepository followerRepository = new FollowerRepositoryImpl();
    static IPostCommentRepository postCommentRepository = new PostCommentRepositoryImpl();
    static IVoteRepository voteRepository = new VoteRepositoryImpl();
    
    static IUserService userService = new UserServiceImpl(authRepository, sessionService, sessionManager);
    static IPostService postService = new PostServiceImpl(postRepository, userService );
    static IFollowerService followerService = new FollowerServiceImpl(followerRepository, userService);
    static IPostCommentService postCommentService = new PostCommentServiceImpl(postCommentRepository, postService, userService);
    static IVoteService voteService = new VoteServiceImpl(voteRepository, postService, postCommentService, userService);
    
    static AuthController authController = new AuthController(userService);
    static PostController postController = new PostController(postService, postCommentService, voteService, sessionService);
    static UserController userController = new UserController(userService, followerService, sessionService);
    
    static Scanner sc = new Scanner(System.in);
    
    static String currentSessionId = null;
    
    public static void main(String[] args){
        provideStartMenu();
    }
    
    private static void provideStartMenu(){
        System.out.println("choose option from menu");
        System.out.println("1: Signup");
        System.out.println("2: Login");
        System.out.println("3: Exit");

        try {
            int option = sc.nextInt();
            System.out.println("option that you selected is: "+option);
            actionOnMainMenu(option);
        }catch (InputMismatchException e){
            System.out.println("incorrect input. please try again ");
            provideStartMenu();
        }
        
    }

    private static void provideLoginUserMenu(){
        
        System.out.println("choose option from menu");
        System.out.println("1: Post");
        System.out.println("2: Follow/UnFollow");
        System.out.println("3: Comment On Post");
        System.out.println("4: Comment On Post Comment");
        System.out.println("5: UpVote/DownVote a Post");
        System.out.println("6: UpVote/DownVote a Comment");
        System.out.println("7: Show Feeds");
        System.out.println("8: Main Menu");
        System.out.println("9: Exit");

        try {
            int option = sc.nextInt();
            System.out.println("option that you selected is: "+option);
            actionOnLoginUserMenu(option);
        }catch (InputMismatchException e){
            System.out.println("incorrect input. please try again ");
            provideLoginUserMenu();
        }
        
    }
    
    private static void actionOnMainMenu(int option){
        switch (option){
            case 1:
                signUp();
                provideStartMenu();
                break;
            case 2:
                currentSessionId = signIn();
                provideLoginUserMenu();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("incorrect option. Please try again");
                provideStartMenu();
        }
        
    }

    private static void actionOnLoginUserMenu(int option){
        switch (option){
            case 1:
                post();
                break;
            case 2:
                follow();
                break;
            case 3:
                postComment();
                break;
            case 4:
                postCommentOnComment();
                break;
            case 5:
                voteOnPost();
                break;
            case 6:
                voteOnComment();
                break;
            case 7:
            //    showNewsFeed();
                break;
            case 8:
                provideStartMenu();
                break;
            case 9:
                return;   
            default:
                System.out.println("incorrect option. Please try again");
        }
        provideLoginUserMenu();
    }
    
    private static UserDTO signUp(){
        System.out.println("Enter userName");
        String userName = sc.next();
        System.out.println("Enter password");
        String password = sc.next();
        System.out.println("Enter email");
        String email = sc.next();
        
        AccountDTO accountDTO = new AccountDTO(userName, password, email);
        UserDTO userDTO = null;
        try {
            userDTO = authController.registerUser(accountDTO);
            System.out.println("Your account created successfully:userid "+userDTO.getId());
        } catch (UserRegistrationException e) {
            System.out.println("Please try again");
            provideStartMenu();
        }catch (Exception e){
            System.out.println("Unable tp process signup request. Try again later");
            provideStartMenu();
        }
        return userDTO;
    }

    private static String signIn(){
        System.out.println("Enter userName");
        String userName = sc.next();
        System.out.println("Enter password");
        String password = sc.next();
        
        AccountDTO accountDTO = new AccountDTO(userName, password, null);
        String sessionId = null;
        try {
            sessionId = authController.login(accountDTO);
            System.out.println("Your session id is: "+sessionId);
        } catch (InvalidLoginCredentials e) {
            System.out.println("Please try again");
            provideStartMenu();
        }catch (Exception e){
            System.out.println("Unable to process signIn request. Try again later");
            provideStartMenu();
        }
        return sessionId;
    }

    private static PostDTO post(){
        System.out.println("Enter text (without space or line break)");
        String text = sc.next();
        System.out.println("entered text is: "+ text);
        PostDTO postDTO = null;
        try {
            postDTO = postController.addPost(currentSessionId, text);
            if(postDTO != null){
                System.out.println("post is generated: postId: "+ postDTO.getId());
                System.out.println("text: "+ postDTO.getText());
            }
        } catch (Exception e){
            System.out.println("Unable to process post request. Try again later");
            provideLoginUserMenu();
        }
        return postDTO;
    }

    private static FollowDTO follow(){
        System.out.println("Enter userId you want to follow");
        String userId = sc.next();

        FollowDTO followDTO = null;
        try {
            followDTO = userController.follow(currentSessionId, userId);
            System.out.println("followed successfully: id: "+ followDTO.getId());
        } catch (FollowerNotExistException e) {
            System.out.println(e.getMessage());
            provideLoginUserMenu();
        } catch (InvalidSessionException e) {
            e.printStackTrace();
            provideStartMenu();
        }
        return followDTO;
    }

    private static PostCommentDTO postComment(){
        System.out.println("Enter the postId");
        String postId = sc.next();
        System.out.println("Enter the Comment (without space or line break)");
        String comment = sc.next();
        System.out.println("entered text is: "+ comment);
        PostCommentDTO postCommentDTO = null;
        try {
            postCommentDTO = postController.postComment(currentSessionId, postId, comment, null);
            System.out.println("commented successfully: id: "+ postCommentDTO.getId());
        } catch (PostNotExistException | PostCommentNotExistException e) {
            System.out.println(e.getMessage());
            provideLoginUserMenu();
        } catch (InvalidSessionException e) {
            e.printStackTrace();
            provideStartMenu();
        }
        return postCommentDTO;
    }

    private static PostCommentDTO postCommentOnComment(){
        System.out.println("Enter the postId");
        String postId = sc.next();
        System.out.println("Enter the post commentId");
        String parentPostCommentId = sc.next();
        System.out.println("Enter the Comment");
        String comment = sc.next();

        PostCommentDTO postCommentDTO = null;
        try {
            postCommentDTO = postController.postComment(currentSessionId, postId, comment, parentPostCommentId);
            System.out.println("commented successfully: id: "+ postCommentDTO.getId());
        } catch (PostNotExistException | PostCommentNotExistException e) {
            System.out.println(e.getMessage());
            provideLoginUserMenu();
        } catch (InvalidSessionException e) {
            e.printStackTrace();
            provideStartMenu();
        } 
        return postCommentDTO;
    }

    private static VoteDTO voteOnPost(){
        System.out.println("Enter the postId");
        String postId = sc.next();
        System.out.println("is UpVote? 1 for upVote. 0 for DownVote");
        int voteInput = sc.nextInt();
        boolean isUpVote = true;
        if(voteInput == 0){
            isUpVote = false;
        }

        VoteDTO voteDTO = null;
        try {
            voteDTO = postController.addVote(currentSessionId, postId, null, isUpVote);
            String voteString = (isUpVote) ? "upVote": "downVote" ;
            System.out.println("vote '"+ voteString+ "' added successfully: id: "+ voteDTO.getId() );
        } catch (PostNotExistException | PostCommentNotExistException e) {
            System.out.println(e.getMessage());
            provideLoginUserMenu();
        } catch (InvalidSessionException e) {
            e.printStackTrace();
            provideStartMenu();
        }
        return voteDTO;
    }

    private static VoteDTO voteOnComment(){
        System.out.println("Enter the commentId");
        String commentId = sc.next();
        System.out.println("is UpVote? 1 for upVote. 0 for DownVote");
        int voteInput = sc.nextInt();
        boolean isUpVote = true;
        if(voteInput == 0){
            isUpVote = false;
        }

        VoteDTO voteDTO = null;
        try {
            voteDTO = postController.addVote(currentSessionId, null, commentId, isUpVote);
            String voteString = (isUpVote) ? "upVote": "downVote" ;
            System.out.println("vote '"+ voteString+ "' added successfully: id: "+ voteDTO.getId() );
        } catch (PostNotExistException | PostCommentNotExistException e) {
            System.out.println(e.getMessage());
            provideLoginUserMenu();
        } catch (InvalidSessionException e) {
            e.printStackTrace();
            provideStartMenu();
        }
        return voteDTO;
    }
}
