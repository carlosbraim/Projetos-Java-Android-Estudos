package com.example.idene.mediaplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SeekBar seekVolume;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //carregar uma musica automaticamente
         mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
         inicializarSeekBar();
    }

    private void inicializarSeekBar(){

        seekVolume = findViewById(R.id.seekVolume);

        //configurar o audio mananger
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);//descobrir volume atual e volume maximo q o usuario pode usar

        // recuperar os volores de volume maximo e o valor atual
        int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        //configurar o volume maximo para o SeekBar
        seekVolume.setMax(volumeMaximo);

        //configurar o progresso atual do seekBar
        seekVolume.setProgress(volumeAtual);

        //mudar o valor usando o seekBar
        seekVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,
                        AudioManager.FLAG_SHOW_UI);//flags ao pesquisar = audiomanager setstreamvolume é possivel fazer configuração para quando auterar o volume podendo ser 0 ou o q foi alterado que quando sobe o volume mostra o volume do celular

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    public  void executarSom(View view){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    public  void pausarMusica(View  view){
        if (mediaPlayer.isPlaying()){//se a musica estiver tocando
            mediaPlayer.pause();
        }
    }

    public void pararMusica(View view){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();//para a musica
            //carregar uma musica novamente
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
        }
    }

    @Override
    protected void onStop() {//pausar a musica assim q o usuario sair do app
        super.onStop();
        if (mediaPlayer.isPlaying()){//se a musica estiver tocando
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mediaPlayer != null){
            mediaPlayer.start();
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {//caso seja destruido vou parar a musica e retirar da memoria liberando espaço e não ocupar espaços de memoria
        super.onDestroy();
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
