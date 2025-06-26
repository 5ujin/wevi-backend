package com.wevi.domain.member.respository;

import com.wevi.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
    // 이메일(ID)로 회원 조회
    Optional<Member> findByEmail(String email);
    
    // 이메일 중복 체크
    boolean existsByEmail(String email);
    
    // 로그인 실패 횟수 증가 등을 위해 ID로 조회
    Optional<Member> findById(Long id);
}
