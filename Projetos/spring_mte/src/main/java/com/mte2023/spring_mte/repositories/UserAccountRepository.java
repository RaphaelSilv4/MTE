package com.mte2023.spring_mte.repositories;

import com.mte2023.spring_mte.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount,Integer> {

}
