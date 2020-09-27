package data;

import data.duke.Task;

import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(int index) {
        taskList.remove(index);
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }
    public ArrayList<Task> getAllTasks() {
        return taskList;
    }

    public int getListSize() {
        return taskList.size();
    }

}
