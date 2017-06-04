package top.softzztiedu.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import top.softzztiedu.exception.ServiceException;
import top.softzztiedu.model.Member;
import top.softzztiedu.result.ResultDO;
import top.softzztiedu.service.UserService;
/**
 * 用户登陆注册
 * @author SongCi
 *
 */
@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping("login")
	public ModelAndView login(Map<String, Object> model,@RequestParam("pwd") String p,@RequestParam("userName") String u,HttpSession session) throws ServiceException{
		String path = null;
		u = u.trim();
		p = p.trim();
		ResultDO resultDo=userService.login(u, p);
		if(resultDo.isSuccess()){
			Member member = (Member)resultDo.getResult();
			session.setAttribute("user",member);
			//path="redirect:.do";
		}else{
			model.put("message","用户名或密码错误");
		}////
		return new ModelAndView(path,model);
		
	}
	

}
