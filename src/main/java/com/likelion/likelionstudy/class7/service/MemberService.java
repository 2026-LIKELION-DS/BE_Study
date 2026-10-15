package com.likelion.likelionstudy.class7.service;

import com.likelion.likelionstudy.class7.domain.role.Lion;
import com.likelion.likelionstudy.class7.domain.role.Role;
import com.likelion.likelionstudy.class7.domain.role.Staff;
import com.likelion.likelionstudy.class7.dto.*;
import com.likelion.likelionstudy.class7.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public LionResponse createLion(LionCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }
        Lion lion = new Lion(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );
        memberRepository.save(lion);
        return LionResponse.from(lion);
    }

    public StaffResponse createStaff(StaffCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }
        Staff staff = new Staff(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );
        memberRepository.save(staff);
        return StaffResponse.from(staff);
    }

    public Object getMemberByName(String name) {
        Role role = memberRepository.findByName(name);
        if (role == null) {
            return null;
        }
        if (role instanceof Lion lion) {
            return LionResponse.from(lion);
        } else if (role instanceof Staff staff) {
            return StaffResponse.from(staff);
        }
        return null;
    }

    public LionResponse updateLion(String name, LionUpdateRequest request) {
        Role role = memberRepository.findByName(name);
        if (!(role instanceof Lion lion)) {
            return null;
        }
        lion.updateLionInfo(
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );
        memberRepository.updateByName(name, lion);
        return LionResponse.from(lion);
    }

    public StaffResponse updateStaff(String name, StaffUpdateRequest request) {
        Role role = memberRepository.findByName(name);
        if (!(role instanceof Staff staff)) {
            return null;
        }
        staff.updateStaffInfo(
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );
        memberRepository.updateByName(name, staff);
        return StaffResponse.from(staff);
    }

    public boolean deleteMember(String name) {
        return memberRepository.deleteByName(name);
    }
}