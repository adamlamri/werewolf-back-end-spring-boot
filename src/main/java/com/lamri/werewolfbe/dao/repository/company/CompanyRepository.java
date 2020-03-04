package com.lamri.werewolfbe.dao.repository.company;

import com.lamri.werewolfbe.dao.entity.company.Company;
import com.lamri.werewolfbe.dao.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Transactional(readOnly = true)
    List<Company> findAllByUserAndDeletedIsFalse(User user);

}
