package com.example.pbl_springboot.class8.service;

import com.example.pbl_springboot.class8.domain.Member;
import com.example.pbl_springboot.class8.domain.RoleType;
import com.example.pbl_springboot.class8.dto.LionCreateRequest;
import com.example.pbl_springboot.class8.dto.LionUpdateRequest;
import com.example.pbl_springboot.class8.dto.StaffCreateRequest;
import com.example.pbl_springboot.class8.dto.StaffUpdateRequest;
import com.example.pbl_springboot.class8.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Member createLion(LionCreateRequest request) {

        if (repository.existsByName(request.getName())) {
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

        return repository.save(member);
    }

    @Transactional
    public Member createStaff(StaffCreateRequest request) {

        if (repository.existsByName(request.getName())) {
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

        return repository.save(member);
    }

    public List<Member> findAll() {
        return repository.findAll();
    }

    public Member findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Member updateLion(
            Long id,
            LionUpdateRequest request
    ) {
        Member member = repository.findById(id).orElse(null);

        if (member == null || member.getRoleType() != RoleType.LION) {
            return null;
        }

        member.updateInfo(
                request.getMajor(),
                request.getGeneration(),
                request.getPart()
        );

        member.updateStudentId(request.getStudentId());

        return repository.save(member);
    }

    @Transactional
    public Member updateStaff(
            Long id,
            StaffUpdateRequest request
    ) {
        Member member = repository.findById(id).orElse(null);

        if (member == null || member.getRoleType() != RoleType.STAFF) {
            return null;
        }

        member.updateInfo(
                request.getMajor(),
                request.getGeneration(),
                request.getPart()
        );

        member.updatePosition(request.getPosition());

        return repository.save(member);
    }

    @Transactional
    public boolean deleteMember(Long id) {

        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);

        return true;
    }
}