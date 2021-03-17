package com.example.aprendaingls.Fragments;

import android.content.Context;
import android.media.DrmInitData;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aprendaingls.R;

public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageView buttonOne;
    private ImageView buttonTwo;
    private ImageView buttonThree;
    private ImageView buttonFour;
    private ImageView buttonFive;
    private ImageView buttonSix;

    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        buttonOne = view.findViewById(R.id.um);
        buttonTwo = view.findViewById(R.id.dois);
        buttonThree = view.findViewById(R.id.tres);
        buttonFour = view.findViewById(R.id.quatro);
        buttonFive = view.findViewById(R.id.cinco);
        buttonSix = view.findViewById(R.id.seis);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        int itemClicado = v.getId();

        tocarSomById(getActivity(), itemClicado);
    }

    public void tocarSomById(Context ctx,int itemClicado){

        final int sound = getNumber(itemClicado);

        if(sound != 0){
            mediaPlayer = MediaPlayer.create(ctx, sound);
        }

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

    private final int getNumber(int itemClicado){

        switch (itemClicado){
            case R.id.um:
                return R.raw.one;
            case R.id.dois:
                return R.raw.two;
            case R.id.tres:
                return R.raw.three;
            case R.id.quatro:
                return R.raw.four;
            case R.id.cinco:
                return R.raw.five;
            case R.id.seis:
                return R.raw.six;
            default:
                return 0;
        }
    }

}