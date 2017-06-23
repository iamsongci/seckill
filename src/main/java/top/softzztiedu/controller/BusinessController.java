package top.softzztiedu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.topone.entry.Shopping;

import top.softzztiedu.exception.ServiceException;
import top.softzztiedu.model.Member;
import top.softzztiedu.model.Order;
import top.softzztiedu.result.ResultDO;
import top.softzztiedu.service.BusinessService;
/**
 * 用户登陆注册
 * @author SongCi
 *
 */
@Controller
@RequestMapping("/")
public class BusinessController {
	@Autowired
	private BusinessService  businessservice;
	@RequestMapping("topay")
	public ModelAndView topay(Map<String, Object> model,HttpSession session) throws ServiceException{
		String path ="list";
		ArrayList<String> ar=new ArrayList<String>();
		Member m= (Member) session.getAttribute("user");
		List<Order> orderlist=(List<Order>) businessservice.getMyOrderList(m.getId()).getResult();
		for(Order order:(List<Order>)orderlist){
			ResultDO resultDO=businessservice.toPay(order.getBuyersId(),order.getId());
			if(resultDO.isSuccess()){
			ar.add(resultDO.getMessage());	
			}	
		}
		    model.put("list", ar);
			return new ModelAndView(path,model);
		}
	
	@RequestMapping("myorder")
	public ModelAndView order(Map<String, Object> model,HttpSession session) throws ServiceException{
		String path ="list";
		Member m= (Member) session.getAttribute("user");
		ResultDO resultDO=businessservice.getMyOrderList(m.getId());
		if(resultDO.isSuccess()){
			model.put("list", resultDO.getResult());		
			return new ModelAndView(path,model);
		}else{
			return new ModelAndView(path,null);
		}
		}
	
	@RequestMapping("addshoppingcar")
	public ModelAndView addshoppingcar(Shopping shopppig,Map<String, Object> model,HttpSession session) throws ServiceException{
		String path ="list";
		Member m= (Member) session.getAttribute("user");
		ResultDO resultDO=businessservice.addShoppingCart(shopppig);
		if(resultDO.isSuccess()){
			model.put("list", resultDO.getResult());		
			return new ModelAndView(path,model);
		}else{
			return new ModelAndView(path,null);
		}
		}
}
