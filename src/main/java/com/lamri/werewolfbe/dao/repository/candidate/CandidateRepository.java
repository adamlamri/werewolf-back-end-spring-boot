package com.lamri.werewolfbe.dao.repository.candidate;

import com.lamri.werewolfbe.dao.entity.candidate.Candidate;
import com.lamri.werewolfbe.dao.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Transactional
    List<Candidate> findAllByUserAndDeletedIsFalse(User user);

    @Transactional
    Candidate findByUserAndCandidateIdAndDeletedIsFalse(User user, Long candidateId);

}
