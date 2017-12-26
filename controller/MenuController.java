package controller;

import views.MenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {

    private MenuView menuView;

    public MenuController(MenuView menuView){
        this.menuView=menuView;
    }


    public void onClickQuit(){
        menuView.getJFrame().dispose();
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
