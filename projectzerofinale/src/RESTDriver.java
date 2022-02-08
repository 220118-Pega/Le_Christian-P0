import java.util.Scanner;

import bl.Request;
import controllers.Controller;
import controllers.RequestController;
import controllers.StatusController;
import dl.DBStorage;
import dl.RequestDAO;
import dl.StatusDAO;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;
import ui.MainMenu;
import utils.Router;

public class RESTDriver {
	
	public static void main(String[] args) {
		Controller RequestController = new RequestController(new Request(new DBStorage(new RequestDAO(), new StatusDAO())));
		Controller StatusController = new StatusController(new Request(new DBStorage(new RequestDAO(), new StatusDAO())));
		
		Javalin app = Javalin.create(config -> {
			config.registerPlugin(new OpenApiPlugin(getOpenApiOptions()));
		}).start(7000);
		Router router = new Router(app, RequestController, StatusController);
		router.setUpEndPoints();
	}
	
	private static OpenApiOptions getOpenApiOptions() {
		Info applicationInfo = new Info().version("1.0.0").description("Requests REST");
		return new OpenApiOptions(applicationInfo).path("/swagger-docs").swagger(new SwaggerOptions("/swagger").title("Requests API Docs"));
	}

}
