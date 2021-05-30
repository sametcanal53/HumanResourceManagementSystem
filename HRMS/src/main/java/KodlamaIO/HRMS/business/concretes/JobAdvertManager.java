package KodlamaIO.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIO.HRMS.business.abstracts.JobAdvertService;
import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.ErrorResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.core.utilities.results.SuccessDataResult;
import KodlamaIO.HRMS.core.utilities.results.SuccessResult;
import KodlamaIO.HRMS.dataAccess.abstracts.JobAdvertDao;
import KodlamaIO.HRMS.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{

	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll(),"Job adverts listed");
	}

	@Override
	public DataResult<List<JobAdvert>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getByIsActiveTrue(),"All active job adverts listed");
	}
	
	@Override
    public DataResult<List<JobAdvert>> findByIsActiveTrueOrderByPublishDateDesc() {
        return new SuccessDataResult<List<JobAdvert>>
        (this.jobAdvertDao.findByIsActiveTrueOrderByPublishDateDesc(),"All active job adverts listed by publish date");
    }

	@Override
	public DataResult<List<JobAdvert>> getByIsActiveAndEmployerCompany(int id) {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findByIsActiveAndEmployerCompany(id),"All jobs for this company listed");
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Job advert added");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Job advert updated");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertDao.deleteById(id);
		return new SuccessResult("Job advert deleted");
	}
	
	@Override
	public Result isActiveChange(int id) {
		 	JobAdvert job=this.jobAdvertDao.getById(id);
		 	if(job.isActive() == false) {
		 		return new ErrorResult("This job advert already inactive");
		 	}
	        job.setActive(false);
	        update(job);
	        return new SuccessResult("Job advert deactivated");
	    }
}
