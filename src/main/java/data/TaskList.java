package data;

import data.duke.Task;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> allTask;

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

    public ArrayList<Task> getAllTasks() {
        return allTask;
    }

    public int getListSize() {
        return allTask.size();
    }
}
