package cr.tec.struct;

/**
 * Created by joseph on 10/26/16.
 * Class message that works with messages needed for JSON communication
 * 
 */

public class Message {
	public String type;
	public String content;
	public Message(String type, String content) {
		this.type = type;
		this.content = content;
	}
}
