package com.example.pbl_week6.controller;

import com.example.pbl_week6.dto.*;
import com.example.pbl_week6.role.Lion;
import com.example.pbl_week6.role.Role;
import com.example.pbl_week6.role.Staff;
import com.example.pbl_week6.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 1. Lion 등록 (POST /members/lions)
    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest request) {
        Lion lion = memberService.createLion(request);
        if (lion == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409 Conflict
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(LionResponse.from(lion)); // 201 Created
    }

    // 2. Staff 등록 (POST /members/staffs)
    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest request) {
        Staff staff = memberService.createStaff(request);
        if (staff == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409 Conflict
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(StaffResponse.from(staff)); // 201 Created
    }

    // 3. 단일 멤버 조회 (GET /members/{name})
    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name) {
        Role member = memberService.findMember(name);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
        if (member instanceof Lion) {
            return ResponseEntity.ok(LionResponse.from((Lion) member)); // 200 OK
        } else if (member instanceof Staff) {
            return ResponseEntity.ok(StaffResponse.from((Staff) member)); // 200 OK
        }
        return ResponseEntity.notFound().build();
    }

    // 4. Lion 수정 (PUT /members/lions/{name})
    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(
            @PathVariable String name,
            @RequestBody LionUpdateRequest request) {
        Lion lion = memberService.updateLion(name, request);
        if (lion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
        return ResponseEntity.ok(LionResponse.from(lion)); // 200 OK
    }

    // 5. Staff 수정 (PUT /members/staffs/{name})
    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(
            @PathVariable String name,
            @RequestBody StaffUpdateRequest request) {
        Staff staff = memberService.updateStaff(name, request);
        if (staff == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
        return ResponseEntity.ok(StaffResponse.from(staff)); // 200 OK
    }

    // 6. 멤버 삭제 (DELETE /members/{name})
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        boolean deleted = memberService.deleteMember(name);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
        }
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}