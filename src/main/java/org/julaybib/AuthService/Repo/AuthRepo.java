package org.julaybib.AuthService.Repo;

import org.julaybib.AuthService.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}