package model;

public abstract class Task {
    protected int id;
    protected String title;
    protected TaskPriority priority;
    protected TaskStatus status;

    public Task(int id, String title, TaskPriority taskPriority) {
        this.id = id;
        this.title = title;
        this.priority = taskPriority;
        this.status = TaskStatus.PENDING;
    }

    public int getId() {
        return this.id;
    }


    public void markDone() {
        this.status = TaskStatus.DONE;
    }

    public abstract String displayInfo();

    public String toDataString(String type, String extra) {
        return this.id + "|" + type + "|" +  this.title + "|" + priority.name() + "|" + status.name() + "|" + extra;
    }
}