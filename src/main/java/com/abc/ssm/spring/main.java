package com.abc.ssm.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService personService = (PersonService) ctx.getBean("personService");
        personService.print();




//        //从xml中获得
//        Person zhao= (Person) ctx.getBean("zhao");
//        //xml中已经属性注入了,这里秩序获取属性 ,定义了一个Person zhao 来接收这些属性
//       //xml中属性注入了一个  手机 类 ,并给 人物类中 依赖注入了  手机
//        //秩只需定义一个 Phone 类 来接受手机的数据
//        Phone phone =zhao.getPhone();
//        Phone phone1= (Phone) ctx.getBean("huawei");
//        System.out.println(zhao.getPname());
//        System.out.println(phone.getPrice());
//        System.out.println(phone1);

    }
}
