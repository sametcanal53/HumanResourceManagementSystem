package KodlamaIO.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIO.HRMS.business.abstracts.JobService;
import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.ErrorResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.core.utilities.results.SuccessDataResult;
import KodlamaIO.HRMS.core.utilities.results.SuccessResult;
import KodlamaIO.HRMS.dataAccess.abstracts.JobDao;
import KodlamaIO.HRMS.entities.concretes.Job;

@Service
public class JobManager implements JobService{

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>
		(this.jobDao.findAll(),"Jobs listed");
	}

	@Override
	public Result add(Job job) {
		
		if(this.findByPosition(job.getPosition()).getData().size() != 0) {
			return new ErrorResult("This job position already exists ");
		}
		this.jobDao.save(job);
		return new SuccessResult("Job added");
	}

	@Override
	public DataResult<List<Job>> findByPosition(String position) {
		return new SuccessDataResult<List<Job>>(this.jobDao.findByPosition(position));
	}


}
