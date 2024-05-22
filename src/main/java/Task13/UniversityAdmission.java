package Task13;

import java.util.*;
import java.util.stream.Collectors;

public class UniversityAdmission {


  public static void main(String[] args) {
    List<Enrollee> enrollees = Arrays.asList(
        new Enrollee("Ivanov", 85),
        new Enrollee("Petrov", 75),
        new Enrollee("Sidorov", 95),
        new Enrollee("Smirnov", 55),
        new Enrollee("Kuznetsov", 55),
        new Enrollee("Semenov", 90),
        new Enrollee("Fedorov", 70)
    );

    int budgetPlaces = 3;
    int contractPlaces = 2;

    List<Enrollee> sortedEnrollees = enrollees.stream()
        .sorted(Comparator.comparingInt((Enrollee e) -> -e.score).thenComparing(e -> e.lastName))
        .collect(Collectors.toList());

    List<Enrollee> budgetStudents = sortedEnrollees.stream()
        .filter(e -> e.score >= 60)
        .limit(budgetPlaces)
        .sorted(Comparator.comparing(e -> e.lastName))
        .collect(Collectors.toList());

    List<Enrollee> contractStudents = sortedEnrollees.stream()
        .filter(e -> e.score >= 60 && !budgetStudents.contains(e))
        .limit(contractPlaces)
        .sorted(Comparator.comparing(e -> e.lastName))
        .collect(Collectors.toList());

    List<Enrollee> otherContractStudents = sortedEnrollees.stream()
        .filter(e -> e.score >= 60 && !budgetStudents.contains(e) && !contractStudents.contains(e))
        .sorted(Comparator.comparing(e -> e.lastName))
        .collect(Collectors.toList());

    System.out.println("Budget Students:");
    budgetStudents.forEach(System.out::println);

    System.out.println("\nContract Students:");
    contractStudents.forEach(System.out::println);

    System.out.println("\nOther Contract Students:");
    otherContractStudents.forEach(System.out::println);
  }
}
