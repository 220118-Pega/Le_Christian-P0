package bl;

import java.util.List;

import dl.Storage;
import models.Reimbursement;
import models.Status;

public class Request implements Requests{
	
	private Storage storage;
	
	public Request(Storage storage) {
		this.storage = storage;
	}
	
	@Override
	public void addReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		storage.addReimbursement(reimbursement);
	}
	
	@Override
	public List<Reimbursement> getReimbursements() {
		// TODO Auto-generated method stub
		return storage.getReimbursements();
	}
	
	@Override
	public Reimbursement getReimbursementID(int id) throws Exception {
		// TODO Auto-generated method stub
		return storage.getReimbursementID(id);
	}
	
	@Override
	public void addStatus(Status status) throws Exception {
		// TODO Auto-generated method stub
		storage.addStatus(status);
	}

	@Override
	public void updateStatus(Integer StatusID) {
		// TODO Auto-generated method stub
		Status status2Update = storage.getStatusByID(StatusID);
		try {
			storage.updateStatus(status2Update);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Status getStatusByID(int id) {
		// TODO Auto-generated method stub
		return storage.getStatusByID(id);
	}

	@Override
	public void acceptStatus(int id) {
		// TODO Auto-generated method stub
		Status status2Accept = storage.getStatusByID(id);
		int currentAccept = status2Accept.getAccept();
		try {
			status2Accept.setAccept(currentAccept);
			storage.updateStatus(status2Accept);
		}catch(Exception e) {
		e.printStackTrace();
		}
	}

	@Override
	public void rejectStatus(int id) {
		// TODO Auto-generated method stub
		Status status2Reject = storage.getStatusByID(id);
		int currentReject = status2Reject.getReject();
		try {
			status2Reject.setReject(currentReject);
			storage.updateStatus(status2Reject);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
