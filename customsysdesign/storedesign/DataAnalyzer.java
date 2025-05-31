package dailyproblems.customsysdesign.storedesign;

import java.util.List;

class DataAnalyzer {
    private List<BoxRental> pastRequests;

    public DataAnalyzer(List<BoxRental> pastRequests) {
        this.pastRequests = pastRequests;
    }

    public double getAverageRentPerUnit() {
        int totalSpace = 0;
        int totalRent = 0;
        for (BoxRental request : pastRequests) {
            totalSpace += request.getWidth() * request.getHeight();
            totalRent += request.getRent();
        }
        return totalRent / (double) totalSpace;
    }
}

