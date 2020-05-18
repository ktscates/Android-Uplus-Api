package com.example.uplusapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtEmail;
    EditText edtPassword;
    EditText edtConfirm;
    Button btnRegister;
//    UserService userService;
    ApiUtils apiUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.name_text);
        edtEmail = findViewById(R.id.email_text);
        edtPassword = findViewById(R.id.pwd_text);
        edtConfirm = findViewById(R.id.cpwd_text);
        btnRegister = findViewById(R.id.register_btn);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiUtils = retrofit.create(ApiUtils.class);
//        userService = ApiUtils.getUserService();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String confirm = edtConfirm.getText().toString();

                register();
            }
        });
    }

    public void register(){

        Call<Register> call = apiUtils.register();
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if(response.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(RegisterActivity.this, "Not Registered", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Failed to Register user", Toast.LENGTH_LONG).show();
            }
        });

    }
}









