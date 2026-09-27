package com.likelion.pbl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.likelion.pbl.dto.LionCreateRequest;
import com.likelion.pbl.dto.LionUpdateRequest;
import com.likelion.pbl.dto.StaffCreateRequest;
import com.likelion.pbl.dto.StaffUpdateRequest;
import com.likelion.pbl.repository.MemberRepository;
import com.likelion.pbl.role.Lion;
import com.likelion.pbl.role.Role;
import com.likelion.pbl.role.Staff;

/**
 * (5주차와 동일한 로직) Repository 인터페이스에만 의존한다.
 *
 * @Service를 붙이면 이 클래스도 컴포넌트 스캔으로 Bean 등록된다.
 * 생성자의 @Autowired는 "이 타입의 Bean을 스프링 컨테이너에서 찾아 주입해줘"라는 뜻인데,
 * 생성자가 이거 하나뿐이라면 @Autowired를 생략해도 스프링이 자동으로 주입해준다.
 * (직접 지워보고 동일하게 동작하는지 확인해보세요 — 미션의 "@Autowired 생략 실험" 부분)
 */
@Service
public class MemberService {

    private final MemberRepository repository;

    @Autowired
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

    // ===== 7주차: REST API용 CRUD 메서드 =====

    /** Lion을 생성한다. 이름이 중복되면 null을 반환한다. */
    public Lion createLion(LionCreateRequest request) {
        if (repository.existsByName(request.name())) {
            return null;
        }
        Lion lion = new Lion(
                request.name(), request.major(), request.generation(), request.part(), request.studentId());
        repository.save(lion);
        return lion;
    }

    /** Staff를 생성한다. 이름이 중복되면 null을 반환한다. */
    public Staff createStaff(StaffCreateRequest request) {
        if (repository.existsByName(request.name())) {
            return null;
        }
        Staff staff = new Staff(
                request.name(), request.major(), request.generation(), request.part(), request.position());
        repository.save(staff);
        return staff;
    }

    /** 이름으로 단일 멤버를 조회한다. 없으면 null을 반환한다. */
    public Role findByName(String name) {
        return repository.findByName(name);
    }

    /** 이름으로 멤버를 찾아 Lion 정보를 수정한다. 대상이 없으면 null을 반환한다. */
    public Lion updateLion(String name, LionUpdateRequest request) {
        if (!repository.existsByName(name)) {
            return null;
        }
        Lion updated = new Lion(
                name, request.major(), request.generation(), request.part(), request.studentId());
        repository.updateByName(name, updated);
        return updated;
    }

    /** 이름으로 멤버를 찾아 Staff 정보를 수정한다. 대상이 없으면 null을 반환한다. */
    public Staff updateStaff(String name, StaffUpdateRequest request) {
        if (!repository.existsByName(name)) {
            return null;
        }
        Staff updated = new Staff(
                name, request.major(), request.generation(), request.part(), request.position());
        repository.updateByName(name, updated);
        return updated;
    }

    /** 이름으로 멤버를 삭제한다. 삭제 성공 여부를 반환한다. */
    public boolean deleteMember(String name) {
        return repository.deleteByName(name);
    }
}
