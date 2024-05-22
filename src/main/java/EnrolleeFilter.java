import Task13.Enrollee;
import java.util.*;
import java.util.stream.Collectors;

public class EnrolleeFilter {

  public static void main(String[] args) {
    List<Enrollee> enrollees = Arrays.asList(
        new Enrollee("Ivanov", 85),
        new Enrollee("Petrov", 75),
        new Enrollee("Sidorov", 95),
        new Enrollee("Smirnov", 55),
        new Enrollee("Kuznetsov", 65),
        new Enrollee("Semenov", 90),
        new Enrollee("Fedorov", 70)
    );

    List<Enrollee> notAdmitted = enrollees.stream()
        .filter(e -> e.score < 60)
        .collect(Collectors.toList());

    List<String> notAdmittedLastNames = notAdmitted.stream()
        .map(e -> e.lastName)
        .collect(Collectors.toList());

    System.out.println("Enrollees not admitted to the institute:");
    notAdmitted.forEach(System.out::println);

    System.out.println("\nLast names of enrollees not admitted:");
    notAdmittedLastNames.forEach(System.out::println);
  }
}
