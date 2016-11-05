package cr.tec.utils;

import cr.tec.struct.Message;
import cr.tec.struct.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jose4j.json.internal.json_simple.JSONObject;

import java.io.IOException;

/**
 * Created by joseph on 11/5/16.
 */
public class FirebaseManager {

	private static String FCM_API_KEY = "AIzaSyCVjZwj4FRbc4SIcZnqLTyiYZfQciezgzA";

	public static Message postNotification(String title, String content, User user) throws IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("https://fcm.googleapis.com/fcm/send");
		post.setHeader("Content-type", "application/json");
		post.setHeader("Authorization", "key=" + FCM_API_KEY);
		JSONObject message = new JSONObject();
		message.put("to", user.getFirebaseToken());
		message.put("priority", "high");
		JSONObject notification = new JSONObject();
		notification.put("title", title);
		notification.put("body", content);
		message.put("notification", notification);
		post.setEntity(new StringEntity(message.toString(), "UTF-8"));
		HttpResponse response = client.execute(post);

		System.out.println("Firebase replied: " + response.toString());
		return new Message("firebase", response.toString());
	}

	public static Message postChat(String msg, User user) throws IOException {
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
		data.put("name", user.getName());
		data.put("avatar", user.getAvatar());
		message.put("data", data);
		post.setEntity(new StringEntity(message.toString(), "UTF-8"));
		HttpResponse response = client.execute(post);

		return new Message("firebase", response.toString());
	}
}
