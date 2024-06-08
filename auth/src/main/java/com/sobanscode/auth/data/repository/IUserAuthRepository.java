package com.sobanscode.auth.data.repository;


import com.sobanscode.auth.data.entity.AuthTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAuthRepository extends JpaRepository<AuthTable, Long> {
    AuthTable findByUsernameAndPassword(String username, String password);
}