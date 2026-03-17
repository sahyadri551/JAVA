package com.fileHandling;
import java.io.*;
public class J029WriteFile {
    static void main() {
        try(FileWriter writer = new FileWriter("output.txt")){
            writer.write("Hello, this is a test file.");
            writer.write(5);
            char[] arr ={ 'A', 'B', 'C', 'D', 'E' };
            writer.write(arr);
            writer.flush();
            writer.append("This is appended text.");
            writer.getEncoding();
            writer.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
