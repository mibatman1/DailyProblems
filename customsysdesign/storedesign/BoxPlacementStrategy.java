package dailyproblems.customsysdesign.storedesign;

class BoxPlacementStrategy {
    private Store store;
    private DataAnalyzer dataAnalyzer;

    public BoxPlacementStrategy(Store store, DataAnalyzer dataAnalyzer) {
        this.store = store;
        this.dataAnalyzer = dataAnalyzer;
    }

    public boolean shouldAccept(BoxRental request) {
        double rentPerSpace = (double) request.getRent() / (request.getWidth() * request.getHeight());
        double avgRentPerSpace = dataAnalyzer.getAverageRentPerUnit();

        if (rentPerSpace >= avgRentPerSpace && store.canPlaceBox(request)) {
            return true;
        }
        return false;
    }
}

