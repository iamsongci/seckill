package top.softzztiedu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.softzztiedu.exception.ServiceException;
import top.softzztiedu.result.ResultDO;
import top.softzztiedu.service.CommodityService;
import top.softzztiedu.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-consumer.xml","classpath:spring-dubbo.xml","classpath:spring-mvc.xml"})
public class test {
	@Autowired
	private  UserService userService; 
	//private  CommodityService commodityService;
	@Test
	public void toLogin() throws ServiceException{
		ResultDO resultDO = userService.login("xiaolong", "123456");
		if(resultDO.isSuccess()){
			System.out.println(resultDO.getMessage());
		}else{
			System.out.println(resultDO.getMessage());
		}
	}
	
//	@Test
//	public void list() throws ServiceException{
//		ResultDO resultDO = commodityService.getAllCommodityList(1, 10, true);
//		if(resultDO.isSuccess()){
//			System.out.println(resultDO.getMessage());
//		}else{
//			System.out.println(resultDO.getMessage());
//		}
//	}

}
