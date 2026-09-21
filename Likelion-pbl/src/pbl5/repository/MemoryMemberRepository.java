package pbl5.repository;

import pbl5.domain.Member;
import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {
    private final List<Member> memberList = new ArrayList<>();

    @Override
    public void save(Member member) {
        memberList.add(member);
    }

    @Override
    public Member findByName(String name) {
        return memberList.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Member> findAll() {
        return memberList;
    }

    @Override
    public boolean existsByName(String name) {
        return memberList.stream().anyMatch(m -> m.getName().equals(name));
    }
}