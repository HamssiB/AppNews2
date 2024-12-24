package com.me.appnews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class OpenActivity extends AppCompatActivity {

    private ImageView logoImageView;
    private Button signUpButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open); // Lier le layout XML à l'activité

        overridePendingTransition(R.anim.enter_frombottom, R.anim.exit_to_top);

        // créer un arc

        class ArcTextView extends View {
            private Paint paint;
            private String text = "Welcome!!!";
            private float textSize = 100f;

            public ArcTextView(Context context, AttributeSet attrs) {
                super(context, attrs);
                init();
            }

            private void init() {
                paint = new Paint();
                paint.setAntiAlias(true);
                paint.setTextSize(textSize);
                paint.setStyle(Paint.Style.FILL);
            }

            @Override
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                drawArcText(canvas);
            }

            private void drawArcText(Canvas canvas) {
                Path path = new Path();
                float radius = 300; // Rayon de l'arc
                float centerX = getWidth() / 2;
                float centerY = getHeight() / 2;

                // Créez un arc
                path.addArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, 0, 180);

                // Dessinez le texte sur l'arc
                canvas.drawTextOnPath(text, path, 0, 0, paint);
            }
        }



        // Initialisation des widgets via leurs ID
        //logoImageView = findViewById(R.id.logo2);
        signUpButton = findViewById(R.id.button);
        loginButton = findViewById(R.id.button2);

        // Gestion des événements (exemple : clic sur le bouton "S'inscrire")
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code à exécuter lorsque "S'inscrire" est cliqué
                Intent intent1 = new Intent(OpenActivity.this, SignUpActivity.class);
                startActivity(intent1);
                //Toast.makeText(OpenActivity.this, "S'inscrire cliqué", Toast.LENGTH_SHORT).show();
            }
        });

        // Gestion des événements (exemple : clic sur le bouton "Se connecter")
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(OpenActivity.this, LoginActivity.class);
                startActivity(intent2);
                // Code à exécuter lorsque "Se connecter" est cliqué
               // Toast.makeText(OpenActivity.this, "Se connecter cliqué", Toast.LENGTH_SHORT).show();
            }
        });
    }

}