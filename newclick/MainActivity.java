package com.example.a0509;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//     -- this is what we regulary do
//        Button mainBtn = findViewById(R.id.mainBtn);
//        mainBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getBaseContext(), "Clicked", Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        // -- a new approach
        // -- don't forget to update the xml
        if (view.getId() == R.id.mainBtn)
        {
	// do this when button1 was clicked
        Toast.makeText(getBaseContext(), "Clicked", Toast.LENGTH_LONG).show();
        }
        else if (view.getId() == R.id.mainBtn2)
        {
	// do this when button2 was clicked
        Toast.makeText(getBaseContext(), "Clicked", Toast.LENGTH_LONG).show();
        }

    }
}
