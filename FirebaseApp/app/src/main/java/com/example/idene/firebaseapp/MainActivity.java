package com.example.idene.firebaseapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    //recupera a referencia depois a intancia do banco e por ultimo volta ao no raiz
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();//ex:getReference("usuario"); neste caso a referencia passa ser o usuario e n o no raiz
   //gerenciar dados no firebase
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cadastro de usuario
        /*
        usuario.createUserWithEmailAndPassword("carlos@gmail.com","ca12345")
        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {//task objeto de retorno
                if (task.isSuccessful()){
                    Log.i("CreateUser", "Sucesso ao cadastrar usuario!");
                }else{
                    Log.i("CreateUser", "Erro ao cadastrar usuario!");
                }
            }
        });
        */


        //verificar usuario logado
       /*if (usuario.getCurrentUser() != null){
            Log.i("CurrentUser", "Usuario logado!");
        }else{
            Log.i("CurrentUser", "Usuario não logado!");
        }
        */

        //delogar o usuario
        //usuario.signOut();

        //logar usuario
        /*usuario.signInWithEmailAndPassword("carlos@gmail.com","ca12345")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.i("signInUser", "Sucesso ao logar usuario!");
                        }else{
                            Log.i("signInUser", "Erro ao logar usuario!");
                        }
                    }
                });
                */







        // add dados simpes ao firebase
        //referencia.child( "pontos" ).setValue("1200");

        //add dados ao firebase com filhos e mais dados
       /* referencia.child( "usuarios2" )
                .child("001")
                .child("nome")
                .setValue("carlos");*/
       /*
         //criar objeto de referencia do database para uasalo na hora de passar dados para o firebase
        //DatabaseReference usuarios = referencia.child( "usuarios" ).child("001");//buscar apenas apartir do filho 001
        DatabaseReference usuarios = referencia.child( "usuarios" );
        DatabaseReference produtos = referencia.child( "produtos" );

        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {//chama sempre que recuperar algum dados//DataSnapshot retorno do database
                Log.i("FIREBASE", dataSnapshot.getValue().toString());//retono dos valores do firebase
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {//tratar erro caso o dado não for recuperado

            }
        });

        */

       //cadastrar class de usuario
        /*Usuario usuario = new Usuario();
        usuario.setNome("Carlos");
        usuario.setSobrenome("Junior");
        usuario.setIdade(30);
        //enviar o objeto para o firebase
        usuarios.child("001").setValue(usuario);*/

        //cadastrar classe de produto
        /*Produto produto = new Produto();
        produto.setDescricao("Acer aspire");
        produto.setMarca("Acer");
        produto.setPreco(999.99);
        //enviar o objeto para o firebase
        produtos.child("002").setValue(produto);*/




        //criar identificador unico no firebase
        /*
        DatabaseReference usuarios = referencia.child( "usuarios" );

        //cadastrar class de usuario
        Usuario usuario = new Usuario();
        usuario.setNome("Marcelo");
        usuario.setSobrenome("Farias");
        usuario.setIdade(22);
        //enviar o objeto para o firebase
        usuarios.push().setValue(usuario);//push() cria identificador unico
        */



        //filtros
        DatabaseReference usuarios = referencia.child( "usuarios" );
        //recupera o usuario pelo id
        //DatabaseReference usuarioPesquisa = usuarios.child( "-LWvibZjixvQEDLJ3rjv" );

        //Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Marina");//orderByChild("nome") ordena pelo nome
        //Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(2);//Limitar a pesquisa para apenas 2 primeiros usuarios
        //Query usuarioPesquisa = usuarios.orderByKey().limitToLast(2);//Limitar a pesquisa para apenas 2 ultimos usuarios
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(35);//Maior po igual >=
        //Query usuarioPesquisa = usuarios.orderByChild("idade").endAt(23);//Menor que <=
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(20).endAt(30);//Entre valores
        Query usuarioPesquisa = usuarios.orderByChild("nome").startAt("C").endAt("C" + "\uf8ff");//pesquisar letras, + "\uf8ff" ajuda a abrangencia dos unicode reconhecendo a letra


        //selecionar um usuario pelo id
        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                /*
                //usar a class usuarios que temos e recuperarar dados do firebase para ela
                Usuario dadosUsuario = dataSnapshot.getValue(Usuario.class);
                Log.i("Dados usuario:","nome:"+dadosUsuario.getNome());
                */

                Log.i("Dados usuario:", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
