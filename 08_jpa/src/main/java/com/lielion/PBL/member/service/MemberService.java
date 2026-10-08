package com.lielion.PBL.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lielion.PBL.member.domain.Member;
import com.lielion.PBL.member.domain.RoleType;
import com.lielion.PBL.member.dto.LionCreateRequest;
import com.lielion.PBL.member.dto.LionUpdateRequest;
import com.lielion.PBL.member.dto.StaffCreateRequest;
import com.lielion.PBL.member.dto.StaffUpdateRequest;
import com.lielion.PBL.member.repository.MemberRepository;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /** Lion 등록. 이름이 중복이면 null. */
    public Member createLion(LionCreateRequest request) {
        if (memberRepository.findByName(request.name()).isPresent()) {
            return null;
        }
        Member member = new Member(request.name(), request.major(), request.generation(),
                request.part(), RoleType.LION, request.studentId(), null);
        // save() 가 반환하는 객체에는 DB가 만든 id 가 채워져 있다.
        return memberRepository.save(member);
    }

    /** Staff 등록. 이름이 중복이면 null. */
    public Member createStaff(StaffCreateRequest request) {
        if (memberRepository.findByName(request.name()).isPresent()) {
            return null;
        }
        Member member = new Member(request.name(), request.major(), request.generation(),
                request.part(), RoleType.STAFF, null, request.position());
        return memberRepository.save(member);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    /** id 로 단건 조회. 없으면 null. */
    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    /** Lion 수정. 없거나 Lion 이 아니면 null. */
    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.LION) {
            return null;
        }
        member.updateInfo(request.major(), request.generation(), request.part());
        member.updateStudentId(request.studentId());
        return memberRepository.save(member);
    }

    /** Staff 수정. 없거나 Staff 가 아니면 null. */
    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.STAFF) {
            return null;
        }
        member.updateInfo(request.major(), request.generation(), request.part());
        member.updatePosition(request.position());
        return memberRepository.save(member);
    }

    /** 삭제. 없으면 false. */
    public boolean deleteMember(Long id) {
        if (!memberRepository.existsById(id)) {
            return false;
        }
        memberRepository.deleteById(id);
        return true;
    }
}
