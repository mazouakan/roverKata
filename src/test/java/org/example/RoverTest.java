package org.example;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.example.model.Coordinate;
import org.example.model.Grid;
import org.example.model.Rover;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RoverTest {

    private Rover rover;



    @Before
    public  void  initialise(){
        Grid grid = new Grid(5,5);
        rover = new Rover(grid);

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
            ("1 2 N, MMM, 1 5 N"),
            ("1 2 E, LM, 1 3 N"),
            ("1 2 W, RM, 1 3 N")
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
            ("2 4 S, MMM, 2 1 S"),
            ("2 4 N, RRMM, 2 2 S"),
            ("2 4 W, LM, 2 3 S")
    })
    public void should_move_down(String initialPosition,
                                 String commands,
                                 String finalPosition){
        assertThat(rover.explore(initialPosition, commands), is(finalPosition));
    }

    @Test
    @Parameters({
            ("3 3 S, LMM, 5 3 E"),
            ("1 3 N, RMMM, 4 3 E"),
            ("2 4 W, RRM, 3 4 E")
    })
    public void should_move_right(String initialPosition,
                                  String commands,
                                  String finalPosition){
        assertThat(rover.explore(initialPosition, commands), is(finalPosition));
    }

    @Test
    @Parameters({
            ("3 3 S, RMM, 1 3 W"),
            ("3 3 N, LMMM, 0 3 W"),
            ("2 4 E, RRM, 1 4 W"),
            ("2 4 E, LLM, 1 4 W")
    })
    public void should_move_left(String initialPosition,
                                 String commands,
                                 String finalPosition){
        assertThat(rover.explore(initialPosition, commands), is(finalPosition));
    }

    @Test
    @Parameters({
            ("3 3 N, MMM, 3 5 N"),
            ("3 3 N, LMMMMM, 0 3 W"),
            ("3 3 N, LLMMMMM, 3 0 S")
    })
    public void should_stop_when_edge_is_reached(String initialPosition,
                                 String commands,
                                 String finalPosition){
        assertThat(rover.explore(initialPosition, commands), is(finalPosition));
    }

    @Test
    @Parameters({
            ("3 3 W, M, 3 3 W"),
            ("1 1 N, MMRMM, 1 3 E")

    })
    public void should_stop_when_finding_other_rover(String initialPosition,
                                                 String commands,
                                                 String finalPosition){
        Coordinate coordinate = new Coordinate(2,3);
        Grid grid = new Grid(5,5,asList(coordinate));
        Rover rover = new Rover(grid);
        assertThat(rover.explore(initialPosition, commands), is(finalPosition));
    }

    @Test
    @Parameters({
            ("1 2 N, LMLMLMLMM, 1 3 N")

    })
    public void should_return_1_3_N(String initialPosition,
                                                     String commands,
                                                     String finalPosition){
        Coordinate coordinate = new Coordinate(3,3);
        Grid grid = new Grid(5,5,asList(coordinate));
        Rover rover = new Rover(grid);
        assertThat(rover.explore(initialPosition, commands), is(finalPosition));
    }

    @Test
    @Parameters({
            ("3 3 E, MMRMMRMRRM, 5 1 E")

    })
    public void should_return_5_1_E(String initialPosition,
                                    String commands,
                                    String finalPosition){
        Coordinate coordinate = new Coordinate(1,3);
        Grid grid = new Grid(5,5,asList(coordinate));
        Rover rover = new Rover(grid);
        assertThat(rover.explore(initialPosition, commands), is(finalPosition));
    }

}
