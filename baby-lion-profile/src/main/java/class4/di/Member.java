package class4.di;

public class Member {

	private final String name;
	private final String role;
	private final String major;
	private final int generation;
	private final String part;
	private final String detail;

	public Member(String name, String role, String major, int generation, String part, String detail) {
		this.name = name;
		this.role = role;
		this.major = major;
		this.generation = generation;
		this.part = part;
		this.detail = detail;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
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

	public String getDetail() {
		return detail;
	}
}
