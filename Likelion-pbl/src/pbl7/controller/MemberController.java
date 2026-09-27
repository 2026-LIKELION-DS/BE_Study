package pbl7.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pbl7.domain.Lion;
import pbl7.domain.Member;
import pbl7.domain.Staff;
import pbl7.dto.*;
import pbl7.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 1. Lion 등록 API
    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest request) {
        Lion lion = memberService.createLion(request);
        if (lion == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(LionResponse.from(lion)); // 201
    }

    // 2. Staff 등록 API
    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest request) {
        Staff staff = memberService.createStaff(request);
        if (staff == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(StaffResponse.from(staff)); // 201
    }

    // 3. 단일 멤버 조회 API
    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name) {
        Member member = memberService.findByName(name);
        if (member == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        }
        if (member instanceof Lion lion) {
            return ResponseEntity.ok(LionResponse.from(lion)); // 200
        } else if (member instanceof Staff staff) {
            return ResponseEntity.ok(StaffResponse.from(staff)); // 200
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // 4. Lion 수정 API
    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(
            @PathVariable String name,
            @RequestBody LionUpdateRequest request) {
        Lion lion = memberService.updateLion(name, request);
        if (lion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        }
        return ResponseEntity.ok(LionResponse.from(lion)); // 200
    }

    // 5. Staff 수정 API
    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(
            @PathVariable String name,
            @RequestBody StaffUpdateRequest request) {
        Staff staff = memberService.updateStaff(name, request);
        if (staff == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        }
        return ResponseEntity.ok(StaffResponse.from(staff)); // 200
    }

    // 6. 멤버 삭제 API
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        boolean deleted = memberService.deleteMember(name);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        }
        return ResponseEntity.noContent().build(); // 204
    }
}