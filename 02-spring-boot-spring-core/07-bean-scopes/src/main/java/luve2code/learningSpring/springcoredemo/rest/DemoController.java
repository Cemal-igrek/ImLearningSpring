package luve2code.learningSpring.springcoredemo.rest;

import luve2code.learningSpring.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // @Autowired this one is not recommended by spring.io team because it makes harder to unit tests.
    private Coach myCoach;

    private Coach anotherCoach;


    @Autowired
    public DemoController (@Qualifier("cricketCoach") Coach theCoach,
    @Qualifier("cricketCoach") Coach theAnotherCoach){
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach ,"+ (myCoach == anotherCoach);
    }
}




