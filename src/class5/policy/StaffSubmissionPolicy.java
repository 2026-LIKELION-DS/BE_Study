package class5.policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {
    public boolean canSubmit() {
        return false;
    }
}