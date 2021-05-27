package jp.co.aoterp.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Membersの基本CRUD生成
 * MembersのEntityクラスの同じパッケージ内で管理する必要がある。
 */
public interface MemberRepository extends JpaRepository<Members, Long> {
}
