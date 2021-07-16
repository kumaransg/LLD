package com.pc.multilevelparkinglot;

/**
 * Printer to help in printing the output back to the user. Output medium can be changed here
 * anytime without affecting any of the other code. Currently, System.out is used. Tomorrow if file
 * has to be used to output, it can be changed here easily.
 */
public class OutputPrinter {

  public void welcome() {
    printWithNewLine("Welcome to Go-Jek Parking lot.");
  }

  public void end() {
    printWithNewLine("Thanks for using Go-Jek Parking lot service.");
  }

  public void notFound() {
    printWithNewLine("Not found");
  }

  public void statusHeader() {
    printWithNewLine("Slot No.    Registration No    Colour");
  }

  public void parkingLotFull() {
    printWithNewLine("Sorry, parking lot is full");
  }

  public void parkingLotEmpty() {
    printWithNewLine("Parking lot is empty");
  }

  public void invalidFile() {
    printWithNewLine("Invalid file given.");
  }

  public void printWithNewLine(final String msg) {
    System.out.println(msg);
  }
}
