package class3.policy;

public class LionSubmissionPolicy implements SubmissionPolicy {

    // 아기사자 제출 정책: 항상 제출 가능
    @Override
    public boolean isSubmittable() {
        return true;
    }
}
