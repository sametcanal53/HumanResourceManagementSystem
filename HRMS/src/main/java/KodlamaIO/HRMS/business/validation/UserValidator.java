package KodlamaIO.HRMS.business.validation;

import KodlamaIO.HRMS.core.utilities.results.ErrorResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.core.utilities.results.SuccessResult;
import KodlamaIO.HRMS.entities.concretes.User;

public abstract class UserValidator {
	
	public Result userCheckFields(User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		
		if((email == null ||  email.isBlank()) || (password==null || password.isBlank())) {
			return new ErrorResult("Lütfen tüm alanları doldurduğunuzdan emin olun.");
        }
		return new SuccessResult();
	}
}
