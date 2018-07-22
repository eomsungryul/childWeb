package kr.co.dwebss.child.cmmn;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SessionInterceptor  extends HandlerInterceptorAdapter {
	  
@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		try {
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("authId");
				
			if(id == null ||  id.equals("")){			//로그인 사용자의 정보가 없으면 로그인 페이지로 이동한다.
				response.sendRedirect(request.getContextPath()+"/login");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, 
            HttpServletResponse response, Object handler, ModelAndView modelAndView){
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, 
            HttpServletResponse response, Object handler, Exception ex)  {
    }
}


