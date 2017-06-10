package top.softzztiedu.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.softzztiedu.exception.ServiceException;
import top.softzztiedu.model.Order;
import top.softzztiedu.result.ResultDO;
import top.softzztiedu.result.SeckillResult;
import top.softzztiedu.service.BusinessService;
import top.softzztiedu.service.CommodityService;

@Controller
@RequestMapping("/buy/")
public class seckillTestController<T> {
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private BusinessService businessService;
	@RequestMapping("test")
	public String test(){
		return "test";
	}
	
	@RequestMapping("confirm_order")
	
	public  @ResponseBody Map  confirm_order(Map<String, Object> map,@RequestParam("address") String address,
			@RequestParam("buyer_id") Integer buyer_id,@RequestParam("item_id") Integer item_id,
			@RequestParam("quantity") Integer quantity) throws ServiceException, IOException{
	    System.out.println("address:"+address);
	    System.out.println("buyer_id:"+buyer_id);
	    System.out.println("item_id:"+item_id);
	    System.out.println("quantity:"+quantity);
	    Order order=new Order();
	    order.setAddess(address);
	    order.setBuyersId(buyer_id);
	    order.setCommodityid(item_id);
	    order.setQuantum(quantity);
	    ResultDO resultDo=businessService.addOrder(order);
	    if(resultDo.isSuccess()){
	    	SeckillResult result =new SeckillResult(new Integer(1), buyer_id, item_id, null, null);
	    	map.put("result", result);
	    	return map;
	    	
	    }else{
	    	return null;
	    }
		
		
	}
	

}
