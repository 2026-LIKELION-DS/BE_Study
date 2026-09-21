package class4.di;

import java.util.List;
import java.util.Optional;

public class MockMemberRepository implements MemberRepository {

	private final List<Member> dummyMembers = List.of(
		new Member("더미사자", "아기사자", "컴퓨터공학과", 14, "백엔드", "202299999"),
		new Member("더미운영", "운영진", "경영학과", 10, "기획", "부대표")
	);

	@Override
	public void save(Member member) {
		System.out.println("⚠️ Mock 저장소는 실제로 저장하지 않습니다: " + member.getName());
	}

	@Override
	public Optional<Member> findByName(String name) {
		return dummyMembers.stream()
			.filter(member -> member.getName().equals(name))
			.findFirst();
	}

	@Override
	public List<Member> findAll() {
		return dummyMembers;
	}

	@Override
	public boolean existsByName(String name) {
		return findByName(name).isPresent();
	}
}
