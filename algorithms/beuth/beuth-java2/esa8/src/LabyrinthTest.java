import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.io.IOException;

@DisplayName("LabyrinthTest")
public class LabyrinthTest {
    @Nested
    @DisplayName("path with 1 possible exit")
    class LabyrinthTestSolvablePath {
        int[][] arrs = {
                //1
                {
                        1,1,1,1,1,1,1,1,1,1
                },
                //2
                {
                        1,1,1,0,0,1,1,1,1,1
                },
                //3
                {
                        1,1,1,0,1,1,1,1,1,1
                },
                //4
                {
                        1,1,1,0,0,1,1,1,1,1
                },
                //5
                {
                        1,1,1,1,0,1,1,1,1,1
                },
                //6
                {
                        1,1,1,1,0,1,1,1,1,1
                },
                //7
                {
                        1,1,1,1,0,1,1,1,1,1
                },
                //8
                {
                        1,1,1,0,0,1,1,1,1,1
                },
                //9
                {
                        1,1,1,0,1,1,1,1,1,1
                },
                //10
                {
                        1,1,1,0,1,1,1,1,1,1
                },
        };

        private final Labyrinth l = new Labyrinth(arrs);

        @Test
        public void pathFinder() throws IOException {
            assertTrue(l.pathFinder());
        }
    }

    @Nested
    @DisplayName("labyrinth with no exit")
    class LabyrinthTestNoExit {
        int[][] arrs = {
                //1
                {
                        1,1,1,1,1,1,1,1,1,1
                },
                //2
                {
                        1,1,1,0,0,1,1,1,1,1
                },
                //3
                {
                        1,1,1,0,1,1,1,1,1,1
                },
                //4
                {
                        1,1,1,0,0,1,1,1,1,1
                },
                //5
                {
                        1,1,1,1,0,1,1,1,1,1
                },
                //6
                {
                        1,1,1,1,0,1,1,1,1,1
                },
                //7
                {
                        1,1,1,1,0,1,1,1,1,1
                },
                //8
                {
                        1,1,1,0,0,1,1,1,1,1
                },
                //9
                {
                        1,1,1,0,1,1,1,1,1,1
                },
                //10
                {
                        1,1,1,1,1,1,1,1,1,1
                },
        };

        private final Labyrinth l = new Labyrinth(arrs);

        @Test
        public void pathFinder() throws IOException {
            assertFalse(l.pathFinder());
        }
    }

    @Nested
    @DisplayName("labyrinth with multiple exits")
    class LabyrinthTestMultipleExits {
        int[][] arrs = {
                //1
                {
                        1,1,1,1,1,1,1,1,1,1
                },
                //2
                {
                        1,1,1,0,0,1,1,1,1,1
                },
                //3
                {
                        1,1,1,0,1,1,1,1,1,1
                },
                //4
                {
                        1,1,1,0,0,1,1,1,1,1
                },
                //5
                {
                        1,1,1,1,0,0,0,0,0,1
                },
                //6
                {
                        1,1,1,1,0,1,1,1,0,1
                },
                //7
                {
                        1,1,1,1,0,1,1,1,0,0
                },
                //8
                {
                        1,1,1,0,0,1,1,1,1,1
                },
                //9
                {
                        1,1,1,0,1,1,1,1,1,1
                },
                //10
                {
                        1,1,1,0,1,1,1,1,1,1
                },
        };

        private final Labyrinth l = new Labyrinth(arrs);

        @Test
        public void pathFinder() throws IOException {
            assertTrue(l.pathFinder());
        }
    }
}
