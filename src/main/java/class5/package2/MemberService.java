package class5.package2;

import class5.role.Member;

import java.util.List;

public class MemberService {

    private final MemberRepository repository;


    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }


    public boolean register(Member member) {

        if (repository.existsByName(member.getName())) {
            return false;
        }

        repository.save(member);
        return true;
    }


    public List<Member> getAllMembers() {
        return repository.findAll();
    }


    public Member findMemberByName(String name) {
        return repository.findByName(name);
    }
}