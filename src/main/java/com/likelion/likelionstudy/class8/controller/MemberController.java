package com.likelion.likelionstudy.class8.controller;

import com.likelion.likelionstudy.class8.dto.*;
import com.likelion.likelionstudy.class8.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(@RequestBody LionCreateRequest request) {
        MemberResponse response = memberService.createLion(request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(@RequestBody StaffCreateRequest request) {
        MemberResponse response = memberService.createStaff(request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMemberById(@PathVariable Long id) {
        MemberResponse response = memberService.getMemberById(id);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/lions/{id}")
    public ResponseEntity<MemberResponse> updateLion(
            @PathVariable Long id,
            @RequestBody LionUpdateRequest request
    ) {
        MemberResponse response = memberService.updateLion(id, request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/staffs/{id}")
    public ResponseEntity<MemberResponse> updateStaff(
            @PathVariable Long id,
            @RequestBody StaffUpdateRequest request
    ) {
        MemberResponse response = memberService.updateStaff(id, request);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        boolean deleted = memberService.deleteMember(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }
}