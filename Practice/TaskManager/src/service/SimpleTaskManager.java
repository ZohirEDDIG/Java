package service;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import model.Task;
import model.PersonalTask;
import model.WorkTask;
import model.TaskPriority;
import model.TaskStatus;

public class SimpleTaskManager implements TaskManager {
    private List<Task> tasks = new ArrayList<Task>();
    private int nextId = 1;

    @Override
    public void addTask(Task task) {
        tasks.add(task);
        nextId++;
    }

    @Override
    public List<Task> listTasks() {
        return tasks;
    }

    @Override
    public Task findTaskById(int id) {
        for (Task task: tasks) {
            if (task.getId() == id) {
                return task;
            }
        }

        return null;
    }

    @Override
    public boolean markTaskDone(int id) {
        Task task = findTaskById(id);
        if (task == null) return false;
        task.markDone();
        return true;
    }

    @Override
    public void saveToFile(String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter("data/" + fileName, true);
        for (Task task: tasks) {
            if (task instanceof WorkTask) {
                fileWriter.write(((WorkTask) task).toDataString());
            } else if (task instanceof PersonalTask) {
                fileWriter.write(((PersonalTask) task).toDataString());
            }

            fileWriter.write("\n");
        }

        fileWriter.close();
    }

    @Override
    public void loadFromFile(String fileName) throws IOException {
        tasks.clear();
        nextId = 1;

        File file = new File("data/" + fileName);
        if (!file.exists()) return;

        Scanner fileWreader = new Scanner(file);

        while (fileWreader.hasNextLine()) {
            String dataString = fileWreader.nextLine();
            String[] dataStringSplited = dataString.split("\\|");
            System.out.println(dataString.toString());

            int id = Integer.parseInt(dataStringSplited[0]);
            String type = dataStringSplited[1];
            String title = dataStringSplited[2];
            TaskPriority priority = TaskPriority.fromString(dataStringSplited[3]);
            TaskStatus status = TaskStatus.fromString(dataStringSplited[4]);
            String extra = dataStringSplited[5];

            Task t;

            if (type.equals("WORK")) {
                t = new WorkTask(id, title, priority, extra);
            } else {
                t = new PersonalTask(id, title, priority, extra);
            }

            if (status == TaskStatus.DONE) {
                t.markDone();
            }

            tasks.add(t);

            if (id >= nextId) nextId = id + 1;
        }

        fileWreader.close();
    }

    public int getNextId() {
        return nextId;
    }
}