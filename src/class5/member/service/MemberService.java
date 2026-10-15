package class5.member.service;

import class5.member.domain.Member;
import class5.member.domain.RoleType;
import class5.member.dto.*;
import class5.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Member createLion(LionCreateRequest request) {
        if (repository.findByName(request.name()) != null) return null;
        Member member = new Member(request.name(), request.major(), request.generation(), request.part(),
                RoleType.LION, request.studentId(), null);
        return repository.save(member);
    }

    @Transactional
    public Member createStaff(StaffCreateRequest request) {
        if (repository.findByName(request.name()) != null) return null;
        Member member = new Member(request.name(), request.major(), request.generation(), request.part(),
                RoleType.STAFF, null, request.position());
        return repository.save(member);
    }

    public List<Member> findAll() { return repository.findAll(); }

    public Member findById(Long id) { return repository.findById(id).orElse(null); }

    @Transactional
    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = findById(id);
        if (member == null || member.getRoleType() != RoleType.LION) return null;
        member.updateInfo(request.major(), request.generation(), request.part());
        member.updateStudentId(request.studentId());
        return repository.save(member);
    }

    @Transactional
    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = findById(id);
        if (member == null || member.getRoleType() != RoleType.STAFF) return null;
        member.updateInfo(request.major(), request.generation(), request.part());
        member.updatePosition(request.position());
        return repository.save(member);
    }

    @Transactional
    public boolean deleteMember(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
