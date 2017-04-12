package s3.udacityquiz;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int point = 0;


    public void onRadioButtonClickedTwoChoices(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {

            case R.id.NissanRb_buttonid:
                if (checked)
                    point++;
                break;

            case R.id.toyotaJz_buttonid:
                if (checked) {
                    if (point > 0) {
                        point--;
                        break;
                    }
                }
        }
    }


    public void onRadioButtonClickedFourChoices(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {

            case R.id.RPM9500_buttonid:
                if (checked)
                    point++;
                break;

            case (R.id.RPM9000_buttonid):
                if (checked) {
                    if (point > 0) {
                        point--;
                        break;
                    }
                }
            case (R.id.RPM8500_buttonid):
                if (checked) {
                    if (point > 0) {
                        point--;
                        break;
                    }
                }
            case (R.id.RPM8000_buttonid):
                if (checked) {
                    if (point > 0) {
                        point--;
                        break;
                    }
                }
        }
    }

    public void onCheckboxClickedSix(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {

            case R.id.toyotaCheckBox:
                if (checked)
                    point++;
                break;

            case (R.id.NissanCheckBox):
                if (checked)
                    point++;
                break;

        }
    }


    public void finishQuiz(View view) {
        String answer = "wankel";

        TextView answerView = (TextView) findViewById(R.id.textAnswer);

        String answerValue = answerView.getText().toString().trim().toLowerCase();



         if (answer.equalsIgnoreCase(answerValue)){
            point++;
        }


        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Your score is :");
        alertDialog.setMessage("" + point + " of 5");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "RESET",

                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        point = (0);

                        setContentView(R.layout.activity_main);
                    }
                });
        alertDialog.show();
    }
}