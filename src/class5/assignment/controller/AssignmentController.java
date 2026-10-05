package class5.assignment.controller;

import class5.assignment.domain.Assignment;
import class5.assignment.dto.*;
import class5.assignment.service.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {
    private final AssignmentService service;

    public AssignmentController(AssignmentService service) {
        this.service = service;
    }

    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> create(@PathVariable Long memberId,
                                                     @RequestBody AssignmentCreateRequest request) {
        Assignment assignment = service.create(memberId, request);
        if (assignment == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(AssignmentResponse.from(assignment));
    }

    @GetMapping("/members/{memberId}/assignments")
    public List<AssignmentResponse> findByMemberId(@PathVariable Long memberId) {
        return service.findByMemberId(memberId).stream().map(AssignmentResponse::from).toList();
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> findById(@PathVariable Long id) {
        Assignment assignment = service.findById(id);
        if (assignment == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> update(@PathVariable Long id,
                                                     @RequestBody AssignmentUpdateRequest request) {
        Assignment assignment = service.update(id, request);
        if (assignment == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(AssignmentResponse.from(assignment));
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.delete(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
