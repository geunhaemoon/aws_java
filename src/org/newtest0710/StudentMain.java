package org.newtest0710;

import java.util.ArrayList;
import java.util.List;

public class StudentMain {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("홍길동"));

        students.add(new Student("장영실"));

        for(Student student : students) {

                student.showStudent();

        }

    }

}