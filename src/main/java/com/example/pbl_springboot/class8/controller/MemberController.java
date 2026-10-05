package com.example.pbl_springboot.class8.controller;

import com.example.pbl_springboot.class8.domain.Member;
import com.example.pbl_springboot.class8.dto.LionCreateRequest;
import com.example.pbl_springboot.class8.dto.LionUpdateRequest;
import com.example.pbl_springboot.class8.dto.MemberResponse;
import com.example.pbl_springboot.class8.dto.StaffCreateRequest;
import com.example.pbl_springboot.class8.dto.StaffUpdateRequest;
import com.example.pbl_springboot.class8.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(
            @RequestBody LionCreateRequest request
    ) {
        Member member = memberService.createLion(request);

        if (member == null) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MemberResponse.from(member));
    }

    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(
            @RequestBody StaffCreateRequest request
    ) {
        Member member = memberService.createStaff(request);

        if (member == null) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MemberResponse.from(member));
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getMembers() {

        List<MemberResponse> responses = memberService.findAll()
                .stream()
                .map(MemberResponse::from)
                .toList();

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMember(
            @PathVariable("id") Long id
    ) {
        Member member = memberService.findById(id);

        if (member == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(MemberResponse.from(member));
    }

    @PutMapping("/lions/{id}")
    public ResponseEntity<MemberResponse> updateLion(
            @PathVariable("id") Long id,
            @RequestBody LionUpdateRequest request
    ) {
        Member member = memberService.updateLion(id, request);

        if (member == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(MemberResponse.from(member));
    }

    @PutMapping("/staffs/{id}")
    public ResponseEntity<MemberResponse> updateStaff(
            @PathVariable("id") Long id,
            @RequestBody StaffUpdateRequest request
    ) {
        Member member = memberService.updateStaff(id, request);

        if (member == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(MemberResponse.from(member));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(
            @PathVariable("id") Long id
    ) {
        boolean deleted = memberService.deleteMember(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}