package kr.co.dwebss.child.web;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import kr.co.dwebss.child.core.Result;
import kr.co.dwebss.child.core.ResultGenerator;
import kr.co.dwebss.child.model.Center;
import kr.co.dwebss.child.model.User;
import kr.co.dwebss.child.service.CenterService;
import kr.co.dwebss.child.service.UserService;

/**
* Created by 엄성렬 on 2018/07/20.
*/
@RestController
public class LoginController {
	
   @Resource
   private UserService userService;

   @Resource
   private CenterService centerService;

   /** 로그인 */
   @RequestMapping("/loginAction") 
   public Result loginAction(
   		HttpServletRequest request
   		,User vo
   		) throws Exception {  
	   
  	 	User login  = userService.selectUser(vo);
  	 	Map<String, Object> res = new HashMap<>();
   	if( login == null ){
       	//실패후 쿼리 
       	// 아이디 조회후 return 
   		res.put("state",false);
       	
   	}else{ // 조회성공
   		res.put("id",login.getUserId());
   		res.put("userRoleCode",login.getUserRoleCd());
   		res.put("state",true);
			HttpSession session = request.getSession();
			session.setAttribute("id",login.getUserId());
			session.setAttribute("userRoleCode",login.getUserRoleCd());
   	}
		//비밀번호를 리턴하지않게함
//		vo.setUserPassword("");

      return ResultGenerator.genSuccessResult(res);
   }

    @RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, ModelMap model){
    	ModelAndView mav = new ModelAndView("/login");
		HttpSession session = request.getSession();
		session.invalidate();
		return mav;
	}
    
    @RequestMapping("/findUser")
    public Result findUser(
       		HttpServletRequest request,User user){
    	
    	User userRes  =userService.selectUser(user);
  	 	Map<String, Object> res = new HashMap<>();
    	if( userRes == null ){
           	//실패후 쿼리 
           	// 아이디 조회후 return 
    		res.put("state",false);
           	
       	}else{ // 조회성공
       		res.put("state",true);
       	}
    	return ResultGenerator.genSuccessResult(res);
    }
    

    @Transactional(rollbackFor=Exception.class)
    @RequestMapping("/joinAction")
    public Result add(User user) {
    	ModelAndView mav = new ModelAndView("/login");
    	Center center = new Center();
    	center.setCenterNm(user.getCenterNm());
    	center.setCenterAddr(user.getCenterAddr());
    	center.setCenterPhone(user.getCenterPhone());
    	
    	centerService.insertCenter(center);
    	user.setCenterId(center.getCenterId());
        userService.save(user);
        
        return ResultGenerator.genSuccessResult();
    }
	
}
