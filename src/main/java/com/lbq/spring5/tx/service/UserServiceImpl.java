package com.lbq.spring5.tx.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lbq.spring5.tx.dao.UserDao;
import com.lbq.spring5.tx.dto.Account;

@Service
//@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	//@Transactional
	public void accountMoney() {
//		PlatformTransactionManager platformTransactionManager;
//		try {
			//第一步 开启事务
			//第二步 进行业务操作
			userDao.reduceMoney();
			second();
			
			//第三步 没有发生异常，提交事务
//		}catch(Exception e) {
			//第四步 出现异常，事务回滚
//		}
		
	}

	@Override
	public void second() {
		userDao.addMoney();
		//模拟异常
		int i = 10/0;		
	}
	
	private void transactional(Propagation propagation, boolean first, boolean second) {
		userDao.reduceMoney();
		if(propagation != null) {
			try {
				switch(propagation) {
				case REQUIRED : 
					REQUIRED(null, second, false);
					break;
				case REQUIRES_NEW : 
					REQUIRES_NEW(null, second, false);
					break;
				case SUPPORTS : 
					SUPPORTS(null, second, false);
					break;
				case NOT_SUPPORTED : 
					NOT_SUPPORTED(null, second, false);
					break;
				case MANDATORY : 
					MANDATORY(null, second, false);
					break;
				case NEVER : 
					NEVER(null, second, false);
					break;
				case NESTED : 
					NESTED(null, second, false);
					break;
				default : break;
				}
			}catch(Exception e) {
				throw e;
			}
			
		}
		if(first) {
			//模拟异常
			int i = 10/0;
		}
		userDao.addMoney();
	}

	@Override
	public void REQUIRED(Propagation propagation, boolean first, boolean second) {
		transactional(propagation, first, second);
	}

	@Override
	public void REQUIRES_NEW(Propagation propagation, boolean first, boolean second) {
		transactional(propagation, first, second);
	}

	@Override
	public void SUPPORTS(Propagation propagation, boolean first, boolean second) {
		transactional(propagation, first, second);
	}

	@Override
	public void NOT_SUPPORTED(Propagation propagation, boolean first, boolean second) {
		transactional(propagation, first, second);
	}

	@Override
	public void MANDATORY(Propagation propagation, boolean first, boolean second) {
		transactional(propagation, first, second);
	}

	@Override
	public void NEVER(Propagation propagation, boolean first, boolean second) {
		transactional(propagation, first, second);
	}

	@Override
	public void NESTED(Propagation propagation, boolean first, boolean second) {
		transactional(propagation, first, second);
	}

	@Override
	public void REQUIRED() {
		userDao.reduceMoney();
		userDao.addMoney();
		NEVER();
	}

	@Override
	public void NEVER() {
		userDao.reduceMoney();
		userDao.addMoney();
		
	}

	@Override
	public void update() {
		userDao.update();
		System.out.println("--------------------------");
//		try {
//			TimeUnit.MINUTES.sleep(2);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void insert() {
		userDao.insert();
		System.out.println("--------------------------");
//		try {
//			TimeUnit.MINUTES.sleep(2);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void list() {
		List<Map<String,Object>> accountList = userDao.list();
		accountList.forEach(System.out::println);
		System.out.println("++++++++++++++++++++++++++");
		try {
//			TimeUnit.MINUTES.sleep(1);
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<Map<String,Object>> accountList2 = userDao.list();
		accountList2.forEach(System.out::println);
	}
}
