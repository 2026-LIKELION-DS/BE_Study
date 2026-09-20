package class5.package2;

import java.util.List;

import class5.role.Role;

/**
 * (Step 2) Repository "인터페이스"에만 의존하도록 리팩토링한 버전.
 *
 * - Repository를 직접 생성하지 않는다 (new MemoryMemberRepository() 같은 코드가 없다).
 * - 생성자를 통해 외부(Main)에서 구현체를 주입받는다 (의존성 주입 / DI).
 * - repository 필드는 final로 선언해, 한 번 주입되면 다른 구현체로 바뀌지 않는다.
 *
 * 이 클래스는 어떤 구현체(Memory/Mock)가 주입되는지 전혀 알 필요가 없다 (제어의 역전 / IoC).
 */
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

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
