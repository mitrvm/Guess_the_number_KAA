package com.example.guess_the_number_kaa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;

    int guess;
    boolean gameFinished;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView);
        etInput = (EditText)findViewById(R.id.editTextNumber);
        bControl = (Button)findViewById(R.id.button);

        guess = (int) (Math.random() * 100);
        gameFinished = false;

    }

    public void OnClick(View v){
        if (!gameFinished){
            int inp=Integer.parseInt(etInput.getText().toString());
            String inp_s=Integer.toString(inp);
            if (inp_s.length()==0)
                tvInfo.setText(getResources().getString(R.string.error));
            if (inp>guess)
                tvInfo.setText(getResources().getString(R.string.ahead));
            if (inp<guess)
                tvInfo.setText(getResources().getString(R.string.behind));
            if (inp<0)
                tvInfo.setText(getResources().getString(R.string.too_little));
            if (inp>100)
                tvInfo.setText(getResources().getString(R.string.too_much));
            if (inp<0)
                tvInfo.setText(getResources().getString(R.string.too_little));
            if (inp==guess){
                tvInfo.setText(getResources().getString(R.string.input_value));
                bControl.setText(getResources().getString(R.string.play_more));
                gameFinished=true;
            }


        }
        else
        {
            guess = (int)(Math.random()*100);
            bControl.setText("Ввести значение:");
            tvInfo.setText("Попробуйте угадать число (1-100)");
            gameFinished = false;
        }

        etInput.setText("");
    }

}


