package Task21;

import java.util.*;
import java.util.stream.Collectors;

public class InstituteManagement {

  public static void main(String[] args) {
    List<Student> faculty1Students = Arrays.asList(
        new Student("Ivan", "Ivanov", "123", 85.0),
        new Student("Petr", "Petrov", "124", 75.0),
        new Student("Sidor", "Sidorov", "125", 95.0)
    );

    List<Student> faculty2Students = Arrays.asList(
        new Student("Alex", "Smirnov", "126", 65.0),
        new Student("Nikolay", "Kuznetsov", "127", 70.0)
    );

    List<Department> departments = Arrays.asList(
        new Department("Engineering", faculty1Students),
        new Department("Mathematics", faculty2Students)
    );

    Institute institute = new Institute("Tech Institute", departments);

    List<Student> allStudents = institute.getAllStudents().stream()
        .sorted(Comparator.comparing((Student s) -> s.lastName)
            .thenComparing(s -> s.firstName)
            .thenComparing(s -> s.recordBookNumber))
        .collect(Collectors.toList());

    System.out.println("All Students:");
    allStudents.forEach(System.out::println);

    double averageInstituteScore = allStudents.stream()
        .mapToDouble(student -> student.averageScore)
        .average()
        .orElse(0.0);

    List<Student> aboveAverageStudents = allStudents.stream()
        .filter(student -> student.averageScore > averageInstituteScore)
        .collect(Collectors.toList());

    System.out.println("\nStudents with above average scores:");
    aboveAverageStudents.forEach(System.out::println);
  }
}
