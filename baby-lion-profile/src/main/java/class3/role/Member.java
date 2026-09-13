package class3.role;

import class3.policy.SubmissionPolicy;

public abstract class Member {

	private final String name;
	private final String major;
	private final int generation;
	private final String part;

	protected Member(String name, String major, int generation, String part) {
		this.name = name;
		this.major = major;
		this.generation = generation;
		this.part = part;
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public int getGeneration() {
		return generation;
	}

	public String getPart() {
		return part;
	}

	public abstract String getRoleName();

	public abstract String getDetailInfo();

	protected abstract SubmissionPolicy getPolicy();

	public boolean canSubmit() {
		return getPolicy().canSubmit();
	}
}
