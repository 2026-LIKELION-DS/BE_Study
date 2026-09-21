package class5.role;

import class5.policy.StaffSubmissionPolicy;
import class5.policy.SubmissionPolicy;

public class Staff extends Role {

	private final String position;

	public Staff(String name, String major, int generation, String part, String position) {
		super(name, major, generation, part);
		this.position = position;
	}

	@Override
	public String getRoleName() {
		return "운영진";
	}

	@Override
	public String getDetailInfo() {
		return "직책: " + position;
	}

	@Override
	protected SubmissionPolicy getPolicy() {
		return new StaffSubmissionPolicy();
	}
}
