package com.example.pbl_week6.service;

import com.example.pbl_week6.domain.Member;
import com.example.pbl_week6.domain.RoleType;
import com.example.pbl_week6.dto.LionCreateRequest;
import com.example.pbl_week6.dto.LionUpdateRequest;
import com.example.pbl_week6.dto.StaffCreateRequest;
import com.example.pbl_week6.dto.StaffUpdateRequest;
import com.example.pbl_week6.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 클래스 전체는 읽기 전용 (성능 최적화)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Transactional // 변경 발생 시 쓰기 트랜잭션 적용
    public Member createLion(LionCreateRequest req) {
        if (memberRepository.existsByName(req.getName())) {
            return null;
        }
        Member lion = new Member(
                req.getName(), req.getMajor(), req.getGeneration(),
                req.getPart(), RoleType.LION, req.getStudentId(), null
        );
        return memberRepository.save(lion);
    }

    @Transactional
    public Member createStaff(StaffCreateRequest req) {
        if (memberRepository.existsByName(req.getName())) {
            return null;
        }
        Member staff = new Member(
                req.getName(), req.getMajor(), req.getGeneration(),
                req.getPart(), RoleType.STAFF, null, req.getPosition()
        );
        return memberRepository.save(staff);
    }

    @Transactional
    public Member updateLion(Long id, LionUpdateRequest req) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.LION) {
            return null;
        }
        member.updateInfo(req.getMajor(), req.getGeneration(), req.getPart());
        member.updateStudentId(req.getStudentId());
        return memberRepository.save(member);
    }

    @Transactional
    public Member updateStaff(Long id, StaffUpdateRequest req) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.STAFF) {
            return null;
        }
        member.updateInfo(req.getMajor(), req.getGeneration(), req.getPart());
        member.updatePosition(req.getPosition());
        return memberRepository.save(member);
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