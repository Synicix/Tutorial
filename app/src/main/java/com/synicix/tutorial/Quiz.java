package com.synicix.tutorial;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Quiz extends ActionBarActivity {

    ArrayList<String> questions, answers, hints;
    ArrayList hintPics;
    TextView questionNum, questionTextView, hintText;
    ImageView hintImage;
    Button next, hint, submit;
    EditText answerEditText;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getSupportActionBar().hide();


        defineWidgets();
        setOnClickListeners();
        setQuestions();
        setAnswers();
        setHints();
        setHintsPics();

        questionTextView.setText(questions.get(0));
        index = 0;
    }

    public void defineWidgets()
    {
        questionNum = (TextView) findViewById(R.id.questionNumberTextView);
        questionTextView = (TextView) findViewById(R.id.questionTextView);

        next = (Button) findViewById(R.id.nextButton);
        hint = (Button) findViewById(R.id.hintButton);
        submit = (Button) findViewById(R.id.submitButton);

        answerEditText = (EditText) findViewById(R.id.answerEditText);

        questions = new ArrayList<String>();
        answers = new ArrayList<String>();
        hints = new ArrayList<String>();
        hintPics = new ArrayList();
    }

    public void setOnClickListeners()
    {
        next.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                if(index == questions.size() - 1)
                {
                    index = 0;
                    questionNum.setText("Question " + (index + 1));
                    questionTextView.setText(questions.get(index));

                }
                else
                {
                    index++;
                    questionNum.setText("Question " + (index + 1));
                    questionTextView.setText(questions.get(index));
                }


            }
        });

        hint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                Toast.makeText(getApplicationContext(), hints.get(index),Toast.LENGTH_LONG).show();

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                if(answerEditText.getText().toString().equals(answers.get(index)))
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

    }

    public void setQuestions()
    {
        questions.add("Who is considered to be the founder of psychology?");
        questions.add("What year was psychology first established? ");
        questions.add("Where was psychology founded? (City, Country))");
        questions.add("What psychological perspective focuses on the structural of elements?");
        questions.add("What psychological perspective focuses on functions of elements?)");
        questions.add("What psychological perspective focuses on observable behavior?)");
        questions.add("What psychological perspective sees human as unique?");
        questions.add("Sigmund Freud is most associated with what perspective of psychology?");
        questions.add("B.F. Skinner is most associated with what perspective of psychology?");
        questions.add("John B. Watson is the founder of what psychology perspective?");
    }

    public void setAnswers()
    {
        answers.add("Wilhelm Wundt");
        answers.add("1879");
        answers.add("Leipzig, Germany");
        answers.add("Structuralism");
        answers.add("Functionalism");
        answers.add("Behaviorism");
        answers.add("Humanism");
        answers.add("Behaviorism");
        answers.add("Psychodynamic");
        answers.add("Behaviorism");

    }

    public void setHints()
    {
        hints.add("His initials is W.W.");
        hints.add("The year is 18xx");
        hints.add("It is located in Europe");
        hints.add("\"Structural\"");
        hints.add("\"Functions\"");
        hints.add("\"Observable Behavior\"");
        hints.add("\"Human\"");
        hints.add("Freud created psychoanalysis");
        hints.add("B.F. Skinner focused heavily on subjects' behaviors");
        hints.add("B.F. Skinner also advocate this perspective");
    }

    public void setHintsPics()
    {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
