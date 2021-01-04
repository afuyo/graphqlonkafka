package com.graphql.graphqltools1.demomodels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePostInput {
    String id;
    String text;
    // private Iterable<CreateCommentInput> comments;

    public CreatePostInput() {}

  /*  public String getId() { return this.id; }
    public String getText() { return this.text; }
    // public Iterable<CreateCommentInput> getComments() { return this.comments; }
    public void setId(String id) { this.id = id; }
    public void setText(String text) { this.text = text; }*/
    //public void setComments(Iterable<CreateCommentInput> comments) { this.comments = comments; }
}