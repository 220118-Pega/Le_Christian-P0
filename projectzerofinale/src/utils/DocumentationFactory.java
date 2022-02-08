package utils;

import io.javalin.plugin.openapi.dsl.OpenApiBuilder;
import io.javalin.plugin.openapi.dsl.OpenApiDocumentation;
import models.Reimbursement;
import models.Status;

public class DocumentationFactory {

	public static OpenApiDocumentation getDoc(String endPoint) {
		switch(endPoint) {
			case "getReimbursement":
				return OpenApiBuilder.document().operation(op -> {
					op.addTagsItem("Reimbursement");
				}).jsonArray("200", Reimbursement.class);
			case "getReimbursementByID":
				return OpenApiBuilder.document().operation(op -> {
					op.addTagsItem("Reimbursement");
				}).json("200", Reimbursement.class);
			case "addReimbursement":
				return OpenApiBuilder.document().operation(op -> {
					op.addTagsItem("Reimbursement");
				}).body(Reimbursement.class).result("201");
			case "addStatus":
				return OpenApiBuilder.document().operation(op -> {
					op.addTagsItem("Status");
				}).body(Status.class).result("201");
			case "updateStatus":
				return OpenApiBuilder.document().operation(op -> 
				{
					op.addTagsItem("Status");
				}).queryParam("upvote", Integer.class).result("204");
			case "getStatus":
				return OpenApiBuilder.document().operation(op -> {
					op.addTagsItem("Status");
				}).json("200", Status.class);
			default:
				return null;
		}
	}
}
