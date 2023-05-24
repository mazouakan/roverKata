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
            ("0 0 N, R, 0 0 E"),
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

    @Test
    @Parameters({
            ("1 2 N, M, 1 3 N"),
            ("1 2 N, MM, 1 4 N"),
            ("1 2 N, MMMM, 1 6 N")
    })
    public void should_move_up(String initialPosition,
                               String commands,
                               String finalPosition){
        assertThat(rover.explore(initialPosition, commands), is(finalPosition));
    }

    @Test
    @Parameters({
            ("3 3 S, M, 3 2 S"),
            ("1 3 S, MM, 1 1 S"),
            ("2 4 S, MMM, 2 1 S")
    })
    public void should_move_down(String initialPosition,
                               String commands,
                               String finalPosition){
        assertThat(rover.explore(initialPosition, commands), is(finalPosition));
    }

}
