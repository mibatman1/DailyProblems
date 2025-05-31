package dailyproblems.customsysdesign.storedesign;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int width;
    private int height;
    private boolean grid[][];
    private List<BoxRental> activeRentals;

    public Store(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new boolean[width][height];
        this.activeRentals = new ArrayList<>();
    }

    public boolean canPlaceBox(BoxRental request) {
        for (int i = 0; i <= height - request.getHeight(); i++) {
            for (int j = 0; j <= width - request.getWidth(); j++) {
                if (checkSpaceAvailable(i, j, request)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkSpaceAvailable(int row, int col, BoxRental request) {
        for (int i = row; i < row + request.getHeight(); i++) {
            for (int j = col; j < col + request.getWidth(); j++) {
                if (grid[i][j])
                    return false;
            }
        }
        return true;
    }

    public boolean placeBox(BoxRental request) {
        if (!canPlaceBox(request))
            return false;

        for (int i = 0; i <= height - request.getHeight(); i++) {
            for (int j = 0; j <= width - request.getWidth(); j++) {
                if (checkSpaceAvailable(i, j, request)) {
                    markSpaceOccupied(i, j, request);
                    activeRentals.add(request);
                    return true;
                }
            }
        }
        return false;
    }

    private void markSpaceOccupied(int row, int col, BoxRental request) {
        for (int i = row; i < row + request.getHeight(); i++) {
            for (int j = col; j < col + request.getWidth(); j++) {
                grid[i][j] = true;
            }
        }
    }

    public void removeBox(BoxRental request) {
        activeRentals.remove(request);
    }

    public int calculateProfit() {
        int totalRent = 0;
        for (BoxRental request : activeRentals) {
            totalRent += request.getRent();
        }
        return totalRent;
    }
}
