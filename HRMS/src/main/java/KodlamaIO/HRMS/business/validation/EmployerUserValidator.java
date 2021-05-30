package KodlamaIO.HRMS.business.validation;

import org.springframework.stereotype.Component;

import KodlamaIO.HRMS.core.utilities.results.ErrorResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.core.utilities.results.SuccessResult;
import KodlamaIO.HRMS.entities.concretes.EmployerUser;

@Component
public class EmployerUserValidator extends UserValidator implements EmployerUserValidatorService{

	@Override
    public Result employerUserCheckFields(EmployerUser employerUser) {
        String companyName = employerUser.getCompanyName();
        String companyWebsite = employerUser.getCompanyWebsite();
        String phoneNumber = employerUser.getPhoneNumber();

        if(!super.userCheckFields(employerUser).isSuccess() || (companyName == null || companyName.isBlank()) ||
                 (companyWebsite == null || companyWebsite.isBlank()) || (phoneNumber == null || phoneNumber.isBlank())) {
            return new ErrorResult("All fields need to be filled.");
        }
        return new SuccessResult();
    }

	@Override
	public Result isEmailCheck(EmployerUser employerUser) {

		String email = employerUser.getEmail();
        String website = employerUser.getCompanyWebsite();

        String input = website.split("www.")[1];
        if(!(input.equals(email.split("@")[1]))) {
            return new ErrorResult("All fields need to be filled.");
        }
        return new SuccessResult();
	}

}
