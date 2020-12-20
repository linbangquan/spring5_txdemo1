package com.lbq.spring5.tx.service;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
//@Transactional
public interface UserService {
	/**
	 * propagation:事务传播行为
	 * (1)多事务方法直接进行调用，这个过程中事务是如何进行管理的，事务的传播行为可以由传播属性指定。Spring定义了7种类传播行为。
	 * Propagation.REQUIRED：如果有事务在运行，当前的方法就在这个事务内运行，否则，就启动一个新的事务，并在自己的事务内运行。
	 * Propagation.REQUIRES_NEW：当前的方法必须启动新的事务，并在它自己的事务内运行。如果有事务正在运行，应该将它挂起。
	 * Propagation.SUPPORTS：如果有事务在运行，当前的方法就在这个事务内运行，否则它可以不运行在事务中。
	 * Propagation.NOT_SUPPORTED：当前的方法不应该运行在事务中，如果有运行的事务，将它挂起。
	 * Propagation.MANDATORY：当前的方法必须运行在事务内部，如果没有正在运行的事务，就抛出异常。
	 * Propagation.NEVER：当前的方法不应该运行在事务中，如果有运行的事务，就抛出异常。
	 * Propagation.NESTED：如果有事务在运行，当前的方法就应该在这个事务的嵌套事务内运行。否则，就启动一个新的事务，并在它自己的事务内运行。
	 */
	/**
	 * isolation:事务隔离级别
	 * (1)事务有特性成为隔离性，多事务操作之间不会产生影响。不考虑隔离性产生很多问题。
	 * (2)有三个读问题：脏读、不可重复读、幻读。
	 * (3)脏读：一个未提交的事务读取到另一个未提交事务的数据。
	 * (4)不可重复读：一个未提交事务读取到另一个提交事务修改数据。
	 * (5)幻读：一个未提交事务读取到另一个提交事务添加数据。
	 * (6)解决：通过设置事务的隔离级别，解决读问题。
	 * 										脏读	不可重复读	幻读
	 * Isolation.READ_UNCOMMITTED:	读未提交	有	有		有
	 * Isolation.READ_COMMITTED:	读已提交	无	有		有
	 * Isolation.REPEATABLE_READ:	可重复读	无	无		有
	 * Isolation.SERIALIZABLE:		串行化	无	无		无
	 * Isolation.DEFAULT:
	 */
	/**
	 * timeout：超时时间
	 * (1)事务需要在一定时间内进行提交，如果不提交进行回滚
	 * (2)默认值是-1，设置时间以秒单位进行计算
	 */
	/**
	 * readOnly：是否只读
	 * (1)读：查询操作，写：添加修改删除操作
	 * (2)readOnly默认值false，表示可以查询，可以添加修改删除操作
	 * (3)设置readOnly值是true，设置成true之后，只能查询
	 */
	/**
	 * rollbackFor：回滚
	 * (1)设置出现哪些异常进行事务回滚
	 */
	/**
	 * noRollbackFor：不回滚
	 * (2)设置出现哪些异常不进行事务回滚
	 */
	@Transactional(
			propagation = Propagation.REQUIRED, 
			isolation = Isolation.DEFAULT, 
			timeout = TransactionDefinition.TIMEOUT_DEFAULT, 
			readOnly = false, 
			rollbackFor = {RuntimeException.class})
	public void accountMoney();
	
//	@Transactional(propagation = Propagation.REQUIRES)
//	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Transactional(propagation = Propagation.SUPPORTS)
	public void second();
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void REQUIRED(Propagation propagation, boolean first, boolean second);
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void REQUIRES_NEW(Propagation propagation, boolean first, boolean second);
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void SUPPORTS(Propagation propagation, boolean first, boolean second);
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void NOT_SUPPORTED(Propagation propagation, boolean first, boolean second);
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void MANDATORY(Propagation propagation, boolean first, boolean second);
	
	@Transactional(propagation = Propagation.NEVER)
	public void NEVER(Propagation propagation, boolean first, boolean second);
	
	@Transactional(propagation = Propagation.NESTED)
	public void NESTED(Propagation propagation, boolean first, boolean second);
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void REQUIRED();
	@Transactional(propagation = Propagation.NEVER)
	public void NEVER();
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
	public void update();
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
	public void insert();
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
	public void list();
	
}
