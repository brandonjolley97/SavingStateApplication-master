package ctec.savingstateapplication.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import ctec.savingstateapplication.model.AndroidSaveState;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;


public class FrontActivity extends Activity
{
    private Button sendToOtherScreenButton;
    private EditText nameText;
    private EditText ageText;
    private CheckBox tiredBox;

    private AndroidSaveState saveState;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        saveState = (AndroidSaveState) getApplication();

        sendToOtherScreenButton = (Button) findViewById(R.id.submitButton);
        nameText = (EditText) findViewById(R.id.nameText);
        ageText = (EditText) findViewById(R.id.ageText);
        tiredBox = (CheckBox) findViewById(R.id.isTiredBox);

        setupListeners();
    }

    private void setupListeners()
    {
        sendToOtherScreenButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View clickView)
            {
                //Grab user input
                String name = nameText.getText().toString();
                int age = Integer.parseInt(ageText.getText().toString());
                boolean tired = tiredBox.isChecked();

                //Save user input to the saveState
                saveState.setAge(age);
                saveState.setUserName(name);
                saveState.setIsTired(tired);

                //Clear fields
                nameText.setText("");
                ageText.setText("");
                tiredBox.setChecked(false);

                //Open new Screen
                Intent newScreenIntent = new Intent(clickView.getContext(), BackPage.class);
                startActivityForResult(newScreenIntent, 0);

            }
        });
    }

}
