/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.costcoproject;

/**
 *
 * @author mitra
 */
public class Travel {
    public String destination;
    public String checkIn;
    public String checkOut;
    public String numOfRoom;
    public String numOfAdult;
    public String numOfChild;
    public String ageOfChild1;
    public String ageOfChild2;
    public String ageOfChild3;

    public Travel(String destination, String checkIn, String checkOut, String numOfRoom, String numOfAdult, String numOfChild, String ageOfChild1, String ageOfChild2, String ageOfChild3) {
        this.destination = destination;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numOfRoom = numOfRoom;
        this.numOfAdult = numOfAdult;
        this.numOfChild = numOfChild;
        this.ageOfChild1 = ageOfChild1;
        this.ageOfChild2 = ageOfChild2;
        this.ageOfChild3 = ageOfChild3;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getNumOfRoom() {
        return numOfRoom;
    }

    public void setNumOfRoom(String numOfRoom) {
        this.numOfRoom = numOfRoom;
    }

    public String getNumOfAdult() {
        return numOfAdult;
    }

    public void setNumOfAdult(String numOfAdult) {
        this.numOfAdult = numOfAdult;
    }

    public String getNumOfChild() {
        return numOfChild;
    }

    public void setNumOfChild(String numOfChild) {
        this.numOfChild = numOfChild;
    }

    public String getAgeOfChild1() {
        return ageOfChild1;
    }

    public void setAgeOfChild1(String ageOfChild1) {
        this.ageOfChild1 = ageOfChild1;
    }

    public String getAgeOfChild2() {
        return ageOfChild2;
    }

    public void setAgeOfChild2(String ageOfChild2) {
        this.ageOfChild2 = ageOfChild2;
    }

    public String getAgeOfChild3() {
        return ageOfChild3;
    }

    public void setAgeOfChild3(String ageOfChild3) {
        this.ageOfChild3 = ageOfChild3;
    }

    @Override
    public String toString() {
        return "Travel{" + "destination=" + destination + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", numOfRoom=" + numOfRoom + ", numOfAdult=" + numOfAdult + ", numOfChild=" + numOfChild + ", ageOfChild1=" + ageOfChild1 + ", ageOfChild2=" + ageOfChild2 + ", ageOfChild3=" + ageOfChild3 + '}';
    }

}
