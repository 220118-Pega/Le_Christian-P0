package models;

public class Status {

	private int id;
	private String type;
	private int reimbursementID;
	private int accept;
	private int reject;
	
	
	public Status(String type) {
		this.type = type;
	}
	
	public Status(int id, String type) {
		this.id = id;
		this.type = type;
	}
	
	public Status(int id, String type, int reimbursementID) {
		this.id = id;
		this.type = type;
		this.reimbursementID = reimbursementID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", type=" + type + "]";
	}

	public int getReimbursementID() {
		return reimbursementID;
	}

	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}

	public int getAccept() {
		return accept;
	}

	public void setAccept(int accept) {
		this.accept = accept;
	}

	public int getReject() {
		return reject;
	}

	public void setReject(int reject) {
		this.reject = reject;
	}
}
