// Demonstrates creating an immutable class in Java with final class and fields.
// 1. 'final class' prevents subclassing, ensuring methods cannot be overridden to mutate state.
final class ImmutablePerson {
    // 2. 'private final' fields guarantee that values can be assigned only once during construction.
    private final String nationalId;
    private final String fullName;
    private final int birthYear;

    public ImmutablePerson(String nationalId, String fullName, int birthYear) {
        if (nationalId == null || nationalId.isBlank()) {
            throw new IllegalArgumentException("National ID cannot be empty");
        }
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name cannot be empty");
        }
        this.nationalId = nationalId;
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    // 3. No setters provided: state is read-only after instantiation.
    public String getNationalId() { return nationalId; }
    public String getFullName() { return fullName; }
    public int getBirthYear() { return birthYear; }

    @Override
    public String toString() {
        return String.format("ImmutablePerson[ID=%s, Name=%s, BirthYear=%d]",
                nationalId, fullName, birthYear);
    }
}

public class ImmutablePersonDemo {
    public static void main(String[] args) {
        ImmutablePerson person = new ImmutablePerson("63-241562-F-42", "Anesu B Kahanda", 2004);
        System.out.println(person);
        System.out.println("\nDesign choices for immutability:");
        System.out.println("1. Class is declared final: Subclasses cannot override methods to introduce mutability.");
        System.out.println("2. Fields are private and final: Memory is safely published and values cannot be reassigned.");
        System.out.println("3. No setter methods exist: Outside callers cannot alter object state.");
        System.out.println("4. Thread safety: The object can be freely shared across concurrent threads without locks.");
    }
}
