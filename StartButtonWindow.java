package desktop.view;

import desktop.controller.TaskController;
import desktop.model.Task;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StartButtonWindow extends JFrame {
    private TaskController taskController;
    private DefaultListModel<String> taskListModel;

    public StartButtonWindow() {
        taskListModel = new DefaultListModel<>();
        taskController = new TaskController(this);
        setTitle("Daily Task Book");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> showTaskSelectionWindow());

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(startButton, gbc);

        add(panel);
        setVisible(true);
    }

    private void showTaskSelectionWindow() {
        JFrame selectTask = new JFrame("Select Task");
        selectTask.setSize(800, 600);
        selectTask.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        selectTask.setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 8));
        JButton addPersonalTasks = new JButton("Добавить свои задачи");
        JButton currentTasks = new JButton("Текущие задачи");
        JButton addSharedTasks = new JButton("Добавить совместные задачи");
        JButton sharedTasks = new JButton("Совместные задачи");

        buttonPanel.add(addPersonalTasks);
        buttonPanel.add(currentTasks);
        buttonPanel.add(addSharedTasks);
        buttonPanel.add(sharedTasks);

        currentTasks.addActionListener(e -> showCurrentTasks());

        addSharedTasks.addActionListener(e -> {
            String title = JOptionPane.showInputDialog("Введите заголовок задачи");
            String description = JOptionPane.showInputDialog("Введите описание задачи");
            if (title != null && description != null) {
                taskController.addTask(title, description);
            }
        });

        addPersonalTasks.addActionListener(e -> {
            String title = JOptionPane.showInputDialog("Введите заголовок задачи");
            String description = JOptionPane.showInputDialog("Введите описание задачи");
            if (title != null && description != null) {
                taskController.addTask(title, description);
            }
        });

        selectTask.add(buttonPanel);
        selectTask.setVisible(true);
    }

    public void refreshTaskList() {
        List<Task> tasks = taskController.getTasks(); // Получаем задачи
        taskListModel.clear();
        for (Task task : tasks) {
            taskListModel.addElement(task.getTitle() + ": " + task.getDescription());
        }
    }

    private void showCurrentTasks() {
        JFrame tasksFrame = new JFrame("Текущие задачи");
        tasksFrame.setSize(700, 500);
        tasksFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tasksFrame.setLocationRelativeTo(null);

        JList<String> taskList = new JList<>(taskListModel);
        tasksFrame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        tasksFrame.setVisible(true);
    }
}