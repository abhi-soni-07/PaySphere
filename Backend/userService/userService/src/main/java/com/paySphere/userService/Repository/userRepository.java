package com.paySphere.userService.Repository;

import com.paySphere.userService.Entity.users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<users,Long> {
}
