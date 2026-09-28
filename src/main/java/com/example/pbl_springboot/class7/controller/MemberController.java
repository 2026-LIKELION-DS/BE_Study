package com.example.pbl_springboot.class7.controller;

import com.example.pbl_springboot.class7.dto.LionCreateRequest;
import com.example.pbl_springboot.class7.dto.LionResponse;
import com.example.pbl_springboot.class7.dto.LionUpdateRequest;
import com.example.pbl_springboot.class7.dto.StaffCreateRequest;
import com.example.pbl_springboot.class7.dto.StaffResponse;
import com.example.pbl_springboot.class7.dto.StaffUpdateRequest;
import com.example.pbl_springboot.class7.role.Lion;
import com.example.pbl_springboot.class7.role.Member;
import com.example.pbl_springboot.class7.role.Staff;
import com.example.pbl_springboot.class7.service.MemberService;

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

    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(
            @RequestBody LionCreateRequest request
    ) {

        Lion lion = memberService.createLion(request);

        if (lion == null) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(LionResponse.from(lion));
    }

    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(
            @RequestBody StaffCreateRequest request
    ) {

        Staff staff = memberService.createStaff(request);

        if (staff == null) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(StaffResponse.from(staff));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(
            @PathVariable String name
    ) {

        Member member = memberService.findMemberByName(name);

        if (member == null) {
            return ResponseEntity.notFound().build();
        }

        if (member instanceof Lion lion) {
            return ResponseEntity.ok(
                    LionResponse.from(lion)
            );
        }

        if (member instanceof Staff staff) {
            return ResponseEntity.ok(
                    StaffResponse.from(staff)
            );
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(
            @PathVariable String name,
            @RequestBody LionUpdateRequest request
    ) {

        Lion lion =
                memberService.updateLion(name, request);

        if (lion == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                LionResponse.from(lion)
        );
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(
            @PathVariable String name,
            @RequestBody StaffUpdateRequest request
    ) {

        Staff staff =
                memberService.updateStaff(name, request);

        if (staff == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                StaffResponse.from(staff)
        );
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(
            @PathVariable String name
    ) {

        boolean deleted =
                memberService.deleteMember(name);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}