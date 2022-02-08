package dl;

import java.util.List;

import models.Reimbursement;
import models.Status;

public interface Storage {
	void addReimbursement (Reimbursement newReimbursement);
	List<Reimbursement> getReimbursements();
	Reimbursement getReimbursementID(int id) throws Exception;
	
	void addStatus(Status newStatus) throws Exception;
	void updateStatus( Status updatedStatus);
	Status getStatusByID(int id);
}
