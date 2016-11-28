package g53sqm.chat.client.servermessage;

public class Message {
	
	ResultCode code;
	String message;
	
	public Message(ResultCode code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public ResultCode getResultCode(){
		return code;
	}
	
	public String getMessage(){
		return message;
	}
}
