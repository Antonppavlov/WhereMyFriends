package su.bbrain.wheremyfriends.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import su.bbrain.wheremyfriends.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPhone;
    private Button buttonNext;
    private static final int LOCATION_PERMISSION_ID = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
        createEditTexts();
        createButton();

    }

    private void createEditTexts() {
        editTextName = (EditText) findViewById(R.id.edit_text_name);
        editTextPhone = (EditText) findViewById(R.id.edit_text_phone);
    }

    private void createButton() {
        buttonNext = (Button) findViewById(R.id.button_next);
        buttonNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext();
            }


        });
    }

    private void goNext() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_ID);
            return;
        }

        Intent intent = new Intent(this, CustomMarkerClusteringDemoActivity.class);
        intent.putExtra("name",editTextName.getText().toString());
        intent.putExtra("phone",editTextPhone.getText().toString());
        startActivity(intent);
    }
}
