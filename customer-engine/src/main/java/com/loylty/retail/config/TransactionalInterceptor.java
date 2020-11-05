package com.loylty.retail.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class TransactionalInterceptor {
//	@Pointcut(value = "execution(public * *(..)) && "
//			+ "@annotation(org.springframework.transaction.annotation.Transactional) && "
//			+ "args(groupId,..)")
	@Pointcut("execution(* com.loylty.retail.customer.engine.service..*.*(..)) && args(groupId,..)")
	public void anyMethodInServicePackageWithGroupIdAsFirstArg(String groupId) {}
	
	@Pointcut("@annotation(org.springframework.stereotype.Service)")
	public void anyServiceAnnotatedClass() {}
	
	@Around("@within(com.loylty.retail.config.InjectDataSource) && execution(* *(..)) && args(groupId,..)")
	public Object proceed(ProceedingJoinPoint pjp, String groupId) throws Throwable {
		System.out.println("sigIn: " + pjp.getSignature());
		GroupIdContextHolder.set(groupId);
		Object result = pjp.proceed();
		return result;
	}
}
