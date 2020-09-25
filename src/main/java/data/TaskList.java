package data;

import data.duke.Task;

import java.util.ArrayList;

public class TaskList {

    private static ArrayList<Task> allTask;

    public TaskList() {
        allTask = new ArrayList<>();
    }

    public void addTask(Task task) {
        allTask.add(task);
    }

    public void removeTask(int index) {
        allTask.remove(index);
    }

    public Task getTask(int index) {
        return allTask.get(index);
    }

    public ArrayList<Task> getAllTask() {
        return allTask;
    }
}
