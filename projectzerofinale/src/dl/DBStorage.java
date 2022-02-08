package dl;

import java.util.ArrayList;
import java.util.List;

import models.Reimbursement;
import models.Status;

public class DBStorage implements Storage{

	private DAO<Reimbursement, Integer> requestDAO;
	private DAO<Status, Integer> statusDAO;
	
	public DBStorage(DAO<Reimbursement, Integer> requestDAO, DAO<Status, Integer> StatusDAO) {
		this.requestDAO = requestDAO;
	}
	
	@Override
	public void addReimbursement(Reimbursement newReimbursement) {
		// TODO Auto-generated method stub
		requestDAO.add(newReimbursement);
	}

	@Override
	public List<Reimbursement> getReimbursements() {
		return (List<Reimbursement>) requestDAO.findAll();
	}

	@Override
	public Reimbursement getReimbursementID(int id) throws Exception {
		// TODO Auto-generated method stub
		Reimbursement reimbursementWanted = requestDAO.findById(id);
		List<Status> allStatuses = (List<Status>) statusDAO.findAll();
		List<Status> statuses4request = new ArrayList<Status>();
		for(Status stat:allStatuses) {
			if(stat.getReimbursementID() == id) statuses4request.add(stat);
		}
		
		reimbursementWanted.setStatuses(statuses4request);
		
		return reimbursementWanted;
	}
		

	@Override
	public void addStatus(Status newStatus) throws Exception {
		// TODO Auto-generated method stub
		statusDAO.add(newStatus);
	}

	@Override
	public void updateStatus(Status updatedStatus) {
		// TODO Auto-generated method stub
		statusDAO.update(updatedStatus);
	}

	@Override
	public Status getStatusByID(int id) {
		// TODO Auto-generated method stub
		return statusDAO.findById(id);
	}

}
