package ex01;

import org.springframework.aop.framework.ProxyFactory;

public class AOPTest {

	public static void main(String[] args) {
		//1. 핵심 로직을 갖는 객체 => Target
		ServiceImpl target= new ServiceImpl();
		
		//2. 공통 관심 사항 => Advice
		AroundAdvice advice= new AroundAdvice();
		
		//3. Proxy 객체 얻기 ==> Target을 전체적으로 감싸고 있는 객체를 Proxy라고 한다.
		//	 Proxy는 내부적으로 Target을 호출하지만, 중간에 필요한 관심사항들을 거쳐서 Target을 호출하도록 작성된다.
		//	 Proxy는 스프링 aop프레임웤에서 자동으로 생성되는 방식(auto-proxy)방식을 사용한다
		ProxyFactory pf=new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(advice);
		
		ServiceImpl proxy=(ServiceImpl)pf.getProxy();
		proxy.sayHello("영희", "철수", "하니", "제니");
	}

}
