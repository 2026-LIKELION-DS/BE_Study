package pbl5.repository;

import pbl5.domain.Lion;
import pbl5.domain.Member;
import pbl5.domain.Staff;

import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {
    private final List<Member> mockData = new ArrayList<>();

    public MockMemberRepository() {
        // 더미 데이터 초기 세팅 (실제 저장 없이 테스트/확인용)
        mockData.add(new Lion("김테스트", "컴퓨터공학과", 12, "20240001"));
        mockData.add(new Staff("이운영", "소프트웨어학과", 11, "대표"));
    }

    @Override
    public void save(Member member) {
        System.out.println("[MockRepository] 실제 저장하지 않고 로그만 출력합니다: " + member.getName());
    }

    @Override
    public Member findByName(String name) {
        return mockData.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Member> findAll() {
        return mockData;
    }

    @Override
    public boolean existsByName(String name) {
        return mockData.stream().anyMatch(m -> m.getName().equals(name));
    }
}