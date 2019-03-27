package com.example.vikas.salestask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.beardedhen.androidbootstrap.BootstrapButton;


public class FirstActivity extends AppCompatActivity {
    String nameSales,roleSales,nameCustomer,roleCustomer,nameSupplier,roleSupplier;
    BootstrapButton btn_customer,btn_supplier,btn_salesman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btn_customer=(BootstrapButton)findViewById(R.id.btn_customer);
        btn_supplier=(BootstrapButton)findViewById(R.id.btn_supplier);
        btn_salesman=(BootstrapButton)findViewById(R.id.btn_salesman);
        final Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
        btn_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent .putExtra("flag","1");
                if(nameCustomer!=null )
                intent .putExtra("name",nameCustomer);
                if(roleCustomer!=null)
                    intent .putExtra("role",roleCustomer);
                startActivityForResult(intent,1);
            }
        });
        btn_supplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("flag","2");
                if(nameCustomer!=null )
                    intent .putExtra("name",nameSupplier);
                if(roleSupplier!=null)
                    intent .putExtra("role",roleSupplier);
                startActivityForResult(intent,1);
            }
        });
        btn_salesman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("flag","3");
                if(nameCustomer!=null )
                    intent .putExtra("name",nameSales);
                if(roleSupplier!=null)
                    intent .putExtra("role",roleSales);
                startActivityForResult(intent,1);
            }
        });

    }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                if(data!=null&&data.getStringExtra("flag")!=null)
                if(data.getStringExtra("flag").equals("1")&&
                        data.getStringExtra("role")!=null&&
                        data.getStringExtra("name")!=null){
                    btn_customer.setText(data.getStringExtra("role"));
                    nameCustomer=data.getStringExtra("name");
                    roleCustomer=data.getStringExtra("role");

                }else if(data.getStringExtra("flag").equals("2")&&
                        data.getStringExtra("role")!=null&&
                        data.getStringExtra("name")!=null){
                    btn_supplier.setText(data.getStringExtra("role"));
                    nameSupplier=data.getStringExtra("name");
                    roleSupplier=data.getStringExtra("role");

                }else if(data.getStringExtra("flag").equals("3")&&
                        data.getStringExtra("role")!=null&&
                        data.getStringExtra("name")!=null){
                    btn_salesman.setText(data.getStringExtra("role"));
                    nameSales=data.getStringExtra("name");
                    roleSales=data.getStringExtra("role");

                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
