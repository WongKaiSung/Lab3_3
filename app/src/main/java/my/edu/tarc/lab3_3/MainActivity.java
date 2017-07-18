package my.edu.tarc.lab3_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Spinner spinnerAge;
    private TextView textViewPremium;
    private RadioGroup radioGroupGender;
    private CheckBox CheckBoxSmoker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        textViewPremium = (TextView) findViewById(R.id.textViewPremium);
        radioGroupGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        CheckBoxSmoker = (CheckBox) findViewById(R.id.CheckBoxSmoker);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAge.setAdapter(adapter);
        //spinnerAge.setOnItemClickListener(this);
    }
        public void calculatePremium(View v){
        double premium = 0;
            int smoker;
            boolean check;
            boolean male;
        int gender = radioGroupGender.getCheckedRadioButtonId();
            int age = spinnerAge.getSelectedItemPosition();

            if (gender == R.id.radioButtonMale){
                male = true;
            }
            if(CheckBoxSmoker.isChecked() == true){
                check = true;
            }
            if (age == 0){
                premium = 50;
            }else if(age == 1){
                premium = 55;
            }else if(age == 2){
                premium = 60;
                if (male = true){
                    premium += 50;
                }
            }else if(age == 3){
                premium = 70;
                if (male = true){
                    premium += 100;
                }
                if (check = true){
                    premium += 100;
                }
            }else if(age == 4){
                premium = 120;
                if (male = true){
                    premium += 100;
                }
                if (check = true){
                    premium += 150;
                }
            }else if(age == 5){
                premium = 160;
                if (male = true){
                    premium += 50;
                }
                if (check = true){
                    premium += 150;
                }
            }else if(age == 6){
                premium = 200;
                if (check = true){
                    premium += 150;
                }
            }else if(age == 7){
                premium = 250;
                if (check = true){
                    premium += 150;
                }

            }
            textViewPremium.setText("Total Premium = " + String.format("%.2f",premium));
    }
    public void reset(View v){
        spinnerAge.setSelection(0);
        textViewPremium.setText("");
        radioGroupGender.clearCheck();
        CheckBoxSmoker.setChecked(false);
    }

}
