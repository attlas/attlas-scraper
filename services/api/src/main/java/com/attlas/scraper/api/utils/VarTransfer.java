package com.attlas.scraper.api.utils;

public class VarTransfer {

  private static volatile VarTransfer varTransfer;

  private VarTransfer () {}

  public static VarTransfer getInstance() {
    if (varTransfer == null) {
      synchronized (VarTransfer.class) {
        if (varTransfer == null) {
          varTransfer = new VarTransfer();
        }
      }
    }
    return varTransfer;
  }

  public int varAsInteger(String varVal) {
    String tempVal = varVal;
    return Integer.parseInt(tempVal);
  }

  public String varAsString(String varVal) {
    return varVal;
  }
}
