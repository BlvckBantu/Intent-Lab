package com.example.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private EditText editTextReply;
    private Button buttonSendReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTextReply = findViewById(R.id.editText_reply);
        buttonSendReply = findViewById(R.id.button_send_reply);
        TextView textReceivedMessage = findViewById(R.id.text_received_message); // Added this line

        // Get the message received from MainActivity
        String receivedMessage = getIntent().getStringExtra("MESSAGE_KEY");

        // Set the received message in the TextView
        textReceivedMessage.setText(receivedMessage);

        buttonSendReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the reply text from the EditText
                String replyText = editTextReply.getText().toString();

                // Create an Intent to send the reply back to MainActivity
                Intent replyIntent = new Intent();
                replyIntent.putExtra("REPLY_KEY", replyText);

                // Set the result to be sent back to MainActivity
                setResult(RESULT_OK, replyIntent);

                // Finish the SecondActivity
                finish();
            }
        });
    }
}