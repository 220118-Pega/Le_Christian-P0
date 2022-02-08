package utils;

import controllers.Controller;
import io.javalin.Javalin;
import io.javalin.plugin.openapi.dsl.OpenApiBuilder;

public class Router {

	private Javalin app;
	private Controller RequestController;
	private Controller StatusController;
	
	public Router(Javalin app, Controller RequestController, Controller StatusController) {
		this.app = app;
		this.RequestController = RequestController;
		this.StatusController = StatusController;
	}
	
	public void setUpEndPoints() {
		app.get("/Reimbursements", OpenApiBuilder.documented(DocumentationFactory.getDoc("getReimbursements"), RequestController.getAll()));
		app.get("/Reimbursements/{Reimbursement_ID}/Statuses",  OpenApiBuilder.documented(DocumentationFactory.getDoc("getReimbursementID"), RequestController.getById()));
		app.post("/Reimbursements",  OpenApiBuilder.documented(DocumentationFactory.getDoc("addReimbursement"), RequestController.add()));
		app.post("/Statuses", OpenApiBuilder.documented(DocumentationFactory.getDoc("addStatus"), StatusController.add()));
		app.put("/Statuses/{Status_ID}", OpenApiBuilder.documented(DocumentationFactory.getDoc("updateStatus"), StatusController.update()));
		app.get("/Statuses/{Status_ID}", OpenApiBuilder.documented(DocumentationFactory.getDoc("getStatus"), StatusController.getById()));
	}
}
