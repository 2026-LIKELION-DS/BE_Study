package com.example.pbl_week6.controller;

import com.example.pbl_week6.domain.Member;

import com.example.pbl_week6.service.MemberService;
import com.example.pbl_week6.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 1. Lion 등록
    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(@RequestBody LionCreateRequest req) {
        Member member = memberService.createLion(req);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberResponse.from(member)); // 201
    }

    // 2. Staff 등록
    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(@RequestBody StaffCreateRequest req) {
        Member member = memberService.createStaff(req);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberResponse.from(member)); // 201
    }

    // 3. 전체 멤버 조회
    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        List<MemberResponse> response = memberService.findAll().stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    // 4. ID로 단일 멤버 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable Long id) {
        Member member = memberService.findById(id);
        if (member == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(MemberResponse.from(member)); // 200
    }

    // 5. Lion 수정 (ID 기반)
    @PutMapping("/lions/{id}")
    public ResponseEntity<MemberResponse> updateLion(@PathVariable Long id, @RequestBody LionUpdateRequest req) {
        Member member = memberService.updateLion(id, req);
        if (member == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(MemberResponse.from(member)); // 200
    }

    // 6. Staff 수정 (ID 기반)
    @PutMapping("/staffs/{id}")
    public ResponseEntity<MemberResponse> updateStaff(@PathVariable Long id, @RequestBody StaffUpdateRequest req) {
        Member member = memberService.updateStaff(id, req);
        if (member == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(MemberResponse.from(member)); // 200
    }

    // 7. 멤버 삭제 (ID 기반)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        boolean deleted = memberService.deleteMember(id);
        if (!deleted) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.noContent().build(); // 204
    }
}