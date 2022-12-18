package chatt;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatting")
public class WebSocketServer {

	private static Set<Session> clients =  
		Collections.synchronizedSet(new HashSet<Session>());
		//Set이 저장할 수 있는 데이터 유형은 Session 한 가지로 고정시킨다. + 같은 객체를 사용할 수 없음 (여기선 clients는 1개만)
		//private로 선언된 요소는 클래스 안쪽에서만 사용 가능 + public으로 선언한 요소는 아무나 사용 가능
		//static: 초기화는 1번밖에 안됨, 모든 클래스가 접근해서 사용할 수 있는 공통변수
		//SynchronizedSet 들어온 순서대로 처리하겠다.
	@OnOpen
	public void onOpen(Session s) {
		System.out.println("session open....");
		clients.add(s);
	}
	@OnClose
	public void onClose(Session s) {
		System.out.println("session close....");
		clients.remove(s);
	}public WebSocketServer() {
		// TODO Auto-generated constructor stub
	}
	@OnMessage
	public void onMessage(String msg, Session s) throws IOException {
		System.out.println("message : " + msg);
		for(Session ss : clients) {
			ss.getBasicRemote().sendText(msg);
		}
	}
	
}