package com.example.texteditandhashmap.screens.mainScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.texteditandhashmap.R;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCity;
    private EditText editTextCapital;
    private EditText editTextCityToGetCapital;
    private TextView textViewCapital;
    private TextView textViewAllData;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(MainViewModel.class);

        editTextCity = findViewById(R.id.editTextCity);
        editTextCapital = findViewById(R.id.editTextCapital);
        editTextCityToGetCapital = findViewById(R.id.editTextCityToGetCapital);
        textViewCapital = findViewById(R.id.textViewCapital);
        textViewAllData = findViewById(R.id.textViewAllData);

        editTextCityToGetCapital.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String caption = viewModel.findCapitalByCity(s.toString());
                if(caption!=null)
                    textViewCapital.setText(caption);
            }
        });
    }

    public void onClickAddButtonPressed(View view) {
        if(!editTextCity.getText().toString().equals("") && !editTextCapital.getText().toString().equals("")){
            viewModel.addCountry(editTextCity.getText().toString(),editTextCapital.getText().toString());
            textViewAllData.setText(viewModel.fromMapToString(viewModel.getCountries()));
            editTextCity.setText(null);
            editTextCapital.setText(null);
            editTextCity.requestFocus();
        }
        else {
            Toast.makeText(this, "ЗАполните поле страны и сталицы", Toast.LENGTH_SHORT).show();
        }

    }
}