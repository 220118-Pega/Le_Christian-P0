package models;

import java.util.List;

public class Reimbursement {
	
	private String type;
	private String description;
	private int amount;
	private int id;
	private List<Status> statuses;
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(String type, String description, int amount) {
		this.type = type;
		this.description = description;
		this.amount = amount;
	}
	
	public Reimbursement(String type, String description, int amount, int id) {
		this.type = type;
		this.description = description;
		this.amount = amount;
		this.id =id;
	}
	
	public Reimbursement(String type, String description, int amount, int id, List<Status> statuses) {
		this.type = type;
		this.description = description;
		this.amount = amount;
		this.id =id;
		this.statuses = statuses;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	@Override
	public String toString() {
		return "Reimbursement [type=" + type + ", description=" + description + ", amount="
				+ amount + ", id=" + id + "]";
	}
}
