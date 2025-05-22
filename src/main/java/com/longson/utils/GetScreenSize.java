package com.longson.utils;

import javafx.stage.Screen;

import java.awt.*;

public class GetScreenSize {

    public   static  double getScreenwidth= Screen.getPrimary().getBounds().getWidth();
    public   static  double getScreenheight= Screen.getPrimary().getBounds().getHeight();

}
