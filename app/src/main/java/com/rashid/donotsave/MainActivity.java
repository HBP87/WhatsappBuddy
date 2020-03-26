package com.rashid.donotsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hbb20.CountryCodePicker;


public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView errorMessage;
    private CountryCodePicker ccp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void browser1(View view) {
        editText = (EditText) findViewById(R.id.edit_num);
        errorMessage = (TextView) findViewById(R.id.error_message_view);
        ccp = (CountryCodePicker)findViewById(R.id.mySpinner);

        String countryCode = ccp.getFullNumber();
        String mobileNumber = countryCode + editText.getText().toString();
        if (!mobileNumber.isEmpty()) {
            String url = "https://api.whatsapp.com/send?phone=+" + mobileNumber;
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        } else {
            errorMessage.setText("Enter Mobile Number First");
        }

    }
}
