package com.netlion.pbl.controller;

import com.netlion.pbl.domain.role.Lion;
import com.netlion.pbl.domain.role.Role;
import com.netlion.pbl.domain.role.Staff;
import com.netlion.pbl.dto.*;
import com.netlion.pbl.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest request) {
        Lion lion = memberService.createLion(request);
        if (lion == null) {
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.status(201).body(LionResponse.from(lion));
    }

    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest request) {
        Staff staff = memberService.createStaff(request);
        if (staff == null) {
            return ResponseEntity.status(409).build();
        }
        return ResponseEntity.status(201).body(StaffResponse.from(staff));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name) {
        Role role = memberService.findByName(name);
        if (role == null) {
            return ResponseEntity.notFound().build();
        }
        if (role instanceof Lion lion) {
            return ResponseEntity.ok(LionResponse.from(lion));
        } else if (role instanceof Staff staff) {
            return ResponseEntity.ok(StaffResponse.from(staff));
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(@PathVariable String name, @RequestBody LionUpdateRequest request) {
        Lion updated = memberService.updateLion(name, request);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LionResponse.from(updated));
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(@PathVariable String name, @RequestBody StaffUpdateRequest request) {
        Staff updated = memberService.updateStaff(name, request);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(StaffResponse.from(updated));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        boolean deleted = memberService.deleteMember(name);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
