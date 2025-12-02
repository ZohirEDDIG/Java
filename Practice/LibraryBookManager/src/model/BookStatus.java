package model;

public enum BookStatus {
    AVAILABLE,
    NOT_AVAILABLE;

    @Override
    public String toString() {
        String s =  name().toLowerCase();
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}