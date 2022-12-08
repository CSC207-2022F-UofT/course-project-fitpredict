package controllers;

import use_cases.UpdatePredictions;

public class DashboardController {
    public DashboardController() {  }

    /**
     * Calls the UpdatePredictions use case to update the Dashboard's predictions
     */
    public void updateDashboardPredictions() {
        UpdatePredictions.updateDashboardPredictions();
    }
}
