// Demonstrates defensive copying with Collections.unmodifiableList to prevent encapsulation leakage.
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private final List<String> members = new ArrayList<>();

    public void addMember(String name) {
        members.add(name);
    }

    // BAD: Returns internal reference which callers can directly mutate
    public List<String> getMembersUnsafe() {
        return members;
    }

    // GOOD: Returns read-only unmodifiable view
    public List<String> getMembers() {
        return Collections.unmodifiableList(members);
    }

    public static void main(String[] args) {
        Team t = new Team();
        t.addMember("Chipo");

        // Mutating unsafe getter corrupts internal state
        t.getMembersUnsafe().clear();
        System.out.println("After unsafe clear: " + t.getMembers().size());

        t.addMember("Chipo");
        try {
            t.getMembers().clear(); // Blocked by unmodifiable list
        } catch (UnsupportedOperationException e) {
            System.out.println("Safe getter blocked modification");
        }
    }
}
