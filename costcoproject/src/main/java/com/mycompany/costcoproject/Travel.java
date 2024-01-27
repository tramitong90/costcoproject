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
    public double numOfRoom;
    public double numOfAdult;
    public double numOfChild;
    public double ageOfChild1;
    public double ageOfChild2;
    public double ageOfChild3;

    public Travel(String destination, String checkIn, String checkOut, double numOfRoom, double numOfAdult, double numOfChild, double ageOfChild1, double ageOfChild2, double ageOfChild3) {
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

    public double getNumOfRoom() {
        return numOfRoom;
    }

    public void setNumOfRoom(double numOfRoom) {
        this.numOfRoom = numOfRoom;
    }

    public double getNumOfAdult() {
        return numOfAdult;
    }

    public void setNumOfAdult(double numOfAdult) {
        this.numOfAdult = numOfAdult;
    }

    public double getNumOfChild() {
        return numOfChild;
    }

    public void setNumOfChild(double numOfChild) {
        this.numOfChild = numOfChild;
    }

    public double getAgeOfChild1() {
        return ageOfChild1;
    }

    public void setAgeOfChild1(double ageOfChild1) {
        this.ageOfChild1 = ageOfChild1;
    }

    public double getAgeOfChild2() {
        return ageOfChild2;
    }

    public void setAgeOfChild2(double ageOfChild2) {
        this.ageOfChild2 = ageOfChild2;
    }

    public double getAgeOfChild3() {
        return ageOfChild3;
    }

    public void setAgeOfChild3(double ageOfChild3) {
        this.ageOfChild3 = ageOfChild3;
    }

    @Override
    public String toString() {
        return "Travel{" + "destination=" + destination + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", numOfRoom=" + numOfRoom + ", numOfAdult=" + numOfAdult + ", numOfChild=" + numOfChild + ", ageOfChild1=" + ageOfChild1 + ", ageOfChild2=" + ageOfChild2 + ", ageOfChild3=" + ageOfChild3 + '}';
    }

}
