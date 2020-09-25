package storage;

import common.Messages;
import data.duke.Deadline;
import data.duke.Event;
import data.duke.Task;
import data.duke.Todo;
import ui.TextUi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static final String DEFAULT_STORAGE_DIRECTORY = "data";
    private static final String DEFAULT_STORAGE_FILEPATH = "data/duke.txt";
    private static final String SPLITTER = "|";
    private static final String TICK_NUM = "1";
    private static final String TEXTFILE_REGEX = "\\|";

    public static void writeToFile(ArrayList<Task> list) {
        try {
            FileWriter fw = new FileWriter(DEFAULT_STORAGE_FILEPATH);
            for (Task t : list) {
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
            TextUi.showToUser(Messages.MESSAGE_WRITE_EXCEPTION + e.getMessage());
        }
    }

    public static int importFileContents(ArrayList<Task> list) {
        int num = 0;
        try {
            File d = new File(DEFAULT_STORAGE_DIRECTORY);
            if (d.mkdir()) {
                TextUi.showToUser(Messages.MESSAGE_DIRECTORY_CREATED);
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
                    list.add(new Todo(description));
                    break;
                case Deadline.TYPE_WORD:
                    String by = words[3];
                    list.add(new Deadline(description, by));
                    break;
                case Event.TYPE_WORD:
                    String at = words[3];
                    list.add(new Event(description, at));
                    break;
                default:
                    break;
                }
                if (status.equals(TICK_NUM)) {
                    list.get(num).putTick();
                }
                num++;
            }
        } catch (IOException e) {
            TextUi.showToUser(Messages.MESSAGE_FILE_NOT_CREATED);
        }
        return num;
    }
}
