package com.example.vikas.salestask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapEditText;

public class SecondActivity extends AppCompatActivity {
    BootstrapEditText edt_name, edt_role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edt_name = (BootstrapEditText) findViewById(R.id.edt_name);
        edt_role = (BootstrapEditText) findViewById(R.id.edt_role);
        if(getIntent().getStringExtra("name")!=null)
            edt_name.setText(getIntent().getStringExtra("name"));
        if(getIntent().getStringExtra("role")!=null)
            edt_role.setText(getIntent().getStringExtra("role"));

        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_role.getText().toString() != null &&
                        !edt_role.getText().toString().equals("")) {
                    Intent intent = new Intent();
                    intent.putExtra("flag", getIntent().getStringExtra("flag"));
                    intent.putExtra("role", edt_role.getText().toString());
                    intent.putExtra("name", edt_name.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(SecondActivity.this, "Please Enter Role", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }


        });
    }
}
