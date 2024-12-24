package com.me.appnews;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    // Déclaration des widgets

    private EditText edtNom, edtPrenom, edtEmail, edtDob, edtPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup); // Lier le layout XML


        edtNom = findViewById(R.id.nom);
        edtPrenom = findViewById(R.id.nom2);
        edtEmail = findViewById(R.id.editTextTextEmailAddress);
        edtDob = findViewById(R.id.editTextDate);
        edtPassword = findViewById(R.id.editTextTextPassword);
        btnRegister = findViewById(R.id.loginButton);


        // Gestion du bouton "Sign Up"
        btnRegister.setOnClickListener(view -> {
            String nom = edtNom.getText().toString().trim();
            String prenom = edtPrenom.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String dob = edtDob.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();

            // Valider les champs
            if (validateFields(nom, prenom, dob, email, password)) {
                // Si la validation réussit, enregistrement des données ou autre action
                Toast.makeText(SignUpActivity.this, "Création de compte réussie!", Toast.LENGTH_SHORT).show();
                // Ajoute ici la logique pour enregistrer dans Firebase ou dans la base de données
            }
        });
    }
    private boolean validateFields(String nom, String prenom, String dob, String email, String password) {
        // Regex pour les noms/prénoms
        String nameRegex = "^[^0-9][a-zA-Z]{2,}";  // Noms et prénoms doivent avoir minimum 3 caractères et ne pas commencer par un chiffre
        // Regex pour mot de passe
        String passwordRegex = "^(?=.*[0-9])(?=.*[!@#\\$%^&*]).{8,}$";  // Minimum 8 caractères, un chiffre et un caractère spécial

        // Vérification du nom
        if (!nom.matches(nameRegex)) {
            Toast.makeText(this, "Le nom doit contenir au moins 3 caractères et ne doit pas commencer par un chiffre.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification du prénom
        if (!prenom.matches(nameRegex)) {
            Toast.makeText(this, "Le prénom doit contenir au moins 3 caractères et ne doit pas commencer par un chiffre.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification de l'email
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Veuillez entrer un email valide.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification de la date de naissance
        if (!dob.matches("\\d{2}/\\d{2}/\\d{4}")) {  // Vérifie si la date est sous le format jj/mm/yyyy
            Toast.makeText(this, "La date de naissance doit être sous le format jj/mm/yyyy.", Toast.LENGTH_SHORT).show();
            return false;
        }

        try {
            // Extraire l'année de la date
            String[] dateParts = dob.split("/");  // Découpe la date en jour, mois, année
            int year = Integer.parseInt(dateParts[2]);  // L'année est la troisième partie de la date

            // Vérification si l'année est avant 2010
            if (year >= 2010) {
                Toast.makeText(this, "La date de naissance doit être avant 2010.", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "La date de naissance est invalide.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Vérification du mot de passe
        if (!password.matches(passwordRegex)) {
            Toast.makeText(this, "Le mot de passe doit contenir au moins 8 caractères, un chiffre et un caractère spécial.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true; // Si tout est valide
    }
}




