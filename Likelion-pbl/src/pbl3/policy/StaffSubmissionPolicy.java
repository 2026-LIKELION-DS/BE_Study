package pbl3.policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean canSubmitAssignment() {
        return false; // 운영진은 제출 불가
    }
}