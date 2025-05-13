package com.wipro.property_management.repository;

import com.wipro.property_management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserEmailAndPassword(String email, String password);
    Optional<UserEntity> findByUserEmail(String email);


}
