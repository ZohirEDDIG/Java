package model;

public enum BookGenre {
    FICTION,
    NON_FICTION;

    @Override
    public String toString() {
        String s =  name().toLowerCase();
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}