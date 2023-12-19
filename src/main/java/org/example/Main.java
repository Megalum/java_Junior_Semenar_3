package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Student student = new Student("Вася", 12, 7.6);

        try (FileOutputStream fileOutputStream = new FileOutputStream("student.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(student);
            System.out.println("Сериализация успешна!!!");
        }

        try (FileInputStream fileInputStream = new FileInputStream("student.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            student = (Student)objectInputStream.readObject();
            System.out.println("Десериализация успешна!!!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(student.toString());


    }
}