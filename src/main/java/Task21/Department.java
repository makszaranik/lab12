package Task21;

import java.util.List;

class Department {
  String name;
  List<Student> students;

  Department(String name, List<Student> students) {
    this.name = name;
    this.students = students;
  }
}