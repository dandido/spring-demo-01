package com.company;


public class CricketCoach implements Coach {
    /**
     * Do a setter injection
     */
    private IFortuneService iFortuneService;
    //inject field value
    private String emailAddress ;
    private String team;

    //create a non arg constructor
    public CricketCoach(){
        System.out.println("CricketCoach: inside the no-args");
    }
    //Create setter methode

    public void setiFortuneService(IFortuneService iFortuneService) {
        System.out.println("CricketCoach: inside the setiFortuneService");
        this.iFortuneService = iFortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach: inside the setEmailAddress");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside the setTeam");
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Go Sleep";
    }

    @Override
    public String getDailyFortune() {
        return iFortuneService.getFort();
    }
}
