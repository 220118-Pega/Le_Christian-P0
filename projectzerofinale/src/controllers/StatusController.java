package controllers;

import java.util.logging.Handler;

import bl.Requests;

public class StatusController implements Controller{

	private Requests requests;
	
	public StatusController(Requests requests) {
		this.requests = requests;
	}
	
	@Override
	public Handler getAll() {
		// TODO Auto-generated method stub
		return ctx -> {
			ctx.jsonStream(requests.getReimbursements());
		};
	}

	@Override
	public Handler getById() {
		// TODO Auto-generated method stub
		return ctx -> {
			String id = ctx.pathParam("reimbursement_ID");
			int actualID = Integer.parseInt(id);
			try {
				ctx.jsonStream(requests.getReimbursementID(actualID));
			}catch(NullPointerException ex) {
				ctx.status(204);
			}
		};
	}

	@Override
	public Handler add() {
		// TODO Auto-generated method stub
		return ctx -> {
			Reimbursement newReimbursement = ctx.bodyStreamAsClass(Reimbursement.class);
			try {
				requests.addReimbursement(newReimbursement);
				ctx.status(201);
			}catch(Exception e) {
				ctx.status(400);
			}
		};
	}

	@Override
	public Handler update() {
		// TODO Auto-generated method stub
		return null;
	}

}
