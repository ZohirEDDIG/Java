package model;

public enum TaskPriority {
    LOW,
    MEDIUM,
    HIGH;

    public static TaskPriority fromString(String input) {
        if (input == null) return LOW;
        try {
            return TaskPriority.valueOf(input.trim().toUpperCase());
        } catch (Exception e) {
            return LOW;
        }
    }

    @Override
    public String toString() {
        String s = name().toLowerCase();
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}