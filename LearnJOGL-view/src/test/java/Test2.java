import org.junit.jupiter.api.Test;
import ru.mos.bmstu.jogl.model.model.Coordinate3D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Test2 {

    public static int[][] uniformFilter(int[][] pixels, int N) {
        int height = pixels.length;
        int width = pixels[0].length;
        int[][] filteredPixels = new int[height][width];
        int halfN = N / 2;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int sum = 0;
                int count = 0;
                for (int dy = -halfN; dy <= halfN; dy++) {
                    int ny = y + dy;
                    if (ny < 0 || ny >= height) {
                        continue;
                    }
                    for (int dx = -halfN; dx <= halfN; dx++) {
                        int nx = x + dx;
                        if (nx < 0 || nx >= width) {
                            continue;
                        }
                        sum += pixels[ny][nx];
                        count++;
                    }
                }
                int average = count > 0 ? sum / count : 0;
                filteredPixels[y][x] = average;
            }
        }

        return filteredPixels;
    }

    @Test
    public void testIsEdgesClosed() {
        int[][] pixels = {{0, 0, 0, 0}, {0, 100, 100, 0}, {0, 0, 0, 0}};
        int[][] filteredPixels = uniformFilter(pixels, 2);
        for (int[] row : filteredPixels) {
            System.out.println(Arrays.toString(row));
        }
    }
}


