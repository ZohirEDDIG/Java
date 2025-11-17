package model;

public class PersonalTask extends Task {
    private String note;
    
    public PersonalTask(int id, String title, TaskPriority priority, String note) {
        super(id, title, priority);
        this.note = note;
    }

    public String getNote() {
        return this.note;
    }

    @Override 
    public String displayInfo() {
        return "[Personal] (" + this.id + ") " + this.title + " | Priority: " + this.priority + " | Status: " + this.status + " | Project: " + this.note;
    }

    public String toDataString() {
        return super.toDataString("PERSONAL", note);
    }
}