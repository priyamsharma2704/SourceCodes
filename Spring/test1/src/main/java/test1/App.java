package test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("test1/beans/beans.xml");
		Person p = (Person)context.getBean("person");
		p.speak();
		Address add = (Address)context.getBean("address");
		System.out.println(p);
		System.out.println(add);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
