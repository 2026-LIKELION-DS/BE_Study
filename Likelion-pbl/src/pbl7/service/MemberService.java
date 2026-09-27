package pbl7.service;

import org.springframework.stereotype.Service;
import pbl7.domain.Lion;
import pbl7.domain.Member;
import pbl7.domain.Staff;
import pbl7.dto.LionCreateRequest;
import pbl7.dto.LionUpdateRequest;
import pbl7.dto.StaffCreateRequest;
import pbl7.dto.StaffUpdateRequest;
import pbl7.repository.MemberRepository;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Lion createLion(LionCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }
        Lion lion = new Lion(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );
        memberRepository.save(lion);
        return lion;
    }

    public Staff createStaff(StaffCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            return null;
        }
        Staff staff = new Staff(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getPosition()
        );
        memberRepository.save(staff);
        return staff;
    }

    public Member findByName(String name) {
        return memberRepository.findByName(name);
    }

    public Lion updateLion(String name, LionUpdateRequest request) {
        Member member = memberRepository.findByName(name);
        if (!(member instanceof Lion lion)) {
            return null;
        }
        lion.updateLionInfo(request.getMajor(), request.getGeneration(), request.getPart(), request.getStudentId());
        memberRepository.updateByName(name, lion);
        return lion;
    }

    public Staff updateStaff(String name, StaffUpdateRequest request) {
        Member member = memberRepository.findByName(name);
        if (!(member instanceof Staff staff)) {
            return null;
        }
        staff.updateStaffInfo(request.getMajor(), request.getGeneration(), request.getPart(), request.getPosition());
        memberRepository.updateByName(name, staff);
        return staff;
    }

    public boolean deleteMember(String name) {
        return memberRepository.deleteByName(name);
    }
}