package com.example.pbl_springboot.class9.assignment.controller;

import com.example.pbl_springboot.class9.assignment.domain.Assignment;
import com.example.pbl_springboot.class9.assignment.dto.AssignmentCreateRequest;
import com.example.pbl_springboot.class9.assignment.dto.AssignmentResponse;
import com.example.pbl_springboot.class9.assignment.dto.AssignmentUpdateRequest;
import com.example.pbl_springboot.class9.assignment.service.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> createAssignment(
            @PathVariable Long memberId,
            @RequestBody AssignmentCreateRequest request
    ) {

        Assignment assignment =
                assignmentService.createAssignment(memberId, request);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(AssignmentResponse.from(assignment));
    }

    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponse>> getAssignmentsByMember(
            @PathVariable Long memberId
    ) {

        List<AssignmentResponse> responses =
                assignmentService.findByMemberId(memberId)
                        .stream()
                        .map(AssignmentResponse::from)
                        .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> getAssignment(
            @PathVariable Long id
    ) {

        Assignment assignment =
                assignmentService.findById(id);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                AssignmentResponse.from(assignment)
        );
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> updateAssignment(
            @PathVariable Long id,
            @RequestBody AssignmentUpdateRequest request
    ) {

        Assignment assignment =
                assignmentService.updateAssignment(id, request);

        if (assignment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                AssignmentResponse.from(assignment)
        );
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> deleteAssignment(
            @PathVariable Long id
    ) {

        boolean deleted =
                assignmentService.deleteAssignment(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}