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
package com.soheibo.View;

import com.soheibo.Controller.TaskComponentController;
import com.soheibo.Model.Task;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Soheib El-Harrache
 */
public class TaskComponent extends AnchorPane {

    public TaskComponent(Task task, int distance) {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/FXML/task.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(TaskComponent.class.getName()).log(Level.SEVERE, null, ex);
        }      
        TaskComponentController taskComponentController
                = (TaskComponentController) fxmlLoader.getController();
        
        taskComponentController.initTask(task);
        
        //taskComponentController.initTask(task);
        AnchorPane.setLeftAnchor(this, 10.0);
        AnchorPane.setRightAnchor(this, 10.0);
        AnchorPane.setTopAnchor(this, 10.0);
    }
}