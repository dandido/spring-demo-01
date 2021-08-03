package com.company;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String ...args) {
        /**
         * this is a basic instantiation : hard to conf or to adapt
         */
        //Normal Java Way to instanciate a POJO
        //create the object
       Coach tCoach = new BaseballCoach();
        Coach t1Coach = new TrackCoach();

        //use the object
        System.out.println(tCoach.getDailyWorkout());
        System.out.println(t1Coach.getDailyWorkout());


        /** IOC
         * With spring , it consists of 3 steps :
         * 1- Configure your spring bean : exemple :
         *          applicationContext.xml ( the bean id aka alias + fully qualified class name of impl class)
         * 2- Create a spring container ( ClassPathXmlApplicationContext , AnnotationConfigApplicationContext, GenericWebApplicationContext ... )
         * 3 - Retrieve Beans from spring container : context.getBean("alias in the config ", "the interface".class)
         *
         *  => read the xml file with ClassPathXmlApplicationContext
         */

        // load the spring Configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrive bean from spring container
     /**
      * Note that the default scope is singleton that is cached in memory
      * that means that all request to the bean will return the same instance
      * For exemple : b3 and b3bis
      */

        Coach b2 = context.getBean("myCoach", Coach.class);
        Coach b1 = context.getBean("trackCoach", Coach.class);
        Coach b3 = context.getBean("crikcetCoach", Coach.class);

        //do stuff ...
        System.out.println(b2.getDailyWorkout());
        System.out.println(b1.getDailyWorkout());
        System.out.println(b3.getDailyWorkout());

        System.out.println(b2.getDailyFortune());
        System.out.println(b1.getDailyFortune());
        System.out.println(b3.getDailyFortune());

     System.out.println(((CricketCoach) b3).getEmailAddress());
     System.out.println(((CricketCoach) b3).getTeam());
     ((CricketCoach) b3).setEmailAddress("changed");
     CricketCoach b3bis = context.getBean("crikcetCoach", CricketCoach.class);

     System.out.println(b3bis.getEmailAddress());
     System.out.println(b3bis.getTeam());
     //close context
        context.close();
    }
}
