package Task21;

class Student {
  String firstName;
  String lastName;
  String recordBookNumber;
  double averageScore;

  Student(String firstName, String lastName, String recordBookNumber, double averageScore) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.recordBookNumber = recordBookNumber;
    this.averageScore = averageScore;
  }

  @Override
  public String toString() {
    return lastName + " " + firstName + " (" + recordBookNumber + ", " + averageScore + ")";
  }
}