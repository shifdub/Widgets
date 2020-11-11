package edu.cnm.deepdive.widgets.controller;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.widgets.R;
import edu.cnm.deepdive.widgets.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.input1.addTextChangedListener(this);
        binding.input2.addTextChangedListener(this);
    }

    private void computeAndDisplaySum() {
        double value1;
        String input1 = binding.input1.getText().toString().trim();
        if (input1.isEmpty()) {
            binding.input1.setText("0");
            value1 = 0;
        } else {
            value1 = Double.parseDouble(input1);
        }
        double value2;
        String input2 = binding.input2.getText().toString().trim();
        if (input2.isEmpty()) {
            binding.input2.setText("0");
            value2 = 0;
        } else {
            value2 = Double.parseDouble(input2);
        }
        double sum = value1 + value2;
        binding.output.setText(getString(R.string.sum_resource, sum));
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        computeAndDisplaySum();
    }
}