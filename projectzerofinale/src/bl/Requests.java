package bl;

import java.util.List;

import models.Reimbursement;
import models.Status;

public interface Requests {
	void addReimbursement(Reimbursement reimbursement);
	
	List<Reimbursement> getReimbursements();
	Reimbursement getReimbursementID(int id) throws Exception;
	void addStatus(Status status) throws Exception;
	void acceptStatus(int id);
	void rejectStatus(int id);

	void updateStatus(Integer StatusID);
	Status getStatusByID(int id);
}
