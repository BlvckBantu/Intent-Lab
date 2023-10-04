package com.example.twoactivities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.twoactivities.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSend;
    private Button buttonSend;
    private TextView textReceivedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSend = findViewById(R.id.editText_send);
        buttonSend = findViewById(R.id.button_send);
        textReceivedMessage = findViewById(R.id.text_received_message);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from the EditText
                String enteredText = editTextSend.getText().toString();

                // Create an Intent to start the SecondActivity
                Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);

                // Pass the entered text as an extra to the intent
                secondActivityIntent.putExtra("MESSAGE_KEY", enteredText);

                // Start the SecondActivity using the Intent
                startActivityForResult(secondActivityIntent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // Receive the reply from SecondActivity
                String reply = data.getStringExtra("REPLY_KEY");

                // Display the received reply in the TextView
                textReceivedMessage.setText(reply);

                // Clear the EditText
                editTextSend.setText("");
            }
        }
    }
}