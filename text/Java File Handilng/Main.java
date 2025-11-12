import java.io.File;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;

public class Main {
    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String fileName, String content) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            // FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(content);
            // fileWriter.close();
            System.out.println("Successfully wrote the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readFile(String filename) {
        File file = new File(filename);
        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public static void deleteFile(String filename) {
        File file = new File(filename);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void deleteEmptyFolder(String absolutePath) {
        File file = new File(absolutePath);
        if (file.delete()) {
            System.out.println("Deleted the folder: " + file.getName());
        } else {
            System.out.println("Failed to delete the folder.");
        }
    }

    public static void main(String[] args) {
        // createFile("text.txt");
        // createFile("/home/zohir-eddig/Documents/Dev/Courses/Java/text/Java File Handilng/text-files/text.txt");

        // writeToFile("text.txt", "Hello I am zohir!") ;
        // writeToFile("text.txt", "\nI am learning Java!") ;
        // writeToFile("text-two.txt", "Hello I am zohir!");
        // writeToFile("/home/zohir-eddig/Documents/Dev/Courses/Java/text/Java File Handilng/text-files/text.txt", "Hello I am zohir!");

        // readFile("text.txt");
        // readFile("text-two.txt");
        // readFile("/home/zohir-eddig/Documents/Dev/Courses/Java/text/Java File Handilng/text-files/text.txt");

        // deleteFile("text.txt");
        // deleteFile("text-two.txt");
        // deleteFile("/home/zohir-eddig/Documents/Dev/Courses/Java/text/Java File Handilng/text-files/text.txt");

        // deleteEmptyFolder("/home/zohir-eddig/Documents/Dev/Courses/Java/text/Java File Handilng/text-files");
    }
}