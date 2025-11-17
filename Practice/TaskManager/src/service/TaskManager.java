package service;

import java.io.IOException;

import java.util.List;

import model.Task;

public interface TaskManager {
    void addTask(Task task);
    List<Task> listTasks();
    Task findTaskById(int id);
    boolean markTaskDone(int id);
    void saveToFile(String filename) throws IOException;
    void loadFromFile(String filename) throws IOException;
}