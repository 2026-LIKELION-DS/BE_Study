package com.example.pbl_springboot.class7.service;

import com.example.pbl_springboot.class7.dto.LionCreateRequest;
import com.example.pbl_springboot.class7.dto.LionUpdateRequest;
import com.example.pbl_springboot.class7.dto.StaffCreateRequest;
import com.example.pbl_springboot.class7.dto.StaffUpdateRequest;
import com.example.pbl_springboot.class7.repository.MemberRepository;
import com.example.pbl_springboot.class7.role.Lion;
import com.example.pbl_springboot.class7.role.Member;
import com.example.pbl_springboot.class7.role.Staff;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Lion createLion(LionCreateRequest request) {

        if (repository.existsByName(request.getName())) {
            return null;
        }

        Lion lion = new Lion(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );

        repository.save(lion);

        return lion;
    }

    public Staff createStaff(StaffCreateRequest request) {

        if (repository.existsByName(request.getName())) {
            return null;
        }

        Staff staff = new Staff(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );

        repository.save(staff);

        return staff;
    }

    public Member findMemberByName(String name) {
        return repository.findByName(name);
    }

    public Lion updateLion(
            String name,
            LionUpdateRequest request
    ) {

        Member member = repository.findByName(name);

        if (!(member instanceof Lion)) {
            return null;
        }

        Lion updatedLion = new Lion(
                name,
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );

        repository.updateByName(name, updatedLion);

        return updatedLion;
    }

    public Staff updateStaff(
            String name,
            StaffUpdateRequest request
    ) {

        Member member = repository.findByName(name);

        if (!(member instanceof Staff)) {
            return null;
        }

        Staff updatedStaff = new Staff(
                name,
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );

        repository.updateByName(name, updatedStaff);

        return updatedStaff;
    }

    public boolean deleteMember(String name) {
        return repository.deleteByName(name);
    }
}