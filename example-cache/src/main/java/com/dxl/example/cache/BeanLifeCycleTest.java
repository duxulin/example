package com.dxl.example.cache;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component()
public class BeanLifeCycleTest implements BeanNameAware, BeanFactoryAware, BeanPostProcessor , DisposableBean {

	public BeanLifeCycleTest(){
		System.out.println("construct Method");
	}


//
//	@Bean(initMethod = "init",destroyMethod = "myDestroy")
//	public BeanLifeCycleTest getBean(){
//		return new BeanLifeCycleTest();
//	}

	private void myDestroy() {
		System.out.println("myDestroy"+this.toString());
	}

	private void init() {
		System.out.println("init"+this.toString());
	}


	@PostConstruct
	private void postConstruct(){
		System.out.println("postConstruct");
	}



	@PreDestroy
	private void preDestroy(){
		System.out.println("preDestroy"+this.toString());
	}

	@Override
	public void setBeanName(String s) {
		System.out.println("setBeanNameAway:"+s);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory:+"+beanFactory.toString());

	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof BeanLifeCycleTest){
			System.out.println("postProcessBeforeInitialization"+beanName);

		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof BeanLifeCycleTest){
			System.out.println("postProcessAfterInitialization" + beanName);
		}
		return bean;
	}

	@Override
	public void destroy(){
		System.out.println("destroy"+this.toString());
	}
}
