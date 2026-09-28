package com.likelion.likelionstudy.class8.service;

import com.likelion.likelionstudy.class8.domain.Member;
import com.likelion.likelionstudy.class8.domain.RoleType;
import com.likelion.likelionstudy.class8.dto.*;
import com.likelion.likelionstudy.class8.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponse createLion(LionCreateRequest request) {
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
        Member savedMember = memberRepository.save(member);
        return MemberResponse.from(savedMember);
    }

    @Transactional
    public MemberResponse createStaff(StaffCreateRequest request) {
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
        Member savedMember = memberRepository.save(member);
        return MemberResponse.from(savedMember);
    }

    public List<MemberResponse> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(MemberResponse::from)
                .toList();
    }

    public MemberResponse getMemberById(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }
        return MemberResponse.from(member);
    }

    @Transactional
    public MemberResponse updateLion(Long id, LionUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.LION) {
            return null;
        }
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getStudentId());
        return MemberResponse.from(member);
    }

    @Transactional
    public MemberResponse updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.STAFF) {
            return null;
        }
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updatePosition(request.getPosition());
        return MemberResponse.from(member);
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