package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBeanScope {

    public static void main(String ...args) {
     /** Bean life cycle :
      * 1- Container started
      * 2- Bean init
      * 3- Dep Injection
      * 4-Internal spring Processing
      *  5-add your custom init method ( setting up handler ...  or calling custom business logic )
      *  ----
      *  Container shutdown
      *  -> chance to call your custom destroy method ( clean up handler ...or calling custom business logic )
      */

     // load the spring Configuration file
     ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanScope-applicationContext.xml");

     //retrieve bean from spring container
     Coach trackCoach = context.getBean("trackCoach", Coach.class);
     Coach betatrackCoach = context.getBean("trackCoach", Coach.class);

     boolean result = trackCoach == betatrackCoach;
     System.out.println(trackCoach);     //check if the same bean instance
     System.out.println(betatrackCoach);     //check if the same bean instance
     System.out.println(result);     //check if the same bean instance


     Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
     Coach betabaseballCoach = context.getBean("baseballCoach", Coach.class);
     boolean result2 = baseballCoach == betabaseballCoach;
     System.out.println(baseballCoach);     //check if the same bean instance
     System.out.println(betabaseballCoach);     //check if the same bean instance
     System.out.println(result2);
     //For "prototype" scoped beans, Spring does not call the destroy method.  Gasp!
     context.close();
    }
}
