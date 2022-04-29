package com.example.kmart.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kmart.MainMenuActivity;
import com.example.kmart.R;

public class LoginActivity extends AppCompatActivity {
    private TextView usernameField, passwordField;
    private AuthService authService;

    private Credentials getCredentialsFromForm() {
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();

        return new Credentials(username, password);
    }

    private void openMainMenuActivity() {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }

    private void submitLogin() {
        Toast.makeText(this, "submit", Toast.LENGTH_LONG);
        Credentials credentials = getCredentialsFromForm();
        if (this.authService.areCredentialsValid(credentials)) {
            Toast.makeText(this, "Logado com sucesso", Toast.LENGTH_LONG).show();
            openMainMenuActivity();
        } else {
            Toast.makeText(this, "Credenciais inválidas", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);


        this.usernameField = findViewById(R.id.loginform_login);
        this.passwordField = findViewById(R.id.loginform_password);

        Button submitBtn = findViewById(R.id.login_submit);
        submitBtn.setOnClickListener(it -> submitLogin());

        this.authService = new AuthService(this);
    }
}