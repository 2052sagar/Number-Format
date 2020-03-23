package com.mbnepal.numberformat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num = Double.parseDouble(editText.getText().toString().trim());
                NumberFormat nf3 = NumberFormat.getInstance(new Locale("lo", "LA"));
                String val = nf3.format(num);
                textView.setText(val);
            }
        });
        //editText.addTextChangedListener(onTextChangedListener());
    }
    //    public TextWatcher onTextChangedListener(){
//        return new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                editText.removeTextChangedListener(this);
//                String str = s.toString().trim();
//                try{
//                    if(str.contains(".")) {
//                        str.replaceAll(".", "");
//                    }
//                    double num = Double.parseDouble(str);
//                    NumberFormat nf3 = NumberFormat.getInstance(new Locale("lo", "LA"));
//
//                    String val = nf3.format(num);
//                    editText.setText(val);
//                    editText.setSelection(editText.getText().length());
//                }catch(Exception e) {
//                    e.printStackTrace();
//                }
//
//                editText.addTextChangedListener(this);
//
//            }
//
//        };
//    }
}
