package com.example.aprendaingls.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aprendaingls.R;


public class BichosFragment extends Fragment implements View.OnClickListener{

    /**
     * Variáveis do fragment de bichos
     */
    private ImageView buttonDog;
    private ImageView buttonCat;
    private ImageView buttonLion;
    private ImageView buttonMonkey;
    private ImageView buttonSheep;
    private ImageView buttonCow;


    private MediaPlayer mediaPlayer;

    public BichosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        buttonDog = view.findViewById(R.id.buttonDog);
        buttonCat = view.findViewById(R.id.buttonCat);
        buttonLion = view.findViewById(R.id.buttonLion);
        buttonMonkey = view.findViewById(R.id.buttonMonkey);
        buttonSheep = view.findViewById(R.id.buttonSheep);
        buttonCow = view.findViewById(R.id.buttonCow);

        buttonDog.setOnClickListener(this);
        buttonCat.setOnClickListener(this);
        buttonLion.setOnClickListener(this);
        buttonMonkey.setOnClickListener(this);
        buttonCow.setOnClickListener(this);
        buttonSheep.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonDog:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                tocarSom();
                break;
            case R.id.buttonCat:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                break;
            case R.id.buttonLion:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                break;
            case R.id.buttonCow:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                break;
            case R.id.buttonSheep:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                break;
            case R.id.buttonMonkey:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                break;
        }
        
        tocarSom();
    }

    public void tocarSom(){
        if(mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }
}
