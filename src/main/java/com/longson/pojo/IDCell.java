package com.longson.pojo;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class IDCell<S,T> implements Callback<TableColumn<S,T>, TableCell<S,T>> {

    @Override
    public TableCell<S, T> call(TableColumn<S, T> param) {

        TableCell cell=new TableCell(){
            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                this.setText(null);
                this.setGraphic(null);
                if(!empty){
                    int rowindex=this.getIndex()+1;
                    this.setText(String.valueOf(rowindex));
                }
            }
        };
        return cell;
    }
}


