package com.example.idene.aprendaingls.Acitivity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.idene.aprendaingls.Fragments.BichosFragment;
import com.example.idene.aprendaingls.Fragments.NumerosFragment;
import com.example.idene.aprendaingls.Fragments.VogaisFragment;
import com.example.idene.aprendaingls.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentStatePagerItemAdapter;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //configuracaoes action bar
        getSupportActionBar().setElevation(0);//remover a sobra "linha"
        getSupportActionBar().setTitle("Aprenda Inglês");

        smartTabLayout = findViewById(R.id.smartTabLayout);
        viewPager = findViewById(R.id.viewpager);

        FragmentStatePagerItemAdapter adapter = new FragmentStatePagerItemAdapter(
                getSupportFragmentManager(),//passa os objetos que fazem o gerenciamento dos fragmentos
                FragmentPagerItems.with(this)//configuração dos itens que seram usados
                .add("Bichos",BichosFragment.class)
                .add("Números",NumerosFragment.class)
                .add("Vogais",VogaisFragment.class)
                .create()//crear
        );

        //configuracao
        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }
}
