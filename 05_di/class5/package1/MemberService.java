package class5.package1;

import java.util.List;

import class5.role.Role;

/**
 * (Step 1) 멤버 등록/검색/조회 비즈니스 로직을 처리하는 클래스.
 *
 * Step 1에서는 Service가 Repository를 "직접" 생성해서 사용한다.
 *    (누가 이 Repository를 쓸지, Service 내부에서 스스로 결정한다 -> 강한 결합)
 *    Step 2에서 이 부분을 생성자 주입 방식으로 리팩토링한다.
 */
public class MemberService {

    private final MemberRepository repository = new MemberRepository();

    /** 이름 중복이 아니면 멤버를 등록한다. 중복이면 false를 반환한다. */
    public boolean registerMember(Role role) {
        if (repository.existsByName(role.getName())) {
            return false;
        }
        repository.save(role);
        return true;
    }

    /** 이름으로 멤버를 검색한다. */
    public Role searchByName(String name) {
        return repository.findByName(name);
    }

    /** 전체 멤버 목록을 반환한다. */
    public List<Role> getAllMembers() {
        return repository.findAll();
    }
}
