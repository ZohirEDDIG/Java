package model;

public class WorkTask extends Task {
    private String project;

    public WorkTask(int id, String title, TaskPriority priority, String project) {
        super(id, title, priority);
        this.project = project;
    }

    public String getProject() {
        return this.project;
    }

    @Override 
    public String displayInfo() {
        return "[Work] (" + this.id + ") " + this.title + " | Priority: " + this.priority + " | Status: " + this.status + " | Project: " + project;
    }

    public String toDataString() {
        return super.toDataString("WORK", project);
    }
}