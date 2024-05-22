package Task21;

import java.util.List;
import java.util.stream.Collectors;

class Institute {
  String name;
  List<Department> faculties;

  Institute(String name, List<Department> faculties) {
    this.name = name;
    this.faculties = faculties;
  }

  public List<Student> getAllStudents() {
    return faculties.stream()
        .flatMap(faculty -> faculty.students.stream())
        .collect(Collectors.toList());
  }
}
