package com.likelion.likelionstudy.class6.service;

import com.likelion.likelionstudy.class6.domain.Lion;
import com.likelion.likelionstudy.class6.domain.Role;
import com.likelion.likelionstudy.class6.domain.Staff;
import com.likelion.likelionstudy.class6.dto.LionRegisterRequest;
import com.likelion.likelionstudy.class6.dto.MemberResponse;
import com.likelion.likelionstudy.class6.dto.MemberUpdateRequest;
import com.likelion.likelionstudy.class6.dto.StaffRegisterRequest;
import com.likelion.likelionstudy.class6.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponse registerLion(LionRegisterRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("이미 존재하는 이름입니다.");
        }
        Role lion = new Lion(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), request.getStudentId());
        Role saved = memberRepository.save(lion);
        return new MemberResponse(saved);
    }

    public MemberResponse registerStaff(StaffRegisterRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("이미 존재하는 이름입니다.");
        }
        Role staff = new Staff(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), request.getPosition());
        Role saved = memberRepository.save(staff);
        return new MemberResponse(saved);
    }

    public List<MemberResponse> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(MemberResponse::new)
                .collect(Collectors.toList());
    }

    public MemberResponse getMemberById(Long id) {
        Role role = memberRepository.findById(id);
        if (role == null) {
            throw new IllegalArgumentException("존재하지 않는 멤버입니다.");
        }
        return new MemberResponse(role);
    }

    public MemberResponse updateMember(Long id, MemberUpdateRequest request) {
        Role role = memberRepository.findById(id);
        if (role == null) {
            throw new IllegalArgumentException("존재하지 않는 멤버입니다.");
        }
        role.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        memberRepository.save(role);
        return new MemberResponse(role);
    }

    public void deleteMember(Long id) {
        if (memberRepository.findById(id) == null) {
            throw new IllegalArgumentException("존재하지 않는 멤버입니다.");
        }
        memberRepository.deleteById(id);
    }
}