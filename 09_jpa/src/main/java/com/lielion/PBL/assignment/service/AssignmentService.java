package com.lielion.PBL.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lielion.PBL.assignment.domain.Assignment;
import com.lielion.PBL.assignment.dto.AssignmentCreateRequest;
import com.lielion.PBL.assignment.dto.AssignmentUpdateRequest;
import com.lielion.PBL.assignment.repository.AssignmentRepository;
import com.lielion.PBL.member.domain.Member;
import com.lielion.PBL.member.repository.MemberRepository;

@Service
@Transactional(readOnly = true)
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, MemberRepository memberRepository) {
        this.assignmentRepository = assignmentRepository;
        this.memberRepository = memberRepository;
    }

    /** 과제 등록. 멤버가 없으면 null. */
    @Transactional
    public Assignment create(Long memberId, AssignmentCreateRequest request) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            return null;
        }
        Assignment assignment = new Assignment(request.title(), request.description(), member);
        return assignmentRepository.save(assignment);
    }

    /** 멤버별 과제 목록 조회 */
    public List<Assignment> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId);
    }

    /** 단건 조회. 없으면 null. */
    public Assignment findById(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }

    /** 과제 수정. 없으면 null. */
    @Transactional
    public Assignment update(Long id, AssignmentUpdateRequest request) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment == null) {
            return null;
        }
        assignment.updateInfo(request.title(), request.description());
        return assignmentRepository.save(assignment);
    }

    /** 과제 삭제. 없으면 false. (deleteById 는 없는 id 여도 조용히 넘어가서, 먼저 존재 여부를 확인한다) */
    @Transactional
    public boolean delete(Long id) {
        if (!assignmentRepository.existsById(id)) {
            return false;
        }
        assignmentRepository.deleteById(id);
        return true;
    }
}
