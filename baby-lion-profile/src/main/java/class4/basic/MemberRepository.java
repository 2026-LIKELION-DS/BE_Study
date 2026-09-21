package class4.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberRepository {

	private final List<Member> members = new ArrayList<>();

	public void save(Member member) {
		members.add(member);
	}

	public Optional<Member> findByName(String name) {
		return members.stream()
			.filter(member -> member.getName().equals(name))
			.findFirst();
	}

	public List<Member> findAll() {
		return new ArrayList<>(members);
	}

	public boolean existsByName(String name) {
		return findByName(name).isPresent();
	}
}
