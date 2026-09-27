package com.example.pbl_week6.service;

import com.example.pbl_week6.dto.LionCreateRequest;
import com.example.pbl_week6.dto.LionUpdateRequest;
import com.example.pbl_week6.dto.StaffCreateRequest;
import com.example.pbl_week6.dto.StaffUpdateRequest;
import com.example.pbl_week6.repository.MemberRepository;
import com.example.pbl_week6.role.Lion;
import com.example.pbl_week6.role.Role;
import com.example.pbl_week6.role.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Role findMember(String name) {
        return memberRepository.findByName(name);
    }

    public List<Role> getAllMembers() {
        return memberRepository.findAll();
    }

    // 1. Lion 등록
    public Lion createLion(LionCreateRequest req) {
        if (memberRepository.existsByName(req.getName())) {
            return null; // 중복 시 null
        }
        Lion lion = new Lion(req.getName(), req.getMajor(), req.getGeneration(), req.getPart(), req.getStudentId());
        memberRepository.save(lion);
        return lion;
    }

    // 2. Staff 등록
    public Staff createStaff(StaffCreateRequest req) {
        if (memberRepository.existsByName(req.getName())) {
            return null; // 중복 시 null
        }
        Staff staff = new Staff(req.getName(), req.getMajor(), req.getGeneration(), req.getPart(), req.getPosition());
        memberRepository.save(staff);
        return staff;
    }

    // 3. Lion 수정
    public Lion updateLion(String name, LionUpdateRequest req) {
        Role member = memberRepository.findByName(name);
        if (member == null) {
            return null;
        }
        Lion updatedLion = new Lion(name, req.getMajor(), req.getGeneration(), req.getPart(), req.getStudentId());
        memberRepository.updateByName(name, updatedLion);
        return updatedLion;
    }

    // 4. Staff 수정
    public Staff updateStaff(String name, StaffUpdateRequest req) {
        Role member = memberRepository.findByName(name);
        if (member == null) {
            return null;
        }
        Staff updatedStaff = new Staff(name, req.getMajor(), req.getGeneration(), req.getPart(), req.getPosition());
        memberRepository.updateByName(name, updatedStaff);
        return updatedStaff;
    }

    // 5. 멤버 삭제
    public boolean deleteMember(String name) {
        return memberRepository.deleteByName(name);
    }
}