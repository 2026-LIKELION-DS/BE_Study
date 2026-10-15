package class5.assignment.service;

import class5.assignment.domain.Assignment;
import class5.assignment.dto.AssignmentCreateRequest;
import class5.assignment.dto.AssignmentUpdateRequest;
import class5.assignment.repository.AssignmentRepository;
import class5.member.domain.Member;
import class5.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, MemberRepository memberRepository) {
        this.assignmentRepository = assignmentRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Assignment create(Long memberId, AssignmentCreateRequest request) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) return null;
        return assignmentRepository.save(new Assignment(request.title(), request.description(), member));
    }

    public List<Assignment> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId);
    }

    public Assignment findById(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Assignment update(Long id, AssignmentUpdateRequest request) {
        Assignment assignment = findById(id);
        if (assignment == null) return null;
        assignment.updateInfo(request.title(), request.description());
        return assignmentRepository.save(assignment);
    }

    @Transactional
    public boolean delete(Long id) {
        if (!assignmentRepository.existsById(id)) return false;
        assignmentRepository.deleteById(id);
        return true;
    }
}
