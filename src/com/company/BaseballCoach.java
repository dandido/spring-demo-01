package com.company;

public class BaseballCoach implements Coach {
    //defin a private field for dependency
    private IFortuneService iFortuneService;

    public BaseballCoach() {
        System.out.println("BaseballCoach : inside mehod BaseballCoach");
    }

    //create const for DI
    public BaseballCoach(IFortuneService iFortuneService){
        this.iFortuneService = iFortuneService;
        System.out.println("BaseballCoach : inside mehod BaseballCoach");

    }

    //add init mehod
    public void doMyStartupStuff(){
        System.out.println("BaseballCoach : inside mehod doMyStartupStuff");
    }
    //add destroy
    public void doMyCleaningStuff(){
        System.out.println("BaseballCoach : inside mehod doMyCleaningStuff");

    }
    @Override
    public String getDailyWorkout(){
        return "spend 1h training hard";
    }

    @Override
    public String getDailyFortune() {
        return "BaseballCoach : " + this.iFortuneService.getFort();
    }
}
