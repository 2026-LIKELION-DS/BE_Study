package com.likelion.likelionstudy.class6.controller;

import com.likelion.likelionstudy.class6.dto.LionRegisterRequest;
import com.likelion.likelionstudy.class6.dto.MemberResponse;
import com.likelion.likelionstudy.class6.dto.MemberUpdateRequest;
import com.likelion.likelionstudy.class6.dto.StaffRegisterRequest;
import com.likelion.likelionstudy.class6.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lion")
    public ResponseEntity<MemberResponse> registerLion(@RequestBody LionRegisterRequest request) {
        MemberResponse response = memberService.registerLion(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/staff")
    public ResponseEntity<MemberResponse> registerStaff(@RequestBody StaffRegisterRequest request) {
        MemberResponse response = memberService.registerStaff(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        List<MemberResponse> response = memberService.getAllMembers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMemberById(@PathVariable Long id) {
        MemberResponse response = memberService.getMemberById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable Long id, @RequestBody MemberUpdateRequest request) {
        MemberResponse response = memberService.updateMember(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }
}