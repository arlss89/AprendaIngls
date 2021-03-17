package com.example.aprendaingls;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.aprendaingls.Fragments.BichosFragment;
import com.example.aprendaingls.Fragments.NumerosFragment;
import com.example.aprendaingls.Fragments.VogaisFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import static com.example.aprendaingls.constants.Constants.BICHOS;
import static com.example.aprendaingls.constants.Constants.NUMEROS;
import static com.example.aprendaingls.constants.Constants.VOGAIS;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.viewpagerTab);
        viewPager = findViewById(R.id.viewPager);
        getSupportActionBar().setElevation(0);

        //Configurar um adapter para as paginas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add(BICHOS, BichosFragment.class)
                        .add(NUMEROS, NumerosFragment.class)
                        .add(VOGAIS, VogaisFragment.class)
                        .create()
        );

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);


        /*imageDog.setOnClickListener(v -> {
            int song = R.id.um;
            mediaPlayerCreate(song);
        });*/


    }



    private void mediaPlayerCreate(int song) {


        //mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.song);
    }
}