package top.softzztiedu.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.topone.entry.Commodity;

import top.softzztiedu.exception.ServiceException;
import top.softzztiedu.model.Member;
import top.softzztiedu.result.ResultDO;
import top.softzztiedu.service.CommodityService;
/**
 * 用户登陆注册
 * @author SongCi
 *
 */
@Controller
@RequestMapping("/")
public class CommodityController {
	@Autowired
	private CommodityService commodityservice;
	@RequestMapping("list")
	public ModelAndView list(Map<String, Object> model) throws ServiceException{
		String path ="list";
		ResultDO resultDO=commodityservice.getAllCommodityList(1, 2, true);
		if(resultDO.isSuccess()){
			model.put("list", resultDO.getResult());		
			return new ModelAndView(path,model);
		}else{
			return new ModelAndView(path,null);
		}
		}
	@RequestMapping("add")
	public ModelAndView add(Commodity commodity, Map<String, Object> model) throws ServiceException{
		String path ="store";
		ResultDO resultDO=commodityservice.addCommodity(commodity);
		if(resultDO.isSuccess()){
			model.put("message","商品添加成功");		
			return new ModelAndView(path,model);
		}else{
			model.put("message","商品添加失败");		
			return new ModelAndView(path,model);
		}
		}	
	
	@RequestMapping("detail")
	public ModelAndView detail(Commodity commodity, Map<String, Object> model) throws ServiceException{
		String path ="detail";
		ResultDO resultDO=commodityservice.getcommodityInfo(commodity);
		if(resultDO.isSuccess()){
			model.put("info",resultDO.getResult());		
			return new ModelAndView(path,model);
		}else{
			return new ModelAndView(path,null);
		}
		}	
	
	@RequestMapping("mystore")
	public ModelAndView getmystore(Map<String, Object> model,HttpSession session) throws ServiceException{
		String path ="list";
		Member m= (Member) session.getAttribute("user");
		ResultDO resultDO=commodityservice.getMyStoreList(m.getId());
		if(resultDO.isSuccess()){
			model.put("list", resultDO.getResult());		
			return new ModelAndView(path,model);
		}else{
			return new ModelAndView(path,null);
		}
		}
	@RequestMapping("shoppingcar")
	public ModelAndView shoppingcar(Map<String, Object> model,HttpSession session) throws ServiceException{
		String path ="list";
		Member m= (Member) session.getAttribute("user");
		ResultDO resultDO=commodityservice.getMyShoppingCartList(m.getId());
		if(resultDO.isSuccess()){
			model.put("list", resultDO.getResult());		
			return new ModelAndView(path,model);
		}else{
			return new ModelAndView(path,null);
		}
		}
	@RequestMapping("buy")
	public ModelAndView buy(Map<String, Object> model,HttpSession session) throws ServiceException{
		String path ="list";
		Member m= (Member) session.getAttribute("user");
		ResultDO resultDO=commodityservice.getMyShoppingCartList(m.getId());
		if(resultDO.isSuccess()){
			model.put("list", resultDO.getResult());		
			return new ModelAndView(path,model);
		}else{
			return new ModelAndView(path,null);
		}
		}
	
	
}
