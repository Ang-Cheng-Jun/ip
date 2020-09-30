package data;

import data.duke.Task;
import java.util.ArrayList;

/**
 * Represents the entire TaskList. Contains the data of the TaskList.
 */
public class TaskList {

    private ArrayList<Task> taskList;

    /**
     * Creates an empty TaskList.
     */
    public TaskList() {
        taskList = new ArrayList<>();
    }

    /**
     * Add a task to the TaskList.
     */
    public void addTask(Task task) {
        taskList.add(task);
    }

    /**
     * Removes the task from the TaskList.
     */
    public void removeTask(int index) {
        taskList.remove(index);
    }

    /**
     * Returns the relevant task at the time of the call.
     */
    public Task getTask(int index) {
        return taskList.get(index);
    }

    /**
     * Returns the TaskList at the time of the call.
     */
    public ArrayList<Task> getAllTasks() {
        return taskList;
    }

    /**
     * Returns the size of TaskList at the time of the call.
     */
    public int getListSize() {
        return taskList.size();
    }

}
