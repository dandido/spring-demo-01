package com.company;

public class TrackCoach implements Coach {

    //defin a private field for dependency
    private IFortuneService iFortuneService;

    public TrackCoach() {
    }
    //add init mehod
    public void doMyStartupStuff(){
        System.out.println("TrackCoach : inside mehod doMyStartupStuff");
    }
    //add destroy
    public void doMyCleaningStuff(){
        System.out.println("TrackCoach : inside mehod doMyCleaningStuff");

    }
    //create const for DI
    public TrackCoach(IFortuneService iFortuneService){
        this.iFortuneService = iFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Run as fast as you can";
    }

    @Override
    public String getDailyFortune() {
        // use the service to call
        return "TrackCoach : "+ this.iFortuneService.getFort();
    }
}
