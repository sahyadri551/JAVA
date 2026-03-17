package com.fileHandling;
import java.io.*;
public class J030ReadFile {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("output.txt")){
            System.out.println(reader.readAllLines());
        }catch(FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
