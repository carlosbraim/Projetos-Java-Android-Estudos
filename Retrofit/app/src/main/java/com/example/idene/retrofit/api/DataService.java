package com.example.idene.retrofit.api;

import com.example.idene.retrofit.model.Foto;
import com.example.idene.retrofit.model.Postagem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DataService {

    //Formato JSON
    @GET("/photos")
    Call<List<Foto>> recuperarFotos();

    @GET("/posts")
    Call<List<Postagem>> recuperarPostagens();

    @POST("/posts")
    Call<Postagem> salvarPostagem(@Body Postagem postagem);//@Body converte para o modo JSON

    //formato XML
    //userId=1234&tiítulo postagem&body=Corpo postagem
    @FormUrlEncoded
    @POST("/posts")
    Call<Postagem> salvarPostagem(
            @Field("userId") String userId,
            @Field("title") String title,
            @Field("body") String body
    );

    @PUT("/posts/{id}")//atualiza todos os dados
    Call<Postagem> atualizarPostagem(@Path("id") int id, @Body Postagem postagem);

    @PATCH("/posts/{id}") //atualiza apenas os campos enviados
    Call<Postagem> atualizarPostagemPatch(@Path("id") int id, @Body Postagem postagem);

    @DELETE("/posts/{id}")
    Call<Void> removerPostagem(@Path("id") int id);


}

