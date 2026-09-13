package class3.policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {

    // 운영진 제출 정책: 제출 대상이 아님
    @Override
    public boolean isSubmittable() {
        return false;
    }
}
