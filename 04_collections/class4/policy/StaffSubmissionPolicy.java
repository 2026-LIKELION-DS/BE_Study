package class4.policy;

/** 운영진의 제출 정책: 제출 대상이 아니다. */
public class StaffSubmissionPolicy implements SubmissionPolicy {

    @Override
    public boolean isSubmittable() {
        return false;
    }
}
