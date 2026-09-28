package com.netlion.pbl.service;

import com.netlion.pbl.domain.role.Lion;
import com.netlion.pbl.domain.role.Role;
import com.netlion.pbl.domain.role.Staff;
import com.netlion.pbl.dto.LionCreateRequest;
import com.netlion.pbl.dto.LionUpdateRequest;
import com.netlion.pbl.dto.StaffCreateRequest;
import com.netlion.pbl.dto.StaffUpdateRequest;
import com.netlion.pbl.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Lion createLion(LionCreateRequest request) {
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
        return lion;
    }

    public Staff createStaff(StaffCreateRequest request) {
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
        return staff;
    }

    public Role findByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Role> findAll() {
        return memberRepository.findAll();
    }

    public Lion updateLion(String name, LionUpdateRequest request) {
        Role existing = memberRepository.findByName(name);
        if (existing == null) {
            return null;
        }
        Lion updated = new Lion(
                name,
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );
        memberRepository.updateByName(name, updated);
        return updated;
    }

    public Staff updateStaff(String name, StaffUpdateRequest request) {
        Role existing = memberRepository.findByName(name);
        if (existing == null) {
            return null;
        }
        Staff updated = new Staff(
                name,
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );
        memberRepository.updateByName(name, updated);
        return updated;
    }

    public boolean deleteMember(String name) {
        return memberRepository.deleteByName(name);
    }
}