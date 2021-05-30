package KodlamaIO.HRMS.dataAccess.abstracts;

import org.springframework.stereotype.Repository;

import KodlamaIO.HRMS.entities.concretes.CandidateUser;

@Repository
public interface CandidateUserDao extends UserDao<CandidateUser>{
	
	boolean existsByIdentityNumber(String identityNumber);
}
