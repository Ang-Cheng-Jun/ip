package storage;

import common.Messages;
import data.TaskList;
import data.duke.Deadline;
import data.duke.Event;
import data.duke.Task;
import data.duke.Todo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import static ui.TextUi.showToUser;

/**
 * Storage: Create directory and txt.file (if don't exist).
 * And import and export of data to txt.file of the application.
 */
public class Storage {

    private static final String DEFAULT_STORAGE_DIRECTORY = "data";
    private static final String DEFAULT_STORAGE_FILEPATH = "data/duke.txt";
    private static final String SPLITTER = "|";
    private static final String TICK_NUM = "1";
    private static final String TEXTFILE_REGEX = "\\|";
    private final TaskList tasks;

    public Storage (TaskList tasks) {
        this.tasks = tasks;
    }

    /**
     * Clear the txt.file and export all the tasks in TaskList to the txt.file
     * upon the end of every command of the application.
     */
    public void writeToFile() {
        try {
            FileWriter fw = new FileWriter(DEFAULT_STORAGE_FILEPATH);
            for (Task t : tasks.getAllTasks()) {
                switch (t.getCategory()) {
                case Todo.TYPE_WORD:
                    fw.write(t.getCategory()
                             + SPLITTER
                             + t.getIsDone()
                             + SPLITTER
                             + t.getDescription()
                             + System.lineSeparator());
                    break;
                case Deadline.TYPE_WORD:
                    fw.write(t.getCategory()
                             + SPLITTER
                             + t.getIsDone()
                             + SPLITTER
                             + t.getDescription()
                             + SPLITTER
                             + t.getBy()
                             + System.lineSeparator());
                    break;
                case Event.TYPE_WORD:
                    fw.write(t.getCategory()
                             + SPLITTER
                             + t.getIsDone()
                             + SPLITTER
                             + t.getDescription()
                             + SPLITTER
                             + t.getAt()
                             + System.lineSeparator());
                    break;
                default:
                    break;
                }
            }
            fw.close();
        } catch (IOException e) {
            showToUser(Messages.MESSAGE_WRITE_EXCEPTION + e.getMessage());
        }
    }

    /**
     * Upon the start of the application, create directory and txt.file (if don't exist).
     * And import all the tasks to TaskList from the txt.file.
     */
    public void importFileContents() {
        try {
            File d = new File(DEFAULT_STORAGE_DIRECTORY);
            if (d.mkdir()) {
                showToUser(Messages.MESSAGE_DIRECTORY_CREATED);
            }
            File f = new File(DEFAULT_STORAGE_FILEPATH);
            Scanner s = new Scanner(f);
            if (f.createNewFile()) {
                throw new IOException();
            }
            while (s.hasNext()) {
                String[] words = s.nextLine().split(TEXTFILE_REGEX);
                String type = words[0];
                String status = words[1];
                String description = words[2];

                switch (type) {
                case Todo.TYPE_WORD:
                    tasks.addTask(new Todo(description));
                    break;
                case Deadline.TYPE_WORD:
                    String by = words[3];
                    tasks.addTask(new Deadline(description, by));
                    break;
                case Event.TYPE_WORD:
                    String at = words[3];
                    tasks.addTask(new Event(description, at));
                    break;
                default:
                    break;
                }
                if (status.equals(TICK_NUM)) {
                    tasks.getTask(tasks.getListSize() - 1).putTick();
                }
            }
        } catch (IOException e) {
            showToUser(Messages.MESSAGE_FILE_NOT_CREATED);
        }
    }

}
