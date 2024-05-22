package Task13;

public class Enrollee {
  public String lastName;
  public int score;

  public Enrollee(String lastName, int score) {
    this.lastName = lastName;
    this.score = score;
  }

  @Override
  public String toString() {
    return lastName + " (" + score + ")";
  }
}