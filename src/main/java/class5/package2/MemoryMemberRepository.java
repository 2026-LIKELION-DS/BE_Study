package class5.package2;

import class5.role.Member;

import java.util.ArrayList;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {

    private final List<Member> members = new ArrayList<>();


    @Override
    public void save(Member member) {
        members.add(member);
    }

    @Override
    public List<Member> findAll() {
        return members;
    }

    @Override
    public Member findByName(String name) {

        for (Member member : members) {

            if (member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }


    @Override
    public boolean existsByName(String name) {

        for (Member member : members) {

            if (member.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}