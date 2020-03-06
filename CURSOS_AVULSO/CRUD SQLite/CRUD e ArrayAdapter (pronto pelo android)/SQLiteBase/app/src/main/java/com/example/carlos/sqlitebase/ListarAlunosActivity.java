package com.example.carlos.sqlitebase;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class ListarAlunosActivity extends AppCompatActivity {

    private ListView listView;
    private AlunoDAO dao;
    private List<Aluno>alunos;
    private List<Aluno> alunosFiltrados = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alunos);

        listView = findViewById(R.id.lista_alunos);
        dao = new AlunoDAO(this);
        alunos = dao.obterTodos();
        alunosFiltrados.addAll(alunos);
        //inserir dados no listview sem criar um adapter
        ArrayAdapter<Aluno> adaptador = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, alunosFiltrados);
        listView.setAdapter(adaptador);

        registerForContextMenu(listView);//quando o listview for selecionado ele vai abrir o contexto de menu
    }

    //mostrar botoes na toolbar
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal,menu);

        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {//ouvir o texto no search
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) { //quando o usuario digitar algo
                //System.out.println("Digitou "+ s);
                procuraAluno(s);
                return false;
            }
        });

        return true;
    }

    //colocar o meno no layout de contexto ou seja ao selecionar a listview vou inflar esse contexto
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v ,menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_contexto, menu);
    }

    public void procuraAluno(String nome){//buscar pelo nome
        alunosFiltrados.clear();
        for (Aluno a: alunos){
            if (a.getNome().toLowerCase().contains(nome.toLowerCase())){//toLowerCase tudo minusculo
                alunosFiltrados.add(a);
            }
        }
        listView.invalidateViews();
    }

    public void excluir(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();//pegar o menuinfo passar para adptador para saber qual o item da lista
        final Aluno alunoExcluir = alunosFiltrados.get(menuInfo.position);//assim consigo a position do aluno selecionado e salvo nessa variavel do tipo aluno

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Realmente deseja excluir o aluno?")
                .setNegativeButton("NÃO",null)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    alunosFiltrados.remove(alunoExcluir);
                    alunos.remove(alunoExcluir);
                    dao.excluir(alunoExcluir);
                    listView.invalidateViews();
                    }
                }).create();
        dialog.show();

    }

    public void cadastrar(MenuItem item){
        Intent it = new Intent(this,CadastroAlunoActivity.class);
        startActivity(it);
    }

    public void atualizar(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();//pegar o menuinfo passar para adptador para saber qual o item da lista
        final Aluno alunoAtualizar = alunosFiltrados.get(menuInfo.position);//assim consigo a position do aluno selecionado e salvo nessa variavel do tipo aluno
        Intent it = new Intent(this, CadastroAlunoActivity.class);
        it.putExtra("aluno", alunoAtualizar);
        startActivity(it);
    }

    @Override
    public void onResume(){
        super.onResume();
        alunos = dao.obterTodos();
        alunosFiltrados.clear();
        alunosFiltrados.addAll(alunos);
        listView.invalidateViews();//invalidar dados antigos do liste view
    }
}
