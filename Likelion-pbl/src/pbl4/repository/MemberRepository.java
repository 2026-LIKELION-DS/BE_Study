package pbl4.repository;

import pbl4.domain.Member;
import java.util.*;

public class MemberRepository {
    // Step 1: 전체 멤버 저장용 List
    private final List<Member> memberList = new ArrayList<>();

    // Step 2: 파트별 그룹화 저장용 Map (Key: 파트명, Value: 해당 파트 멤버 List)
    private final Map<String, List<Member>> membersByPart = new HashMap<>();

    // 1. 중복 이름 검사 (Step 1)
    public boolean existsByName(String name) {
        for (Member member : memberList) {
            if (member.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // 2. 멤버 등록 (List 및 Map에 동시 추가)
    public void save(Member member) {
        // List에 추가
        memberList.add(member);

        // Map에 파트별로 추가 (Step 2)
        // computeIfAbsent: 해당 키(파트)가 없으면 새 ArrayList 생성 후 추가
        membersByPart.computeIfAbsent(member.getPart(), k -> new ArrayList<>()).add(member);
    }

    // 3. 전체 멤버 조회 (Step 1)
    public List<Member> findAll() {
        return memberList;
    }

    // 4. 이름으로 멤버 검색 (Step 1)
    public Member findByName(String name) {
        for (Member member : memberList) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    // 5. 등록된 모든 파트 목록 조회 (Step 2)
    public Set<String> findAllParts() {
        return membersByPart.keySet();
    }

    // 6. 파트별 멤버 필터링 조회 (Step 2)
    public List<Member> findByPart(String part) {
        return membersByPart.getOrDefault(part, Collections.emptyList());
    }
}