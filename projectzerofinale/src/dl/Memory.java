package dl;

import java.util.ArrayList;
import java.util.List;

import models.Reimbursement;
import models.Status;

public class Memory implements Storage{
	private static ArrayList<Reimbursement> listOfReimbursements;
	private static int latestID;
	
	public Memory() {
		List<Status> statuses = new ArrayList<Status>() {{
			add(new Status("Pending"));
			add(new Status("Accepted"));
			add(new Status("Rejected"));
		}};
		
		listOfReimbursements = new ArrayList<Reimbursement>() {{
			add(new Reimbursement("Lodging", "Spent the night in a hotel after business", 100));
			add(new Reimbursement("Travel", "Went on a business trip", 500));
			add(new Reimbursement("Food", "Bought dim sum", 20));
		}};
		
		latestID = 3;
	}

	@Override
	public void addReimbursement(Reimbursement newReimbursement) {
		// TODO Auto-generated method stub
		newReimbursement.setId(latestID);
	}

	@Override
	public List<Reimbursement> getReimbursements() {
		// TODO Auto-generated method stub
		return listOfReimbursements;
	}

	@Override
	public Reimbursement getReimbursementID(int id) throws Exception {
		// TODO Auto-generated method stub
		Reimbursement foundReimbursement = null;
		for(Reimbursement reimbursement:listOfReimbursements) {
			if(reimbursement.getId() == id) {
				foundReimbursement = reimbursement;
			}
		}
		
		if(foundReimbursement == null) {
			throw new Exception("Reimbursement request cannot be found");
		}
		
		return foundReimbursement;
	}

	@Override
	public void addStatus(Status newStatus) throws Exception {
		// TODO Auto-generated method stub
		Reimbursement reimbursementUpdate = getReimbursementID(newStatus.getId());
		List<Status> existingStatuses = reimbursementUpdate.getStatuses();
		if(existingStatuses == null) {
			existingStatuses = new ArrayList<Status>();
		}
		existingStatuses.add(newStatus);
		reimbursementUpdate.setStatuses(existingStatuses);
	}

	@Override
	public void updateStatus(Status updatedStatus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Status getStatusByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

