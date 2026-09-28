package com.likelion.likelionstudy.class8.service;

import com.likelion.likelionstudy.class8.domain.Member;
import com.likelion.likelionstudy.class8.dto.*;
import com.likelion.likelionstudy.class8.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse createLion(LionCreateRequest request) {
        Member member = new Member(request.getName(), request.getStudentId(), request.getMajor(), request.getGeneration(), request.getPart());
        Member savedMember = memberRepository.save(member);
        return MemberResponse.from(savedMember);
    }

    @Transactional
    public MemberResponse createStaff(StaffCreateRequest request) {
        Member member = new Member(request.getName(), request.getStudentId(), request.getMajor(), request.getGeneration(), request.getPart(), request.getPosition());
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
        if (member == null) {
            return null;
        }
        member.updateLion(request.getName(), request.getStudentId(), request.getMajor(), request.getGeneration(), request.getPart());
        return MemberResponse.from(member);
    }

    @Transactional
    public MemberResponse updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null) {
            return null;
        }
        member.updateStaff(request.getName(), request.getStudentId(), request.getMajor(), request.getGeneration(), request.getPart(), request.getPosition());
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