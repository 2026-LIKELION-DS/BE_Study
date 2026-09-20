package class5.repository;

import class5.role.Role;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {

	private final List<Role> members = new ArrayList<>();
	private final Map<String, List<Role>> membersByPart = new LinkedHashMap<>();

	@Override
	public void save(Role member) {
		members.add(member);
		membersByPart.computeIfAbsent(member.getPart(), part -> new ArrayList<>()).add(member);
	}

	@Override
	public Optional<Role> findByName(String name) {
		return members.stream()
			.filter(member -> member.getName().equals(name))
			.findFirst();
	}

	@Override
	public List<Role> findAll() {
		return new ArrayList<>(members);
	}

	@Override
	public boolean existsByName(String name) {
		return findByName(name).isPresent();
	}

	@Override
	public List<Role> findByPart(String part) {
		return new ArrayList<>(membersByPart.getOrDefault(part, List.of()));
	}

	@Override
	public List<String> getRegisteredParts() {
		return new ArrayList<>(membersByPart.keySet());
	}
}
