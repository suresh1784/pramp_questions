import java.io.*;
import java.util.*;

class Solution {

  static double findGrantsCap(double[] grantsArray, double newBudget) {
    Arrays.sort(grantsArray);
    int n = grantsArray.length;
    for(int i=0;i<n/2;i++) {
     double temp = grantsArray[i];
     grantsArray[i] = grantsArray[n-(i+1)];
     grantsArray[n-(i+1)] = temp;
      }

    grantsArray = Arrays.copyOf(grantsArray, n + 1);
    grantsArray[n]=0;
    double surplus = 0;
    for (double j : grantsArray) {
      surplus+=j;
    }
    surplus-=newBudget;

    if (surplus<=0) {
      return grantsArray[0];
    }

    for (int i=0;i<n;i++) {
      surplus-=(i+1)*(grantsArray[i]-grantsArray[i+1]);
      if (surplus<=0) {
        return grantsArray[i+1]-(surplus/(i+1));
      }
    }
    return 0;
  }
  public static void main(String[] args) {
  }
}