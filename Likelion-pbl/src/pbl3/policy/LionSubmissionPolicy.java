package pbl3.policy;

public class LionSubmissionPolicy implements SubmissionPolicy {
    @Override
    public boolean canSubmitAssignment() {
        return true; // 아기사자는 제출 가능
    }
}