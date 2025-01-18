package desktop.controller;

import desktop.model.Task;
import desktop.model.TaskManager;
import desktop.view.StartButtonWindow;
import java.util.ArrayList;
import java.util.List;

public class TaskController {
    private List<Task> tasks;
    private TaskManager taskManager;
    private StartButtonWindow startButtonWindow;

    public TaskController(StartButtonWindow startButtonWindow) {
        this.startButtonWindow = startButtonWindow;
        this.taskManager = new TaskManager();
    }

    public void addTask(String title, String description) {
        Task task = new Task(title, description);
        taskManager.addTask(task);
        startButtonWindow.refreshTaskList();
    }
    public List<Task> getTasks() {
        return tasks;
    }
    public void initializeTasks() {
        tasks.add(new Task("Task 1", "Description 1"));
        tasks.add(new Task("Task 2", "Description 2"));
    }
}