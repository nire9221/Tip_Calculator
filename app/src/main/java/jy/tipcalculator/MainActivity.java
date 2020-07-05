package jy.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;


public class MainActivity extends Activity implements View.OnClickListener {

    private EditText billamount;
    private SeekBar seeBar;
    private TextView seekbarResult;
    private Button calButton;
    private TextView tipResult;
    private TextView totalBilll;

    private int seekbarpercentage;
    private float enterbillfloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billamount = (EditText) findViewById(R.id.billamountEdit);
        seeBar = (SeekBar) findViewById(R.id.seekBar);
        seekbarResult= (TextView) findViewById(R.id.percentResult);
        calButton = (Button) findViewById(R.id.apply);

        tipResult = (TextView) findViewById(R.id.tipResult);
        totalBilll = (TextView) findViewById(R.id.getTotal);

        seekbarResult.setText(seeBar.getProgress() + "%");
        //----------------------------
        calButton.setOnClickListener(this);
        //-----------------------------
        seeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekbarResult.setText(seeBar.getProgress() + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarpercentage = seeBar.getProgress();
                //Toast.makeText(getApplicationContext(), "STOP", Toast.LENGTH_LONG).show();
            }

        });
    }


    //find the error
    @Override
    public void onClick(View v) {
        float result = 0.0f;
        if (!billamount.getText().toString().equals("")) {
            enterbillfloat = Float.parseFloat(billamount.getText().toString());
            result = (enterbillfloat * seekbarpercentage / 100);
            DecimalFormat df = new DecimalFormat("0.00");
            df.format(result);
            tipResult.setText("$"+ result);
            totalBilll.setText("$" + (enterbillfloat + result));
        } else {
            Toast.makeText(getApplicationContext(), "PLEASE ENTER AMOUNT", Toast.LENGTH_LONG).show();
        }
    }
}
