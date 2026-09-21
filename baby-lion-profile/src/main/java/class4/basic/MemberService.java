package class4.basic;

import java.util.List;
import java.util.Optional;

public class MemberService {

	private final MemberRepository memberRepository = new MemberRepository();

	public boolean register(Member member) {
		if (memberRepository.existsByName(member.getName())) {
			return false;
		}
		memberRepository.save(member);
		return true;
	}

	public Optional<Member> findByName(String name) {
		return memberRepository.findByName(name);
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}
}
