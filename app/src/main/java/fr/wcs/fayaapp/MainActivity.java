package fr.wcs.fayaapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button validate;
    EditText firstname, name;
    TextView congrats;
    CheckBox checkBox;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validate = (Button) findViewById(R.id.validate);
        firstname = (EditText) findViewById(R.id.firstname);
        name = (EditText) findViewById(R.id.name);
        congrats = (TextView) findViewById(R.id.congrats);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        congrats.setVisibility(View.INVISIBLE);
        name.setEnabled(false);
        firstname.setEnabled(false);

       checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked) {
                   name.setEnabled(true);
                   firstname.setEnabled(true);
               }

               else{
                   name.setEnabled(false);
                   firstname.setEnabled(false);
               }
           }
       });


        validate.setOnClickListener(new View.OnClickListener() {
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.error);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);


            @Override
            public void onClick(View view) {
                if (name.length()  > 0 && firstname.length() > 0){
                    congrats.setVisibility(View.VISIBLE);
                }

             else {
                    toast.show();
                }
            }



        });


    }













}


