package com.ualr.simpletasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.ualr.simpletasklist.databinding.ActivityMainBinding;
import com.ualr.simpletasklist.model.TaskList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    TaskList myTasks = new TaskList();

    EditText textInput;
    TextView taskList;
    EditText idInput;

    // TODO 05. Add a TaskList member to the MainActivity. Initialize the new member.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //TODO 06.02 Bind the onAddBtnClicked method to the add button, so the onAddBtnClicked is
        // triggered whenever the user clicks on that button

        textInput = (EditText) findViewById(R.id.editTextTextPersonName);
        taskList = (TextView) findViewById(R.id.taskList);
        idInput = (EditText) findViewById(R.id.editTextTaskId);

        ImageView addButton = (ImageView) findViewById(R.id.add_btn);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onAddBtnClicked(v);
            }
        });
        //TODO 07.02 Bind the onDeleteBtnClicked method to the delete button, so that method is
        // triggered whenever the user clicks on that button
        MaterialButton deleteButton = (MaterialButton) findViewById(R.id.deleteBtn);
        deleteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                onDeleteBtnClicked(v);
            }
        });

        //TODO 08.02 Bind the onDoneBtnClicked method to the done button, so the onDoneBtnClicked method is
        // triggered whenever the user clicks on that button
        MaterialButton doneButton = (MaterialButton) findViewById(R.id.clearBtn);
        doneButton.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               onDoneBtnClicked(v);
           }
        });
    }

    // TODO 06. Create a new functionality to add a new task using the description provided
    //  through the text field on the top of the screen by tapping the "+" on the right

    // TODO 06.01. Create a new method called onAddBtnClicked.

    // TODO 06.05. Invoke TaskList class' add method to ask the TaskList to
    //  add a new Task with the description provided through the text field.

    // TODO 06.06. Use TaskList class' toString method to get a string with the formatted task list
    //  and display it on screen in the TextView with the id "textView"
    public void onAddBtnClicked(View view) {
        myTasks.add(textInput.getText().toString());
        taskList.setText(myTasks.toString());
        textInput.setText(" ");
    }

    // TODO 07. Create a new functionality to delete a task from the task list

    // TODO 07.01. Create a new method called onDeleteBtnClicked.

    // TODO 07.04. Invoke TaskList class' delete method to ask the TaskList to
    //  delete a Task given the id provided through the text field on the bottom.

    // TODO 07.05. Use TaskList class' toString method to get a string with the formatted task list
    //  and display it on screen in the TextView with the id "textView"
    public void onDeleteBtnClicked(View view) {
        myTasks.delete(idInput.getText().toString());
        taskList.setText(myTasks.toString());
        idInput.setText("");
    }

    // TODO 08. Create a new functionality to mark a task as done.

    // TODO 08.01. Create a new method called onDoneBtnClicked

    // TODO 08.04. Invoke TaskList class' markDone method to ask the TaskList to
    //  mark a Task given the id provided through the text field on the bottom.

    // TODO 08.05. Use TaskList class' toString method to get a string with the formatted task list
    //  and display it on screen in the TextView with the id "textView"
    public void onDoneBtnClicked(View view) {
        myTasks.markDone(idInput.getText().toString());
        taskList.setText(myTasks.toString());
        idInput.setText("");
    }
}