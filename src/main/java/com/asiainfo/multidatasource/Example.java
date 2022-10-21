package com.asiainfo.multidatasource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.multidatasource.service.IUserService;

/**
 * @author zq
 * @Description: TODO
 * @date 2017年5月7日  下午5:17:33
 * Copyright: 	  北京亚信智慧数据科技有限公司
 */
public class Example {

    /**
     * @param args
     * @Description: TODO
     */
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:application-core-configure.xml"});
        IUserService service = context.getBean(IUserService.class);
        System.out.println(service.queryUser("10002"));
        System.out.println(service.list());
        System.out.println(service.list());
        System.out.println(service.list());
        System.out.println(service.list());
        // service.save("10004", "test");
        service.save("10003", "test");
        service.save("10002", "test");
        service.save("10005", "test");
        service.save("10007", "test");
        context.close();
    }
}
