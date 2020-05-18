//package com.example.uplusapi;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class LoginActivity extends AppCompatActivity {
//
//    EditText edtEmail;
//    EditText edtPassword;
//    Button btnLogin;
//    UserService userService;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        edtEmail = findViewById(R.id.email_text);
//        edtPassword = findViewById(R.id.pwd_text);
//        btnLogin = findViewById(R.id.login_btn);
//        userService = ApiUtils.getUserService();
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = edtEmail.getText().toString();
//                String password = edtPassword.getText().toString();
//
//                if(validateLogin(email, password)){
//                    //do login
//                    doLogin();
//                }
//            }
//        });
//    }
//
//    private boolean validateLogin(String email, String password){
//        if(email == null || email.trim().length() == 0){
//            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if(password == null || password.trim().length() == 0){
//            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        return true;
//    }
//
//    public void doLogin(){
//        Call call = userService.login();
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                if(response.isSuccessful()){
//                    Toast.makeText(LoginActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(LoginActivity.this, "Not Logged in", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                Toast.makeText(LoginActivity.this, "Failed login", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//}