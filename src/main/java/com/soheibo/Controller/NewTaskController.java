/*
 * Copyright 2017 Soheib El-Harrache.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.soheibo.Controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import com.soheibo.Model.Task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 * Controller for the view used to add a new task.
 * 
 * @author Soheib El-Harrache
 */
public class NewTaskController {

    @FXML
    JFXTextField nameFieldNewTask;
    
    @FXML
    AnchorPane taskDetailsAnchorPane;

    @FXML
    JFXTimePicker timePicker;
    
    @FXML
    JFXDatePicker datePicker;
    
    /**
     * Creates and returns a new task if valid. Returns null if not valid.
     * @return Null if not valid or the new task if valid.
     */
    public Task getTask() {
        //Verifications
        if (!nameFieldNewTask.getText().equals("")) {
            Task newTask = new Task(nameFieldNewTask.getText());
            
            if (datePicker.getValue() != null) {
                LocalDate date = datePicker.getValue();
                LocalTime mockTime = LocalTime.MIN;
                LocalDateTime dateTime = LocalDateTime.of(date, mockTime);
                newTask.setEndDate(dateTime);
            }
            
            return newTask;
        } else {
            return null;
        }
    }
    
    /**
     * Shows the panel containing details for a task.
     */
    public void showDetails() {
        taskDetailsAnchorPane.setVisible(true);
    }

    /**
     * Applies subtle graphical modifications.
     */
    public void applyGUIMods() {
        //taskDetailsAnchorPane.managedProperty().bind(taskDetailsAnchorPane.
        //visibleProperty());
    }
}
