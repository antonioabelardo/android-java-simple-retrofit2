package br.eti.urbano.mobile.exemploretrofit2.resource;

import java.util.List;

import br.eti.urbano.mobile.exemploretrofit2.model.Comments;

public interface CommentsResource {

    @GET("/comments")
    Call<List<Comments>> get();

    @GET("/comments/{id}")
    Call<Comments> get(Integer id);

    @POST("/comments")
    Call<Comments> post(Comments comments);

    @PUT("/comments/{id}")
    Call<Comments> put(Comments comments);

    @DELETE("/comments/{id}")
    Call<Void> delete(Comments comments);

    @PATCH("/comments/{id}")
    Call<Comments> patch(Integer id);
}
