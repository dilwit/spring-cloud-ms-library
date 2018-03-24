package net.dilwit.spring.ms.library.member.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.dilwit.spring.ms.library.member.domain.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long>{

}
