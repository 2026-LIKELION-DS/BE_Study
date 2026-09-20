package class4.di;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {

	private final List<Member> members = new ArrayList<>();

	@Override
	public void save(Member member) {
		members.add(member);
	}

	@Override
	public Optional<Member> findByName(String name) {
		return members.stream()
			.filter(member -> member.getName().equals(name))
			.findFirst();
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(members);
	}

	@Override
	public boolean existsByName(String name) {
		return findByName(name).isPresent();
	}
}
