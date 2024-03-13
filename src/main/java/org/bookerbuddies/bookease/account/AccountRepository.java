package org.bookerbuddies.bookease.account;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
   Account findByAccountId(Integer accountId);

}
