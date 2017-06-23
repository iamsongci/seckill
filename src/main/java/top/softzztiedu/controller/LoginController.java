package top.softzztiedu.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		String path ="login";
		u = u.trim();
		p = p.trim();
		ResultDO resultDo=userService.login(u, p);
		if(resultDo.isSuccess()){
			Member member = (Member)resultDo.getResult();
			session.setAttribute("user",member);
			//path="redirect:.do";
		}else{
			model.put("message","用户名或密码错误");
		}
		return new ModelAndView(path,model);
	}
	@RequestMapping("signup")
	public ModelAndView signup(Map<String, Object> model,@RequestParam("pwd") String p,@RequestParam("userName") String u,@RequestParam("isSeller") String IsSeller,@RequestParam("storeName") String store ,HttpSession session) throws ServiceException{
		String path ="signup";
		u = u.trim();
		p = p.trim();
		IsSeller=IsSeller.trim();
		store=store.trim();
		Member m=new Member();
		m.setName(u);
		m.setPasswd(p);
		m.setSellerState(Integer.parseInt(IsSeller));
		m.setShopName(store);
		ResultDO resultDo=userService.register(m);
		if(resultDo.isSuccess()){
			session.setAttribute("user",m);
			//path="redirect:.do";
		}else{
			model.put("message","请重新注册");
		}
		return new ModelAndView(path,model);		
	}

}
