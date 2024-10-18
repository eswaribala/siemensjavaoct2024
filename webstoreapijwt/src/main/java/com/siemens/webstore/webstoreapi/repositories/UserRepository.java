package com.siemens.webstore.webstoreapi.repositories;

import com.siemens.webstore.webstoreapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
