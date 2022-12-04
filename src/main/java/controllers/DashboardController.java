package controllers;

import use_cases.UpdatePredictions;

public class DashboardController {
    public DashboardController() {  }

    public void updateDashboardPredictions() {
        UpdatePredictions.updateDashboardPredictions();
    }
}
