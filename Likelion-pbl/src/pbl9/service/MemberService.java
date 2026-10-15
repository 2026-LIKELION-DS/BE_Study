package pbl9.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pbl9.domain.Member;
import pbl9.domain.RoleType;
import pbl9.dto.LionCreateRequest;
import pbl9.dto.LionUpdateRequest;
import pbl9.dto.StaffCreateRequest;
import pbl9.dto.StaffUpdateRequest;
import pbl9.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true) // 기본적으로 모든 메서드는 읽기 전용 트랜잭션
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional // CUD 작업은 쓰기 트랜잭션 적용
    public Member createLion(LionCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }
        Member member = new Member(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                RoleType.LION,
                request.getStudentId(),
                null
        );
        return memberRepository.save(member);
    }

    @Transactional
    public Member createStaff(StaffCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }
        Member member = new Member(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                RoleType.STAFF,
                null,
                request.getPosition()
        );
        return memberRepository.save(member);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Transactional
    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.LION) {
            return null;
        }
        member.updateLionInfo(request.getMajor(), request.getGeneration(), request.getPart(), request.getStudentId());
        return member;
    }

    @Transactional
    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.STAFF) {
            return null;
        }
        member.updateStaffInfo(request.getMajor(), request.getGeneration(), request.getPart(), request.getPosition());
        return member;
    }

    @Transactional
    public boolean deleteMember(Long id) {
        if (!memberRepository.existsById(id)) {
            return false;
        }
        memberRepository.deleteById(id);
        return true;
    }
}