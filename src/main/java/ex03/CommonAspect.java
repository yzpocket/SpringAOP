package ex03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CommonAspect {
	//@Before("execution(* ex03.*ServiceImpl.insert*(..))")
	public void trace1(JoinPoint jp) {
		Signature sign=jp.getSignature();
		System.out.println("==before==========["+sign.toShortString()+"]==========");
	}
	//@After("execution(* ex03.*ServiceImpl.insert*(..))")
	public void trace2(JoinPoint jp) {
		Signature sign=jp.getSignature();
		System.out.println("==after==========["+sign.toShortString()+"]==========");
	}
	//@AfterReturning(value="execution(* ex03.*ServiceImpl.insert*(..))", returning="result")
	public void trace3(JoinPoint jp, Integer result) {
		Signature sign=jp.getSignature();
		System.out.println("==after returning==========["+sign.toShortString()+"]==반환값:"+result+"========");
	}
	//@AfterThrowing(value="execution(* ex03.*ServiceImpl.insert*(..))", throwing="ex")
	public void trace4(JoinPoint jp, Exception ex) {
		Signature sign=jp.getSignature();
		System.out.println("==after throwing==========["+sign.toShortString()+"]==========");
		if(ex!=null) {
			System.out.println("발생된예외: "+ex);
		}
	}
	@Around("execution(* ex03.*ServiceImpl.insert*(..))")
	public Integer trace5(ProceedingJoinPoint jp) {
		Signature sign=jp.getSignature();
		String str=sign.toShortString();
		System.out.println("around(before)======"+str+" start============");
		try {
		Integer n=(Integer)jp.proceed();
		return n;
		}catch(Throwable e) {
			e.printStackTrace();
			return -1;
		}finally {
			System.out.println("around(after)======"+str+" end============");
		}
	}
}
