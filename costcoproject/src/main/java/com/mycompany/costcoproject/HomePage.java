/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.costcoproject;

/**
 *
 * @author mitra
 */
public class HomePage {
    public String menu;
    public String url;

    public HomePage(String menu, String url) {
        this.menu = menu;
        this.url = url;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "HomePage{" + "menu=" + menu + ", url=" + url + '}';
    }
    
    
}
