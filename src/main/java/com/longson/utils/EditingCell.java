package com.longson.utils;

import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.scene.control.*;

/**
 *
 * @param <T>  table 对象
 * 去焦点自动提交
 *
 * 内置TextFieldTableCell在编辑后必须回车才能提交保存。如果需要理解编辑框焦点自动提交保存，可使用自定义的渲染器，示例如下
 * 只需要在表格中 为当前列创建该对象
 *
 *
 */
public class EditingCell<T> extends TableCell<T, String> {
    private TextField textField;

    public EditingCell() {
    }

    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            createTextField();
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText((String) getItem());
        setGraphic(null);
    }

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                }
                setText(null);
                setGraphic(textField);
            } else {
                setText(getString());
                setGraphic(null);
            }
        }
    }

    @Override
    public void commitEdit(String newValue) {
        if (!isEditing() && !newValue.equals(this.getItem())) {
            TableView<T> table = this.getTableView();
            if (this.getTableView() != null) {
                TableColumn<T, String> col = this.getTableColumn();
                TableColumn.CellEditEvent<T, String> event = new TableColumn.CellEditEvent<T, String>(table,
                        new TablePosition<T, String>(table, this.getIndex(), col), TableColumn.editCommitEvent(),
                        newValue);
                Event.fireEvent(col, event);
            }
        }
        super.commitEdit(newValue);
        updateItem(newValue, false);
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        textField.focusedProperty().addListener((ob, old, now) -> {
            if (!now) {
                commitEdit(textField.getText());
            }
        });
    }

    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
}

