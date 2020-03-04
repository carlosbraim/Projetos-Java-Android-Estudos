package com.example.idene.listadetarefas.activity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.idene.listadetarefas.R;
import com.example.idene.listadetarefas.helper.TarefaDAO;
import com.example.idene.listadetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.textTarefa);

        //Recuperar tarefa, caso seja para edicao
        tarefaAtual =(Tarefa) getIntent().getSerializableExtra("tarefaSelecionada"); //buscando os dados de tarefa de main

        //Configurar tarefa na caixa de texto
        if (tarefaAtual != null){
            editTarefa.setText(tarefaAtual.getNomeTarefa());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//Criar o menu
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa,menu);//add botão no bar
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemSalvar:
                //executar acao para o item salvar
                /*Toast.makeText(AdicionarTarefaActivity.this,"Botao salvar precionado",
                        Toast.LENGTH_SHORT).show();*/
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                if (tarefaAtual != null){//edicao
                    String nomeTarefa = editTarefa.getText().toString();
                    if (!nomeTarefa.isEmpty()){

                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);//contem o valor antigo
                        tarefa.setId(tarefaAtual.getId());

                        //atualizar no banco de dados
                        if (tarefaDAO.atualizar(tarefa)){
                            finish();
                            Toast.makeText(AdicionarTarefaActivity.this,"Sucesso ao salvar tarefa",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(AdicionarTarefaActivity.this,"Erro ao atualizar tarefa",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(AdicionarTarefaActivity.this,"Campo em branco favor adicionar a tarefa",
                                Toast.LENGTH_SHORT).show();
                    }
                }else { //salvar
                    String nomeTarefa = editTarefa.getText().toString();
                    if (!nomeTarefa.isEmpty()){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);
                        if (tarefaDAO.salvar(tarefa)){
                            finish();
                            Toast.makeText(AdicionarTarefaActivity.this,"Sucesso ao salvar tarefa",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(AdicionarTarefaActivity.this,"Erro ao salvar tarefa",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(AdicionarTarefaActivity.this,"Campo em branco favor adicionar a tarefa",
                                Toast.LENGTH_SHORT).show();
                    }
                }


                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
