package com.example.idene.abas.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.idene.abas.Activity.Fragment.EmAltaFragment;
import com.example.idene.abas.Activity.Fragment.HomeFragment;
import com.example.idene.abas.Activity.Fragment.InscricoesFragment;
import com.example.idene.abas.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentStatePagerItemAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        smartTabLayout = findViewById(R.id.viewPagerTab);

        //Aplica configuraçoes na Action Bar
        getSupportActionBar().setElevation(0);//tirar o risco entre os dois layout
        getSupportActionBar().setTitle("Youtub");

        //configura as abas
        FragmentStatePagerItemAdapter adapter = new FragmentStatePagerItemAdapter(//esse adptador recebe tudo abaixo
                getSupportFragmentManager(),//gerenciador de fragmentos
                FragmentPagerItems.with(this)//classe com as configuraçoes dos fragmentos das abas
                    .add("Home",HomeFragment.class)//adicionar o fragmento no add
                    .add("Inscricoe",InscricoesFragment.class)
                    .add("Em Alta",EmAltaFragment.class)
                .create()//criar as abas automaticamente

        );
        //passando o adaptador para o viewpager
        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);//smartTabLayout para configurar o viewPager
    }
}
