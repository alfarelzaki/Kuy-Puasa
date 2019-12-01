package com.moslemdev.kuypuasa;

import android.animation.Animator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.moslemdev.kuypuasa.ui.bottomNav.PuasaCalendar;

public class Animation extends AppCompatActivity {
    LottieAnimationView loading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_spinner);

        loading = findViewById(R.id.loading_view);
        loading.setRepeatCount(android.view.animation.Animation.RELATIVE_TO_PARENT);
        loading.setSpeed((float) 1.5);
        loading.playAnimation();

        loading.addAnimatorListener(new Animator.AnimatorListener(){

            @Override
            public void onAnimationStart(Animator animation) {
                PuasaCalendar.setPuasaKamis();
                PuasaCalendar.setPuasaSenin();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                SharedPreferences sharedPreferences
                        = getSharedPreferences("ISI DATA DIRI", MODE_PRIVATE);
                if (!sharedPreferences.contains("Sudah Terisi")) {

                }

                SharedPreferences.Editor editor
                        = sharedPreferences.edit();
                editor.putString("Sudah Terisi", "done!");
                editor.commit();
                Intent i = new Intent(Animation.this, LandingPage.class);
                startActivity(i);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

}

