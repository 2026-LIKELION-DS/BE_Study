package class5.service;

import class5.repository.MemberRepository;
import class5.role.Role;
import java.util.List;
import java.util.Optional;

public class MemberService {

	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public boolean register(Role member) {
		if (memberRepository.existsByName(member.getName())) {
			return false;
		}
		memberRepository.save(member);
		return true;
	}

	public boolean existsByName(String name) {
		return memberRepository.existsByName(name);
	}

	public Optional<Role> findByName(String name) {
		return memberRepository.findByName(name);
	}

	public List<Role> findAll() {
		return memberRepository.findAll();
	}

	public List<Role> findByPart(String part) {
		return memberRepository.findByPart(part);
	}

	public List<String> getRegisteredParts() {
		return memberRepository.getRegisteredParts();
	}
}
