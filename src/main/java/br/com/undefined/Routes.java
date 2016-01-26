package br.com.undefined;
import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.halt;
import static spark.Spark.port;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.undefined.model.Campanha;

@ApplicationScoped
public class Routes {
	
	@Inject
	private Campanha campanha;
	
	@PostConstruct
	private void initConfiguration() {
		configuration();
	}
	
	public void start() {
		defaultRoute();
		signIn();
		authenticated();
		routeCampanha();
		System.out.println("CDI started");
	}
	
	private void configuration() {
		port(8080);
		after((request, response) -> {
			response.header("Content-Encoding", "gzip");
		});
	}
	
	/**
	 * Faz a autenticação do usuário para liberar acesso as rotas restritas da API
	 * @author Joaquim Neto
	 */
	private void signIn() {
		get("/sign-in", (request, response) -> {
			String username = request.queryParams("username");
			String password = request.queryParams("password");
			String message = "Not authenticated";
			
			if (username != null && password != null) {
				response.cookie("token", "123456", 120);
				message = "user authenticated";
			}
			
			return message;
		});
	}
	
	/**
	 * Verifying credential the client, if not exist token in cookie request, then stop request
	 * @author Joaquim Neto
	 */
	private void authenticated() {
		before("api/*", (request, response) -> {
			String token = request.cookie("token");
			
			if (token == null || !token.equals("123456")) {
				halt(StatusCode.COD_401);
			}
		});
	}
	
	private void defaultRoute() {
		get("/", (resquest, response) -> {
			return "Welcome Demo Business API";
		});
	}
	
	private void routeCampanha() {
		get("/api/campanha", (request, response) -> {
			
			return "API";
		});
	}
}
