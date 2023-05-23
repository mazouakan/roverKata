package org.example;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RoverTest {

    private Rover rover;


    @Before
    public  void  initialise(){
        rover = new Rover();
    }

    @Test
    @Parameters({
            ("1 2 N, R, 1 2 E"),
            ("1 2 N, RR, 1 2 S"),
            ("1 2 N, RRR, 1 2 W"),
            ("1 2 N, RRRR, 1 2 N")
    })
    public void should_rotate_right(String initialPosition,
                                    String commands,
                                    String finalPosition){
        assertThat(rover.explore(initialPosition,commands), is(finalPosition));
    }

    @Test
    @Parameters({
            ("1 2 N, L, 1 2 W"),
            ("1 2 W, L, 1 2 S"),
            ("1 2 E, LLL, 1 2 S"),
            ("1 2 E, LLLL, 1 2 E")
    })
    public void should_rotate_left(String initialPosition,
                                   String commands,
                                   String finalPosition){
        assertThat(rover.explore(initialPosition,commands), is(finalPosition));
    }

}
