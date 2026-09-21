package class4.policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {
    public boolean canSubmit() {
        return false;
    }
}