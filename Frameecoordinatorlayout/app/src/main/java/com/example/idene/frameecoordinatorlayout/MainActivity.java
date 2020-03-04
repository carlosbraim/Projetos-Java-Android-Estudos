package com.example.idene.frameecoordinatorlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameCarregando);
        //frameLayout.setVisibility(View.GONE);//Gone faz com q o componente desaparece
    }
/*
    public void abrir(View view){
        frameLayout.setVisibility(View.VISIBLE);//componente fica visivel
    }*/
}
