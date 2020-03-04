package com.example.idene.retrofit.api;

import com.example.idene.retrofit.model.CEP;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {

    /*@GET("01310100/json/") //Cep fixo
    Call<CEP> recuperarCEP();*/
    @GET("{cep}/json/")
    Call<CEP> recuperarCEP(@Path("cep") String cep);//para passar o parametro para o @GET

}
