package class5.policy;

/** 아기사자의 제출 정책: 항상 제출 가능하다. */
public class LionSubmissionPolicy implements SubmissionPolicy {

    @Override
    public boolean isSubmittable() {
        return true;
    }
}
