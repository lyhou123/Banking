package org.pratice.banking.feature.user.userepository;
import jakarta.transaction.Transactional;
import org.pratice.banking.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.isDeleted = :status WHERE u.id = :userId")
    int updateDeletedStatusById(String userId, boolean status);
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.isBlocked = :status WHERE u.id = :userId")
    int updateBlockedStatusById(String userId, boolean status);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
