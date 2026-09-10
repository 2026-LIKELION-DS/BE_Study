package class2.package1;

public class Lion {

	public String name;
	String major;
	private int generation;

	public Lion(String name, String major, int generation) {
		this.name = name;
		this.major = major;
		this.generation = generation;
	}

	public String validate() {
		if (name == null || name.isEmpty()) {
			return "이름이 비어 있습니다.";
		}
		if (major == null || major.isEmpty()) {
			return "전공이 비어 있습니다.";
		}
		if (generation < 1) {
			return "기수는 1 이상이어야 합니다.";
		}
		return null;
	}

	public void printInfo() {
		System.out.println("👤 이름: " + name + "  |  🐾 전공: " + major + "  |  📌 기수: " + generation);
	}
}
