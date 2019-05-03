package sg.edu.rp.c346.billplease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView totalAmount;
    TextView aveAmount;

    Button btnSplit;
    Button btnReset;

    ToggleButton tbtnService;
    ToggleButton tbtnGst;

    EditText etInput2;
    EditText etInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalAmount= findViewById(R.id.total);
        aveAmount = findViewById(R.id.textView6);

        btnReset = findViewById(R.id.reset);
        btnSplit = findViewById(R.id.split);

        tbtnGst = findViewById(R.id.gst);
        tbtnService = findViewById(R.id.service);

        etInput = findViewById(R.id.InputAmount);
        etInput2 = findViewById(R.id.numberPax);


        btnSplit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                double amount = Double.parseDouble(etInput.getText().toString());
                int pax = Integer.parseInt(etInput2.getText().toString());
                if (tbtnService.isChecked()) {
                    amount = amount * 1.1;
                }
                if (tbtnGst.isChecked()) {
                    amount = amount * 1.07;
                }
                double ave = amount / pax;
                totalAmount.setText("Total is " + amount);
                aveAmount.setText("Each Pax pay " + ave);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                etInput.setText("");
                etInput2.setText("");
                totalAmount.setText("");
                tbtnGst.setChecked(false);
                tbtnService.setChecked(false);
            }
        });

    }
}
