package com.scaler.bookmyshowfeb23.repository;

import com.scaler.bookmyshowfeb23.models.User;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllById(List<Long> userIds);

    @Override
    Optional<User> findById(Long userId);
}
