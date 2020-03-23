package com.mbnepal.numberformat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button btn;
    String originalString = "";

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
                DecimalFormatSymbols unusualSymbols =
                        new DecimalFormatSymbols(Locale.getDefault());
                unusualSymbols.setDecimalSeparator(',');
                unusualSymbols.setGroupingSeparator('.');

                String currFormat = "#,###,##0.000";

                DecimalFormat df = new DecimalFormat(currFormat,unusualSymbols);
                textView.setText( df.format(Double.parseDouble((editText.getText().toString().trim()))));
            }
        });
        editText.addTextChangedListener(onTextChangedListener());
    }
        public TextWatcher onTextChangedListener(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                editText.removeTextChangedListener(this);

                String s1 = s.toString().trim();
                int index = s1.indexOf("\\,");
                if(s1.endsWith("000"))
                    s1 = s1.substring(0,index);
                Toast.makeText(MainActivity.this, s1, Toast.LENGTH_SHORT).show();
                try{
                    if(s1.contains(".")) {
                        s1 = s1.replaceAll("\\.", "");
                    }

                    if(s1.contains(",")) {
                        s1 = s1.replaceAll("\\,", "");
                    }
                    DecimalFormatSymbols unusualSymbols =
                            new DecimalFormatSymbols(Locale.getDefault());
                    unusualSymbols.setDecimalSeparator(',');
                    unusualSymbols.setGroupingSeparator('.');

                    String currFormat = "#,###,##0.000";

                    DecimalFormat df = new DecimalFormat(currFormat, unusualSymbols);
                    String formatttedData = df.format(Double.parseDouble(s1));
                   
                    editText.setText(formatttedData);
                    editText.setSelection(editText.getText().length());

                }catch(Exception e) {
                    e.printStackTrace();
                }

                editText.addTextChangedListener(this);

            }

        };
    }
}
