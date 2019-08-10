package com.javadub1.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        Scanner scanner = new Scanner(System.in);

        boolean isWorking = true;

        do {
            String komenda = scanner.nextLine();
            if (komenda.equalsIgnoreCase("dodaj")){
                Student nowyStudent = new Student();

                System.out.println("Podaj imię: ");
                nowyStudent.setName(scanner.nextLine());

                System.out.println("Podaj indeks: ");
                nowyStudent.setIndeks(scanner.nextLine());

                System.out.println("Podaj wiek: ");
                nowyStudent.setAge(Integer.parseInt(scanner.nextLine()));

                dao.insertStudent(nowyStudent);

            }else if (komenda.equalsIgnoreCase("usun")){
                System.out.println("Podaj ID Studenta");
                dao.deleteStudent(Long.parseLong(scanner.nextLine()));

            }else if (komenda.equalsIgnoreCase("listuj")){
                dao.getAllStudents().forEach(System.out::println);

            }else if (komenda.equalsIgnoreCase("quit")){
                isWorking = false;
            }
        }while (isWorking);



    }
}
