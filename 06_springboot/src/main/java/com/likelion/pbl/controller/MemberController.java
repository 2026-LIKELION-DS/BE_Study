package com.likelion.pbl.controller;

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

import com.likelion.pbl.dto.LionCreateRequest;
import com.likelion.pbl.dto.LionResponse;
import com.likelion.pbl.dto.LionUpdateRequest;
import com.likelion.pbl.dto.StaffCreateRequest;
import com.likelion.pbl.dto.StaffResponse;
import com.likelion.pbl.dto.StaffUpdateRequest;
import com.likelion.pbl.role.Lion;
import com.likelion.pbl.role.Role;
import com.likelion.pbl.role.Staff;
import com.likelion.pbl.service.MemberService;

/**
 * 멤버 관리 CRUD API.
 * URI는 명사(members)로만 표현하고, 행위는 HTTP 메서드(POST/GET/PUT/DELETE)로 표현한다.
 * Lion과 Staff는 고유 필드가 달라서 등록/수정 API를 역할별로 나누고,
 * 조회/삭제는 이름 하나로 공통 처리한다.
 */
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    // 생성자가 하나뿐이라 @Autowired 없이도 스프링이 자동으로 주입해준다 (6주차에서 확인한 것과 동일).
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /** POST /members/lions : Lion 등록. 이름 중복이면 409 Conflict. */
    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest request) {
        Lion lion = memberService.createLion(request);
        if (lion == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(LionResponse.from(lion));
    }

    /** POST /members/staffs : Staff 등록. 이름 중복이면 409 Conflict. */
    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest request) {
        Staff staff = memberService.createStaff(request);
        if (staff == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(StaffResponse.from(staff));
    }

    /** GET /members/{name} : 이름으로 단일 멤버 조회. 없으면 404. */
    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name) {
        Role role = memberService.findByName(name);
        if (role == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toResponse(role));
    }

    /** PUT /members/lions/{name} : Lion 정보 수정. 없으면 404. */
    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(
            @PathVariable String name, @RequestBody LionUpdateRequest request) {
        Lion updated = memberService.updateLion(name, request);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LionResponse.from(updated));
    }

    /** PUT /members/staffs/{name} : Staff 정보 수정. 없으면 404. */
    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(
            @PathVariable String name, @RequestBody StaffUpdateRequest request) {
        Staff updated = memberService.updateStaff(name, request);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(StaffResponse.from(updated));
    }

    /** DELETE /members/{name} : 멤버 삭제. 성공하면 204, 없으면 404. */
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        boolean deleted = memberService.deleteMember(name);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    /** 실제 런타임 타입(Lion/Staff)에 맞는 응답 DTO로 변환한다. */
    private Object toResponse(Role role) {
        if (role instanceof Lion lion) {
            return LionResponse.from(lion);
        } else if (role instanceof Staff staff) {
            return StaffResponse.from(staff);
        }
        return null;
    }
}
