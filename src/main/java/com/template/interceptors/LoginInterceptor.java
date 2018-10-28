package com.template.interceptors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.template.listner.DuplicateLoginPrevent;

public class LoginInterceptor implements HandlerInterceptor {
	
	private String[] permittedURL;
	private String ENCODE = "UTF-8";
	
	@Resource
	private DuplicateLoginPrevent duplicate = DuplicateLoginPrevent.getInstance();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//for unlimited redirection 
		String requestUrl = request.getRequestURL().toString();
		if(requestUrl.contains("/login/login")){
			return true;
		}
		
		HttpSession session = request.getSession(false);
		if(session == null) {
			System.out.println("Interceptor session null");
			response.sendRedirect(request.getContextPath()+"/login/login");
			return false;
		}
//		UserInfo userInfo = (UserInfo)session.getAttribute("UserInfo");
//		if(userInfo==null) {
//			System.out.println("Interceptor userInfo null");
//			response.sendRedirect(request.getContextPath()+"/login/login");
//			return false;
//		} else {
//			return duplicationLoginPrevent(session, userInfo, request, response);
//		}
//		
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		/*HttpSession session = request.getSession(false);
		if(session!=null) {
			UserInfo userInfo = (UserInfo)session.getAttribute("UserInfo");
			if(userInfo!=null)
				duplicationLoginPrevent(session, userInfo, request, response);
		}*/
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
//	
//	public boolean duplicationLoginPrevent(HttpSession session, UserInfo userInfo, HttpServletRequest request, HttpServletResponse response) throws IOException {
//		
//		if(duplicate==null) {
//			System.out.println("duplication NULL Return!");
//			return true;
//		}
//		System.out.println("duplicate userList= "+duplicate.getUserList());
//		
//		Hashtable loginUsers = duplicate.getUserList();
//		Iterator<Map.Entry<String, String>> itr = loginUsers.entrySet().iterator();
//		String compareSessionId = session.getId();
//		String loginId = userInfo.getUserId();
//		String compareLoginId = "";
//		boolean result = false;
//		
//		while(itr.hasNext()) {
//			Map.Entry<String, String> user = itr.next();
//			
//			compareLoginId = user.getValue();
//			if(compareSessionId.equals(user.getKey().trim())) {
//				result = true;
//				System.out.println("duplication result= "+result);
//				return result;
//			}
//		}
//		
//		System.out.println("duplication result= "+result);
//		
//		if(!result) {//If login info is empty, remove info
//			HttpSession reSession = request.getSession(false);
//			reSession.setAttribute("param", "multilogin");
//			request.setAttribute("param", "mutlilogin");
//			System.out.println("multi login send redirect");
//			String value ="multilogin";
//			response.sendRedirect(request.getContextPath()+"/login/login?param=multilogin");
//		}
//		
//		return result;
//	}

}
