package g53sqm.chat.client.servermessage;

public class MessageInterpreter {
	public Message interpretServerMessage(String s){
		ResultCode code;
		String message;
		
		if(s.startsWith("OK ")){
			code = ResultCode.OK;
			message = s.substring(3);
		}else if(s.startsWith("BAD" )){
			code = ResultCode.BAD;
			message = s.substring(4);
		}
		else{
			code = ResultCode.UNKNOWN;
			message = s;
		}
		return new Message(code,message);
	}
}
