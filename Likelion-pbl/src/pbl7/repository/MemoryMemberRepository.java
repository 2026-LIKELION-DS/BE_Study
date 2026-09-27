package pbl7.repository;

import org.springframework.stereotype.Repository;
import pbl7.domain.Member;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryMemberRepository implements MemberRepository {
    private final List<Member> store = new ArrayList<>();

    @Override
    public void save(Member member) {
        store.add(member);
    }

    @Override
    public Member findByName(String name) {
        return store.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store);
    }

    @Override
    public boolean existsByName(String name) {
        return store.stream().anyMatch(m -> m.getName().equals(name));
    }

    @Override
    public void updateByName(String name, Member updatedMember) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getName().equals(name)) {
                store.set(i, updatedMember);
                return;
            }
        }
    }

    @Override
    public boolean deleteByName(String name) {
        return store.removeIf(m -> m.getName().equals(name));
    }
}