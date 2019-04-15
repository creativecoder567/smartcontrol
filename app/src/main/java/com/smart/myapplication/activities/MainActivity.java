package com.smart.myapplication.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smart.myapplication.App;
import com.smart.myapplication.R;
import com.smart.myapplication.model.logindetail.Company;
import com.smart.myapplication.model.logindetail.Data;
import com.smart.myapplication.model.logindetail.Example;
import com.smart.myapplication.model.logindetail.User;
import com.smart.myapplication.utils.ErrorHandling;


import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnLogin;
    private EditText mEtEmail, mEtPassword;
    private SharedPreferences mSharedPreferences;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setListener();
    }

    private void bindViews() {
        mBtnLogin = findViewById(R.id.btnLogin);
        mEtEmail = findViewById(R.id.etLogin);
        mEtPassword = findViewById(R.id.etPassword);
        mSharedPreferences = getSharedPreferences("LoginPref", Context.MODE_PRIVATE);
    }

    private void setListener() {
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnLogin:
               if (validate()){
                  requestDetails();
               }
                break;
        }
    }

    private void requestDetails() {
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Attempting login...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
        JSONObject loginDetail = new JSONObject();
        try {
            loginDetail.put("email",mEtEmail.getText().toString().trim());
            loginDetail.put("password",mEtPassword.getText().toString().trim());


        } catch (JSONException e) {
            e.printStackTrace();
        }

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, loginDetail.toString());
        Call<Example> call = App.getApiService().requestUserDetails(body);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                pDialog.dismiss();
              if (response.isSuccessful()){
                  Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                  Data data = response.body().getData();
                  User user = data.getUser();
                  Company company = user.getCompany();

                   mSharedPreferences.edit().putString("token",data.getToken()).apply();
                   mSharedPreferences.edit().putInt("companyId",company.getId());
                  startActivity(new Intent(MainActivity.this, MachineActivity.class));
                  finish();

              }else {
                  ErrorHandling.isnotSuccessful(response.code(),response.message(),getApplicationContext());
              }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                pDialog.dismiss();
                ErrorHandling.serverError(t.getMessage(), MainActivity.this);
            }
        });

    }

    private boolean validate() {
        if (mEtEmail.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mEtPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
