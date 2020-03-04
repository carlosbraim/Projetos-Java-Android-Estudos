package com.example.idene.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.idene.retrofit.api.CEPService;
import com.example.idene.retrofit.api.DataService;
import com.example.idene.retrofit.model.CEP;
import com.example.idene.retrofit.model.Foto;
import com.example.idene.retrofit.model.Postagem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button botaoRecuperar;
    private TextView textResultado;
    private Retrofit retrofit;
    private DataService service;
    //private List<Foto> listaFoto = new ArrayList<>();
    private List<Postagem> listaPostagem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoRecuperar = findViewById(R.id.buttonRecuperar);
        textResultado = findViewById(R.id.textResultado);

        retrofit = new Retrofit.Builder()
                //.baseUrl("https://viacep.com.br/ws/")
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(DataService.class);

        botaoRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //recuperarCEPRetrofit();
                //recuperarListaRetrofit();
                //salvarPostagem();
                //atualizarPostagem();
                removerPostagem();
            }
        });
    }

    private void removerPostagem(){

        Call<Void> call = service.removerPostagem(2);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if( response.isSuccessful() ){
                    textResultado.setText("Status: " + response.code() );
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });

    }

    private void atualizarPostagem(){

        //configurar objeto postagem
        //Postagem postagem = new Postagem("1234",null,"Corpo postagem");
        //Call<Postagem> call = service.atualizarPostagem(2,postagem);
        //Call<Postagem> call = service.atualizarPostagemPatch(2,postagem);
        Postagem postagem = new Postagem();
        postagem.setBody("corpo da postagem alterado");
        Call<Postagem> call = service.atualizarPostagemPatch(2,postagem);

        call.enqueue(new Callback<Postagem>() {
            @Override
            public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                if( response.isSuccessful() ){
                    Postagem postagemResposta = response.body();
                    textResultado.setText(
                            "Status: " + response.code() +
                                    " id: " + postagemResposta.getId() +
                                    " userId: " + postagemResposta.getUserId() +
                                    "titulo: " + postagemResposta.getTitle() +
                                    "body: " + postagemResposta.getBody()
                    );
                }
            }

            @Override
            public void onFailure(Call<Postagem> call, Throwable t) {

            }
        });

    }

    private void salvarPostagem(){

        //configurar objeto postagem
        //Postagem postagem = new Postagem("1234","Título postagem!","Corpo postagem");

        //DataService service = retrofit.create(DataService.class);
        //Call<Postagem> call = service.salvarPostagem(postagem);
        Call<Postagem> call = service.salvarPostagem("1234","Título postagem!","Corpo postagem");

        call.enqueue(new Callback<Postagem>() {
            @Override
            public void onResponse(Call<Postagem> call, Response<Postagem> response) {
                if( response.isSuccessful() ){
                    Postagem postagemResposta = response.body();
                    textResultado.setText(
                                    "Código: " + response.code() +
                                    " id: " + postagemResposta.getId() +
                                    "titulo: " + postagemResposta.getTitle()
                    );
                }
            }

            @Override
            public void onFailure(Call<Postagem> call, Throwable t) {

            }
        });

    }

    private void recuperarListaRetrofit(){

        //DataService service = retrofit.create(DataService.class);
        //Call<List<Foto>>  call = service.recuperarFotos();
        Call<List<Postagem>>  call = service.recuperarPostagens();

        call.enqueue(new Callback<List<Postagem>>() {
            @Override
            public void onResponse(Call<List<Postagem>> call, Response<List<Postagem>> response) {
                if( response.isSuccessful() ){
                    listaPostagem = response.body();

                    for(int i=0; i<listaPostagem.size(); i++){
                        Postagem postagem = listaPostagem.get(i);
                        Log.d("resultado","resultado" + postagem.getId() + " / " + postagem.getTitle() );
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Postagem>> call, Throwable t) {

            }
        });

    }

    private void recuperarCEPRetrofit(){

        CEPService cepService = retrofit.create( CEPService.class );
        Call<CEP> call = cepService.recuperarCEP("01310100");

        call.enqueue(new Callback<CEP>() {//criar tarefa Async dentro de uma thread
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if ( response.isSuccessful() ){
                    CEP cep = response.body();
                    textResultado.setText( cep.getLogradouro() +" / "+ cep.getBairro());
                }
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {

            }
        });

    }
}
