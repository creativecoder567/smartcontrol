package com.smart.myapplication.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.smart.myapplication.App;
import com.smart.myapplication.R;
import com.smart.myapplication.adapter.MachinesListAdapter;
import com.smart.myapplication.model.machinedetail.Asset;
import com.smart.myapplication.model.machinedetail.Example;
import com.smart.myapplication.utils.ErrorHandling;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MachineActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MachinesListAdapter mMachineListAdapter;
    private SharedPreferences mSharedPreferences;
    private List<Asset> assets = new ArrayList<>();
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine);
        bindViews();



    }

    private void bindViews() {
        mRecyclerView = findViewById(R.id.rv_machineList);
        mSharedPreferences = getSharedPreferences("LoginPref", Context.MODE_PRIVATE);
        addDataInRecylerView();

    }

    private void addDataInRecylerView() {
        pDialog = new ProgressDialog(MachineActivity.this);
        pDialog.setMessage("Attempting login...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();

        String token = mSharedPreferences.getString("token","");

        Call<Example> call = App.getApiService().requestMachineDetails( "Bearer "+token,"1","50","2");
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                pDialog.dismiss();
                if (response.isSuccessful()){
                    assets.clear();
                     assets.addAll(response.body().getData().getAssets());
                    Log.d("sarath", "onResponse: "+assets.size());
                    setUpRecylerView();
                }else {
                    ErrorHandling.isnotSuccessful(response.code(),response.message(),getApplicationContext());
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                pDialog.dismiss();
                ErrorHandling.serverError(t.getMessage(), MachineActivity.this);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void setUpRecylerView() {
        mMachineListAdapter= new MachinesListAdapter(MachineActivity.this,assets);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MachineActivity.this));
        mRecyclerView.setAdapter(mMachineListAdapter);
        mMachineListAdapter.notifyDataSetChanged();
    }
}
