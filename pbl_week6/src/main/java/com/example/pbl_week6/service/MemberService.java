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
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 단건 조회 (ID 기반)
    @Transactional(readOnly = true)
    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    // 전체 조회
    @Transactional(readOnly = true)
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    // Lion 등록
    public Member createLion(LionCreateRequest req) {
        if (memberRepository.existsByName(req.getName())) {
            return null; // 이름 중복 시 null
        }
        Member lion = new Member(
                req.getName(), req.getMajor(), req.getGeneration(),
                req.getPart(), RoleType.LION, req.getStudentId(), null
        );
        return memberRepository.save(lion);
    }

    // Staff 등록
    public Member createStaff(StaffCreateRequest req) {
        if (memberRepository.existsByName(req.getName())) {
            return null; // 이름 중복 시 null
        }
        Member staff = new Member(
                req.getName(), req.getMajor(), req.getGeneration(),
                req.getPart(), RoleType.STAFF, null, req.getPosition()
        );
        return memberRepository.save(staff);
    }

    // Lion 수정 (ID 기반)
    public Member updateLion(Long id, LionUpdateRequest req) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.LION) {
            return null;
        }
        member.updateInfo(req.getMajor(), req.getGeneration(), req.getPart());
        member.updateStudentId(req.getStudentId());
        return memberRepository.save(member);
    }

    // Staff 수정 (ID 기반)
    public Member updateStaff(Long id, StaffUpdateRequest req) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.STAFF) {
            return null;
        }
        member.updateInfo(req.getMajor(), req.getGeneration(), req.getPart());
        member.updatePosition(req.getPosition());
        return memberRepository.save(member);
    }

    // 삭제 (ID 기반)
    public boolean deleteMember(Long id) {
        if (!memberRepository.existsById(id)) {
            return false;
        }
        memberRepository.deleteById(id);
        return true;
    }
}