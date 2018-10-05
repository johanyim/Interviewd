package Interviewd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button[] actionButtons = new Button[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupAll();
        UpdateAll();
    }


    //============================================================================================== Methods

    public void startRecording(){

    }


    //============================================================================================== Setup

    private void setupAll(){
        setupActionButtons();
        setupRecordingButton();
    }

    private void setupActionButtons(){
        actionButtons[0] = findViewById(R.id.homeButton);
        actionButtons[1] = findViewById(R.id.scriptButton);
        actionButtons[2] = findViewById(R.id.moreButton);
        actionButtons[3] = findViewById(R.id.settingsButton);


    }

    private void setupRecordingButton(){
        final Button recButton = findViewById(R.id.recordButton);
        recButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Interviewd", "Now recording");
                for(Button button : actionButtons){
                    button.setVisibility(View.INVISIBLE);
                }

                recButton.setText("Now Recording");

            }
        });
    }

    //============================================================================================== Update

    private void UpdateAll(){

    }





}
