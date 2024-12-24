package com.me.appnews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstWindows extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first_windows);
         // créer un délai avant l'ouverture d'une deuxième fenetre

        new Handler().postDelayed(()
                ->  {
            Intent intent = new Intent(FirstWindows.this,OpenActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.enter_frombottom, R.anim.exit_to_top);
            finish();
        },3000);
    }
}