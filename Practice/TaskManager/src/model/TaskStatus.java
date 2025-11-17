package model;

public enum TaskStatus {
    PENDING,
    DONE;

    public static TaskStatus fromString(String input) {
        if (input == null) return PENDING;
        try {
            return TaskStatus.valueOf(input.trim().toUpperCase());
        } catch (Exception e) {
            return PENDING;
        }
    }

    @Override
    public String toString() {
        String s = name().toUpperCase();
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}