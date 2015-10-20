package ctec.savingstateapplication.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import ctec.savingstateapplication.model.AndroidSaveState;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

public class BackPage extends AppCompatActivity
{

    private AndroidSaveState saveState;
    private Button backButton;
    private TextView userText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_page);

        saveState = (AndroidSaveState) getApplication();
        backButton = (Button) findViewById(R.id.backButton);
        userText = (TextView) findViewById(R.id.backPageText);

        loadContent();

        setupListeners();

    }

    private void loadContent()
    {
        userText.setText(saveState.getUserName() + " is " + saveState.getAge() + " years old and their status is " + saveState.getIsTired());
    }

    private void setupListeners()
    {
        backButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View clickView)
            {
                Intent returnIntent = new Intent();
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}



















