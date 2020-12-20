package com.lbq.spring5.tx.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;

import com.lbq.spring5.tx.config.TxConfig;
import com.lbq.spring5.tx.service.UserService;
import com.lbq.spring5.tx.service.UserServiceImpl;

public class TestUser {
	
	@Test
	public void testAccount() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//		UserServiceImpl userService = context.getBean("userServiceImpl", UserServiceImpl.class);
//		userService.accountMoney();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Map<String, UserService> map = context.getBeansOfType(UserService.class);
		for(Map.Entry<String, UserService> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			entry.getValue().accountMoney();
		}
	}

	@Test
	public void testAccount2() {		
		ApplicationContext context = new ClassPathXmlApplicationContext("application2.xml");
		Map<String, UserService> map = context.getBeansOfType(UserService.class);
		for(Map.Entry<String, UserService> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			entry.getValue().accountMoney();
		}
	}
	
	@Test
	public void testAccount3() {
		ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
		Map<String, UserService> map = context.getBeansOfType(UserService.class);
		for(Map.Entry<String, UserService> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			entry.getValue().accountMoney();
		}
	}
	
	private UserService getUserService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Map<String, UserService> map = context.getBeansOfType(UserService.class);
		for(Map.Entry<String, UserService> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			return entry.getValue();
		}
		return null;
	}
	
	@Test
	public void REQUIRED() {
//		getUserService().REQUIRED(null, false, false);
		//自动开启事务
		getUserService().REQUIRED(null, true, false);
	}
	@Test
	public void REQUIRED2REQUIRED() {
//		getUserService().REQUIRED(Propagation.REQUIRED, false, false);
		getUserService().REQUIRED(Propagation.REQUIRED, false, true);
	}
	@Test
	public void REQUIRED2REQUIRES_NEW() {
//		getUserService().REQUIRED(Propagation.REQUIRES_NEW, false, false);
		/** 第二个新事务抛异常被处理后，第一个事务会正常提交 **/
//		getUserService().REQUIRED(Propagation.REQUIRES_NEW, false, true);
		/** 第一个事务抛异常，第二个新事务也会回滚 **/
		getUserService().REQUIRED(Propagation.REQUIRES_NEW, true, false);
	}
	
	@Test
	public void REQUIRED2SUPPORTS() {
//		getUserService().REQUIRED(Propagation.SUPPORTS, false, false);
		/** 在同一个事务运行，抛异常被处理后，事务正常提交 **/
//		getUserService().REQUIRED(Propagation.SUPPORTS, false, true);
		/** 在同一个事务运行，抛异常后，事务回滚 **/
		getUserService().REQUIRED(Propagation.SUPPORTS, true, false);
	}
	
	@Test
	public void REQUIRED2NOT_SUPPORTED() {
//		getUserService().REQUIRED(Propagation.NOT_SUPPORTED, false, false);
		/** 在第一个方法事务挂起，第二个方法没有事务，抛异常后没有处理异常，第一个方法事务回滚，第二个方法操作不生效（这跟回滚点） **/
//		getUserService().REQUIRED(Propagation.NOT_SUPPORTED, false, true);
		getUserService().REQUIRED(Propagation.NOT_SUPPORTED, true, false);
	}
	
	@Test
	public void REQUIRED2MANDATORY() {
		getUserService().REQUIRED(Propagation.MANDATORY, false, false);
	}
	
	@Test
	public void REQUIRED2NEVER() {
		/** 这里有点奇怪，Propagation.NEVER遇到事务，没有抛异常 **/
		getUserService().REQUIRED(Propagation.NEVER, false, false);
//		getUserService().REQUIRED(Propagation.NEVER, false, true);
//		getUserService().REQUIRED(Propagation.NEVER, true, false);
	}
	@Test
	public void REQUIRED2NESTED() {
//		getUserService().REQUIRED(Propagation.NESTED, false, false);
//		getUserService().REQUIRED(Propagation.NESTED, true, false);
		getUserService().REQUIRED(Propagation.NESTED, false, true);
	}
	@Test
	public void REQUIRES_NEW() {		
//		getUserService().REQUIRES_NEW(null, false, false);
		//自动开启事务
		getUserService().REQUIRES_NEW(null, true, false);
	}
	@Test
	public void SUPPORTS() {
//		getUserService().SUPPORTS(null, false, false);
		//不会自动开启事务
		getUserService().SUPPORTS(null, true, false);
	}
	@Test
	public void NOT_SUPPORTED() {		
//		getUserService().NOT_SUPPORTED(null, false, false);
		//不会开启事务
		getUserService().NOT_SUPPORTED(null, true, false);
	}
	@Test
	public void MANDATORY() {
//		org.springframework.transaction.IllegalTransactionStateException: No existing transaction found for transaction marked with propagation 'mandatory'
		getUserService().MANDATORY(null, false, false);
	}
	@Test
	public void NEVER() {		
//		getUserService().NEVER(null, false, false);
		//不会开启事务
		getUserService().NEVER(null, true, false);
	}
	@Test
	public void NESTED() {		
//		getUserService().NESTED(null, false, false);
		//自动开启事务
		getUserService().NESTED(null, true, false);
	}
	
	@Test
	public void REQUIRED2NEVER2() {
		getUserService().REQUIRED();
	}
	
	@Test
	public void update() {
		getUserService().update();
	}
	
	@Test
	public void insert() {
		getUserService().insert();
	}
	
	@Test
	public void list() {
		getUserService().list();
	}
}
