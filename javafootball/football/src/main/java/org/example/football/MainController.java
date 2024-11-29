package org.example.football;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MainController {

    @FXML
    private TableView<Match> matchesTable;

    @FXML
    private TableColumn<Match, String> homeTeamColumn;

    @FXML
    private TableColumn<Match, String> awayTeamColumn;

    @FXML
    private TableColumn<Match, String> dateColumn;

    @FXML
    public void initialize() {
        setupTableColumns();
    }

    private void setupTableColumns() {
        homeTeamColumn.setCellValueFactory(new PropertyValueFactory<>("homeTeam"));
        awayTeamColumn.setCellValueFactory(new PropertyValueFactory<>("awayTeam"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    @FXML
    public void fetchMatches() {
        try {
            // Mock data or fetch from API
            matchesTable.getItems().setAll(List.of(
                    new Match("Team A", "Team B", "2024-11-28"),
                    new Match("Team C", "Team D", "2024-11-29")
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void clearFields() {
        if (matchesTable != null) {
            matchesTable.getItems().clear();
        }
    }

    @FXML
    public void exitApplication() {
        System.exit(0);
    }
}