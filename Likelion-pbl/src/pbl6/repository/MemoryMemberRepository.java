package pbl6.repository;

import org.springframework.stereotype.Repository;

@Repository // 스프링 컨테이너가 Repository 빈으로 자동 등록
public class MemoryMemberRepository implements MemberRepository {
    @Override
    public String getRepositoryName() {
        return "MemoryMemberRepository";
    }
}