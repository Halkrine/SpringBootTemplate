package com.template.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthInterceptor implements HandlerInterceptor{

	private final static Logger log = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		
		//System.out.println("req path: "+req.getServletPath());
		
		/*
		if(req.getSession(false)!=null) {
			System.out.println("session enabled");
			return true;
		} else {
			System.out.println("session disabled");
			if(req.getServletPath().equals("/login/login")) {
			    res.sendRedirect(req.getContextPath()+"/login/login");
			    String userNo = "1010";//temp
			    //HttpSession session = req.getSession(true);
			    //req.getSession(true).setAttribute("userInfo", userNo);
			    return true;//pass contoller
			} else {
				return false;
			}
			
		}*/
		
		//System.out.println("req path: "+req.getServletPath());
		/*
		try {
			HttpSession session = req.getSession(false);
			if(ObjectUtils.isEmpty(session) == true) {
				logger.info("no session");
				session = req.getSession(true);
			}
			String userNo = "1010";
			//userNo = "1015";
			Object strUserNo = session.getAttribute("userInfo");
	
			if(ObjectUtils.isEmpty(strUserNo) == false) {
				userNo = strUserNo.toString();
			}
			session.setAttribute("userInfo", userNo);
	
			logger.info("interceptor id {}", session.getId());
		}catch(Exception e) {
			logger.error("AuthInterceptor",e);
		}*/
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mv) throws Exception {
		//logger.info("postHandle");
		/*try {
			if(req.getSession().getAttribute("userInfo") == null) {
				logger.info("no session for userInfo");
				res.sendRedirect(req.getContextPath()+"/views/login/login.jsp");
			} else {
				logger.info("session for userInfo");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("AuthInterceptor",e);
		}*/
	    
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		//logger.info("afterCompletion");
	}
}
