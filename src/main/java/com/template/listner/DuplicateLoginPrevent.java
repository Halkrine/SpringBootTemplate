package com.template.listner;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.stereotype.Component;

@Component("DuplicateLoginPrevent")
public class DuplicateLoginPrevent implements HttpSessionBindingListener {
	
	private static DuplicateLoginPrevent duplicateLoginPrevent = null;
	
	private static Hashtable userList = new Hashtable();
	
	public static synchronized DuplicateLoginPrevent getInstance(){
		if(duplicateLoginPrevent == null){
			duplicateLoginPrevent = new DuplicateLoginPrevent();
		}
		return duplicateLoginPrevent;
	}
	
	public boolean isLogin(String sessionID) {
		boolean isLogin = false;
		Enumeration e = userList.keys();
		String key = "";
		while(e.hasMoreElements()) {
			key = (String)e.nextElement();
			if(sessionID.equals(key)) {
				isLogin = true;
			}
		}
		
		return isLogin;
	}
	
	public boolean isUsing(String userID, HttpSession session) {
		boolean isUsing = false;
		Enumeration e = userList.keys();
		String key = "";
		while(e.hasMoreElements()) {
			key = (String)e.nextElement();
			if(key.equals(session.getId()) && userID.equals(userList.get(key))) {
				isUsing = true;
			}
		}
		
		return isUsing;
	}
	
	public void setSession(HttpSession session, String userID) {
		userList.put(session.getId(), userID);
		
		System.out.println("user list " + userList);
	}	

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("valueBound "+event.getSession().getId());		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("valueUnBound "+event.getSession().getId());
	}
	
	public void removeLoginInfo(HttpSession session, String userID) {
//		Iterator<Map.Entry<String, String>> itr = userList.entrySet().iterator();
//		String sessionId = session.getId();
//		
//		while(itr.hasNext()) {
//			Map.Entry<String, String> data = itr.next();
//			System.out.println("data =====> "+data);
//			if(data.getValue().trim().equals(userID)) {
//				System.out.println(data);
//				userList.remove(data.getKey());
//				System.out.println("user lit " + userList);
//				return;
//			}
//		}
	}
	
	public Hashtable getUserList() {
		return userList;
	}

}
