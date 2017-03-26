/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.sun.javafx.scene.control.skin.ComboBoxListViewSkin;
import java.util.Timer;
import java.util.TimerTask;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Werner
 */
public class SelectKeyComboBoxListener implements EventHandler<KeyEvent> {

    private ComboBox comboBox;
    private StringBuilder sb = new StringBuilder();
    private TimerTask task;
    private boolean doContainsSearch;

    public SelectKeyComboBoxListener(ComboBox comboBox, boolean doContainsSearch) {
        this.comboBox = comboBox;
        this.doContainsSearch = doContainsSearch;
        this.comboBox.setOnKeyReleased(SelectKeyComboBoxListener.this);

        this.comboBox.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.ESCAPE && sb.length() > 0) {
                sb.delete(0, sb.length());
            }
        });

        // add a focus listener such that if not in focus, reset the filtered typed keys
        this.comboBox.focusedProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue instanceof Boolean && !((Boolean) newValue)) {
                    sb.delete(0, sb.length());
                } else {
                    ListView lv = ((ComboBoxListViewSkin) SelectKeyComboBoxListener.this.comboBox.getSkin()).getListView();
                    lv.scrollTo(lv.getSelectionModel().getSelectedIndex());
                }
            }
        });

        this.comboBox.setOnMouseClicked((MouseEvent event) -> {
            ListView lv = ((ComboBoxListViewSkin) SelectKeyComboBoxListener.this.comboBox.getSkin()).getListView();
            lv.scrollTo(lv.getSelectionModel().getSelectedIndex());
        });
    }

    @Override
    public void handle(KeyEvent event) {

        resetTimer();

        if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.UP || event.getCode() == KeyCode.TAB) {
            return;
        } else if (event.getCode() == KeyCode.BACK_SPACE && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(event.getText());
        }

        if (sb.length() == 0) {
            return;
        }

        boolean found = false;
        ObservableList items = comboBox.getItems();
        for (int i = 0; i < items.size(); i++) {

            if (doContainsSearch) {
                if (event.getCode() != KeyCode.BACK_SPACE && items.get(i).toString().toLowerCase().contains(sb.toString().toLowerCase())) {
                    ListView lv = ((ComboBoxListViewSkin) comboBox.getSkin()).getListView();
                    lv.getSelectionModel().clearAndSelect(i);
                    lv.scrollTo(lv.getSelectionModel().getSelectedIndex());
                    found = true;
                    break;
                }
            } else if (event.getCode() != KeyCode.BACK_SPACE && items.get(i).toString().toLowerCase().startsWith(sb.toString().toLowerCase())) {
                ListView lv = ((ComboBoxListViewSkin) comboBox.getSkin()).getListView();
                lv.getSelectionModel().clearAndSelect(i);
                lv.scrollTo(lv.getSelectionModel().getSelectedIndex());
                found = true;
                break;
            }

        }

        if (!found && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        startTimer();
    }

    // TimeOut zähler
    private void startTimer() {
        Timer timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                sb.delete(0, sb.length());
            }
        };
        timer.schedule(task, 1000);
    }

    private void resetTimer() {
        // Sobald etwas eingegeben ist, wird der Task wieder resetet, wenn nicht. wird nach der angegebenen Zeit die
        // Suche resetet
        if (task != null) {
            task.cancel();
        }
    }
}

