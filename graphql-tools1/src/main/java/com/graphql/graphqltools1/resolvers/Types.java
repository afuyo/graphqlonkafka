package com.graphql.graphqltools1.resolvers;

import java.util.List;
import java.util.Map;

public class Types {
  
  public static class MutationCreatePostArgs {
    private String text;
  
    public MutationCreatePostArgs() {}
  
    public String getText() { return this.text; }
    public void setText(String text) { this.text = text; }
  }
  public static class MutationCreateUserArgs {
    private String name;
  
    public MutationCreateUserArgs() {}
  
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
  }
  public static class MutationCreateNestedPostArgs {
    private CreatePostInput input;
  
    public MutationCreateNestedPostArgs() {}
  
    public CreatePostInput getInput() { return this.input; }
    public void setInput(CreatePostInput input) { this.input = input; }
  }
  public static class MutationCreateNestedPost2Args {
    private CreatePostInput2Input input;
  
    public MutationCreateNestedPost2Args() {}
  
    public CreatePostInput2Input getInput() { return this.input; }
    public void setInput(CreatePostInput2Input input) { this.input = input; }
  }
  public static class MutationCreateNestedPost3Args {
    private CreatePostInput3Input input;
  
    public MutationCreateNestedPost3Args() {}
  
    public CreatePostInput3Input getInput() { return this.input; }
    public void setInput(CreatePostInput3Input input) { this.input = input; }
  }
  
  
  
  public static class SubscriptionUserSubArgs {
    private String name;
  
    public SubscriptionUserSubArgs() {}
  
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
  }
  public static class CreatePostInput {
    private Object id;
    private String text;
    private CreateCommentInput comments;
  
    public CreatePostInput() {}
  
    public Object getId() { return this.id; }
    public String getText() { return this.text; }
    public CreateCommentInput getComments() { return this.comments; }
    public void setId(Object id) { this.id = id; }
    public void setText(String text) { this.text = text; }
    public void setComments(CreateCommentInput comments) { this.comments = comments; }
  }
  public static class CreatePostInput2Input {
    private Object id;
    private String text;
    private Iterable<CreateCommentInput2Input> comments;
  
    public CreatePostInput2Input() {}
  
    public Object getId() { return this.id; }
    public String getText() { return this.text; }
    public Iterable<CreateCommentInput2Input> getComments() { return this.comments; }
    public void setId(Object id) { this.id = id; }
    public void setText(String text) { this.text = text; }
    public void setComments(Iterable<CreateCommentInput2Input> comments) { this.comments = comments; }
  }
  public static class CreateCommentInput2Input {
    private Object id;
    private String description;
  
    public CreateCommentInput2Input() {}
  
    public Object getId() { return this.id; }
    public String getDescription() { return this.description; }
    public void setId(Object id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
  }
  public static class CreatePostInput3Input {
    private Long ident;
    private String svensktext;
  
    public CreatePostInput3Input() {}
  
    public Long getIdent() { return this.ident; }
    public String getSvensktext() { return this.svensktext; }
    public void setIdent(Long ident) { this.ident = ident; }
    public void setSvensktext(String svensktext) { this.svensktext = svensktext; }
  }
  public static class CreateCommentInput {
    private Object id;
    private String description;
  
    public CreateCommentInput() {}
  
    public Object getId() { return this.id; }
    public String getDescription() { return this.description; }
    public void setId(Object id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
  }
}
