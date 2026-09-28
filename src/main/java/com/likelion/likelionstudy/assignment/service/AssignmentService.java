package com.likelion.likelionstudy.assignment.service;

import com.likelion.likelionstudy.assignment.domain.Assignment;
import com.likelion.likelionstudy.assignment.dto.AssignmentCreateRequest;
import com.likelion.likelionstudy.assignment.dto.AssignmentResponse;
import com.likelion.likelionstudy.assignment.dto.AssignmentUpdateRequest;
import com.likelion.likelionstudy.assignment.repository.AssignmentRepository;
import com.likelion.likelionstudy.class8.domain.Member;
import com.likelion.likelionstudy.class8.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public AssignmentResponse createAssignment(Long memberId, AssignmentCreateRequest request) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) {
            return null;
        }

        Assignment assignment = new Assignment(request.getTitle(), request.getDescription(), member);
        Assignment saved = assignmentRepository.save(assignment);
        return AssignmentResponse.from(saved);
    }

    public List<AssignmentResponse> getAssignmentsByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId).stream()
                .map(AssignmentResponse::from)
                .toList();
    }

    public AssignmentResponse getAssignmentById(Long id) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment == null) {
            return null;
        }
        return AssignmentResponse.from(assignment);
    }

    @Transactional
    public AssignmentResponse updateAssignment(Long id, AssignmentUpdateRequest request) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment == null) {
            return null;
        }

        assignment.updateInfo(request.getTitle(), request.getDescription());
        return AssignmentResponse.from(assignment);
    }

    @Transactional
    public boolean deleteAssignment(Long id) {
        if (!assignmentRepository.existsById(id)) {
            return false;
        }
        assignmentRepository.deleteById(id);
        return true;
    }
}