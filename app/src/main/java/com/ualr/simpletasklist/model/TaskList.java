package com.ualr.simpletasklist.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TaskList {
    HashMap<Integer,Task> tasks = new HashMap<Integer,Task>();
    static int taskID=1;
    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    public void setTasks(HashMap<Integer, Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {

    }

    public void add(String description){
        Task newTask = new Task();
        newTask.setTaskDescription(description);
        tasks.put(taskID++,newTask);
    }

    public String toString(){
        String taskString = "";
        TreeMap<Integer,Task> sorted = new TreeMap<>();
        sorted.putAll(tasks);
        for (Map.Entry<Integer,Task>entry:sorted.entrySet()){

            String taskLine=entry.getKey() + "-" + entry.getValue().getTaskDescription();
            if (entry.getValue().isTaskDone())
                taskLine += "-Done";
            taskString+=taskLine+"\n";
        }

        return taskString;
    }

    public void delete(String taskID){
        if (isInteger(taskID)) {
            Integer intID = Integer.parseInt(taskID);
            tasks.remove(intID);
        }
    }

    public void markDone(String taskID) {
        if (isInteger(taskID)) {
            Integer intID = Integer.parseInt(taskID);
            if (tasks.containsKey(intID))
                tasks.get(intID).setTaskDone(true);
        }
    }

    public boolean isInteger(String input){
        try{
            Integer.parseInt(input);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    // TODO 03. Define TaskList's attributes. The class will have just one attribute to store all
    //  the tasks created by the user.

    // TIP. We need a data structure able to dynamically grow and shrink. That's why we'll use a HashMap.
    // where keys will be integer values and the mapped values will be a task object

    // TODO 04. Define the class constructor and the corresponding getters and setters.

    // TODO 06.03. Define a new method called "add" that, given a task description, will create a
    //  new task and add it to the task list.

    // TODO 06.04. Define a new "toString" method that provides a formatted string with all the tasks in the task list.
    // Format: 1 line per task. Each line should start with the id number of the task, then a dash, and the task description right after that.
    // If the task is marked as done, "Done" should be included at the end of the line

    // TODO 07.03. Define a new method called "delete" that, given a task id, will delete the
    //  corresponding task from the task list.

    // TODO 08.03. Define a new method called "markDone" that, given a task id, will mark the
    //  corresponding task as done.

}
