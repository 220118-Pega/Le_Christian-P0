package controllers;

import java.util.logging.Handler;

public interface Controller {
	Handler getAll();
	Handler getById();
	Handler add();
	Handler update();
}
