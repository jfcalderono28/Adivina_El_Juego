package com.example.juego;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int attempts = 0;
    int number_winner = 0;
    TextView try1, try2, try3, try4, try5, textView3, textView5, textView7, textView9, textView11, attempt;
    EditText userNumber;
    Button send, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number_winner = n_winner();

        Log.d("numero ganador", String.valueOf(number_winner));


        try1 = findViewById(R.id.try1);
        try2 = findViewById(R.id.try2);
        try3 = findViewById(R.id.try3);
        try4 = findViewById(R.id.try4);
        try5 = findViewById(R.id.try5);

        textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);
        textView7 = findViewById(R.id.textView7);
        textView9 = findViewById(R.id.textView9);
        textView11 = findViewById(R.id.textView11);

        attempt = findViewById(R.id.attempt);

        userNumber = findViewById(R.id.userNumber);
        reset = findViewById(R.id.btn_reset);
        send = findViewById(R.id.btnSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userNumber.getText().toString().isEmpty()) {
                    attempt.setText("No ha escrito nada");

                } else {
                    int n = Integer.parseInt(userNumber.getText().toString());
                    if (n > -1 && n < 101) {
                        attempts++;
                        switch (attempts) {
                            case 1:
                                try1.setText(userNumber.getText().toString());
                                try1.setVisibility(View.VISIBLE);
                                textView3.setVisibility(View.VISIBLE);
                                if (n > number_winner) {
                                    textView3.setText("Es menor");
                                } else if (n < number_winner) {
                                    textView3.setText("Es mayor");
                                } else {
                                    textView3.setText("Es igual");
                                    finish();
                                }
                                break;
                            case 2:
                                try2.setText(userNumber.getText().toString());
                                try2.setVisibility(View.VISIBLE);
                                textView5.setVisibility(View.VISIBLE);
                                if (n > number_winner) {
                                    textView5.setText("Es menor");
                                } else if (n < number_winner) {
                                    textView5.setText("Es mayor");
                                } else {
                                    textView5.setText("Es igual");
                                    finish();
                                }
                                break;
                            case 3:
                                try3.setText(userNumber.getText().toString());
                                try3.setVisibility(View.VISIBLE);
                                textView7.setVisibility(View.VISIBLE);
                                if (n > number_winner) {
                                    textView7.setText("Es menor");
                                } else if (n < number_winner) {
                                    textView7.setText("Es mayor");
                                } else {
                                    textView7.setText("Es igual");
                                    finish();
                                }
                                break;
                            case 4:
                                try4.setText(userNumber.getText().toString());
                                try4.setVisibility(View.VISIBLE);
                                textView9.setVisibility(View.VISIBLE);
                                if (n > number_winner) {
                                    textView9.setText("Es menor");
                                } else if (n < number_winner) {
                                    textView9.setText("Es mayor");
                                } else {
                                    textView9.setText("Es igual");
                                    finish();
                                }
                                break;
                            case 5:
                                try5.setText(userNumber.getText().toString());
                                try5.setVisibility(View.VISIBLE);
                                textView11.setVisibility(View.VISIBLE);
                                finish();
                                if (n > number_winner) {
                                    textView11.setText("Es menor");
                                } else if (n < number_winner) {
                                    textView11.setText("Es mayor");
                                } else {
                                    textView11.setText("Es igual");
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    attempt.setVisibility(View.VISIBLE);
                    String res = String.valueOf(attempts);

                    if (Integer.parseInt(userNumber.getText().toString()) != number_winner && attempts < 5) {
                        attempt.setText(res);
                    } else {
                        attempt.setText("Número ganador: " + number_winner);
                    }
                    userNumber.setText("");
                }

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number_winner = n_winner();
                attempts = 0;

                try1.setVisibility(View.INVISIBLE);
                try2.setVisibility(View.INVISIBLE);
                try3.setVisibility(View.INVISIBLE);
                try4.setVisibility(View.INVISIBLE);
                try5.setVisibility(View.INVISIBLE);

                textView3.setVisibility(View.INVISIBLE);
                textView5.setVisibility(View.INVISIBLE);
                textView7.setVisibility(View.INVISIBLE);
                textView9.setVisibility(View.INVISIBLE);
                textView11.setVisibility(View.INVISIBLE);

                attempt.setText("0");

                send.setEnabled(true);
                userNumber.setEnabled(true);

                reset.setVisibility(View.INVISIBLE);
            }
        });
    }

    public int n_winner() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;
        return numeroAleatorio;
    }

    public void finish() {
        userNumber.setEnabled(false);
        send.setEnabled(false);
        attempt.setText("Número ganador: " + number_winner);
        reset.setVisibility(View.VISIBLE);
    }
}