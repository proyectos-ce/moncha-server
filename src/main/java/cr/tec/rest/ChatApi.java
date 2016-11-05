package cr.tec.rest;

import cr.tec.struct.Message;
import cr.tec.utils.security.JWTPrincipal;
import cr.tec.utils.security.Secured;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jose4j.json.internal.json_simple.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * Created by joseph on 11/4/16.
 */
@Path( "/chat" )
public class ChatApi {

	private static String FCM_API_KEY = "AIzaSyCVjZwj4FRbc4SIcZnqLTyiYZfQciezgzA";

	@Context
	protected SecurityContext securityContext;

	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.TEXT_PLAIN})
	@Secured
	public Message postMessage(String msg) throws IOException {

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("https://fcm.googleapis.com/fcm/send");
		post.setHeader("Content-type", "application/json");
		post.setHeader("Authorization", "key=" + FCM_API_KEY);
		JSONObject message = new JSONObject();
		message.put("to", "/topics/chat");
		message.put("priority", "high");
		JSONObject notification = new JSONObject();
		notification.put("title", "chat");
		notification.put("body", msg);
		message.put("notification", notification);
		JSONObject data = new JSONObject();
		data.put("name", getUser().getUserData().getName());
		data.put("avatar", getUser().getUserData().getAvatar());
		message.put("data", data);
		post.setEntity(new StringEntity(message.toString(), "UTF-8"));
		HttpResponse response = client.execute(post);

		return new Message("firebase", response.toString());
	}

	private JWTPrincipal getUser() {
		return (JWTPrincipal) securityContext.getUserPrincipal();
	}

}
