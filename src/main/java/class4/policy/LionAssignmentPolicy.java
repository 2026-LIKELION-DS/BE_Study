package class4.policy;

public class LionAssignmentPolicy implements AssignmentPolicy {

    @Override
    public boolean canSubmit() {
        return true;
    }
}