package com.lielion.PBL.member.controller;

import java.util.List;

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

import com.lielion.PBL.member.domain.Member;
import com.lielion.PBL.member.dto.LionCreateRequest;
import com.lielion.PBL.member.dto.LionUpdateRequest;
import com.lielion.PBL.member.dto.MemberResponse;
import com.lielion.PBL.member.dto.StaffCreateRequest;
import com.lielion.PBL.member.dto.StaffUpdateRequest;
import com.lielion.PBL.member.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /** POST /members/lions : Lion 등록. 이름 중복이면 409. */
    @PostMapping("/lions")
    public ResponseEntity<MemberResponse> createLion(@RequestBody LionCreateRequest request) {
        Member member = memberService.createLion(request);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberResponse.from(member));
    }

    /** POST /members/staffs : Staff 등록. 이름 중복이면 409. */
    @PostMapping("/staffs")
    public ResponseEntity<MemberResponse> createStaff(@RequestBody StaffCreateRequest request) {
        Member member = memberService.createStaff(request);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberResponse.from(member));
    }

    /** GET /members : 전체 멤버 조회 */
    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        List<MemberResponse> responses = memberService.findAll().stream()
                .map(MemberResponse::from)
                .toList();
        return ResponseEntity.ok(responses);
    }

    /** GET /members/{id} : 멤버 단건 조회. 없으면 404. */
    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable Long id) {
        Member member = memberService.findById(id);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MemberResponse.from(member));
    }

    /** PUT /members/lions/{id} : Lion 수정. 없으면 404. */
    @PutMapping("/lions/{id}")
    public ResponseEntity<MemberResponse> updateLion(
            @PathVariable Long id, @RequestBody LionUpdateRequest request) {
        Member updated = memberService.updateLion(id, request);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MemberResponse.from(updated));
    }

    /** PUT /members/staffs/{id} : Staff 수정. 없으면 404. */
    @PutMapping("/staffs/{id}")
    public ResponseEntity<MemberResponse> updateStaff(
            @PathVariable Long id, @RequestBody StaffUpdateRequest request) {
        Member updated = memberService.updateStaff(id, request);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MemberResponse.from(updated));
    }

    /** DELETE /members/{id} : 삭제. 성공 204, 없으면 404. */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        boolean deleted = memberService.deleteMember(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
