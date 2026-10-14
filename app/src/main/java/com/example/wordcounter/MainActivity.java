package com.example.wordcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private TextMetrics textMetrics;
    private EditText inputTextbox;
    private Spinner spinner;
    private Button button;
    private TextView resultsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inputTextbox= findViewById(R.id.InputText);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.Button);
        resultsText = findViewById(R.id.results);

        textMetrics = new TextMetrics();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

    }

    private void calculate(){
        String input = inputTextbox.getText().toString();


        if (input.trim().isEmpty()){
            Toast.makeText(
                    this,
                    R.string.empty_input, Toast.LENGTH_SHORT
            ).show();

            return;
        }

        int choice = spinner.getSelectedItemPosition();
        String result = "noting";
        System.out.println("Selected Choice: "+ choice);
        switch(choice) {
            case 0:
                result = spinner.getSelectedItem().toString()+ " " + textMetrics.countSentences(input);
                break;
            case 1:
                result = spinner.getSelectedItem().toString()+ " " +textMetrics.countWords(input);
                break;
            case 2:
                result = spinner.getSelectedItem().toString()+ " " +textMetrics.countPunctuation(input);
                break;
            case 3:
                result = spinner.getSelectedItem().toString()+ " " +textMetrics.countNumbers(input);
                break;
            case 4:
//                all

                result = spinner.getSelectedItem().toString()+ " " +textMetrics.countNumbers(input);
            default:
                result = "Nothing";
                break;
        }





        resultsText.setText(result);

    }

}