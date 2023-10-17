package com.example.lape22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private EditText editTextText;
    private TextView textView;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.editTextText = findViewById(R.id.editTextText);
        this.textView = findViewById(R.id.textview);
        this.spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter(adapter);
    }

    public void btnCountClick(View view) {
        String selectedOption = this.spinner.getSelectedItem().toString();
        String userTrout = this.editTextText.getText().toString().trim();

        // Validate if the input string is empty
        if (userTrout.isEmpty()) {
            // Show warning toast if the string is empty
            Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show();
        } else {
            // String is not empty, proceed with counting characters/words based on the selected option
            if (selectedOption.equalsIgnoreCase("chars")) {
                // Calculate character count using getCharCount method
                int count = getCharCount(userTrout);
                Log.i("userTextCount", String.valueOf(count));
                this.textView.setText(String.valueOf(count));
            } else if (selectedOption.equalsIgnoreCase("words")) {
                // Calculate word count using getWordCount method
                int count = getWordCount(userTrout);
                Log.i("userTextCount", String.valueOf(count));
                this.textView.setText(String.valueOf(count));
            } else {
                Toast.makeText(this, "Option not implemented", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Method to count characters in a string
    public static int getCharCount(String phrase) {
        return phrase.length();
    }

    // Method to count words in a string
    public static int getWordCount(String phrase) {
        // Split the phrase by spaces and count the resulting array length
        String[] words = phrase.split("\\s+");
        return words.length;
    }
}





