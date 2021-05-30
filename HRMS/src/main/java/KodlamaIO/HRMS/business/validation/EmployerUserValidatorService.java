package KodlamaIO.HRMS.business.validation;

import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.entities.concretes.EmployerUser;

public interface EmployerUserValidatorService {
	Result employerUserCheckFields(EmployerUser employerUser);
	Result isEmailCheck(EmployerUser employerUser);

}
