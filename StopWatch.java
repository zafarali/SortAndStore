public class StopWatch{
  private long startTime;
  private long stopTime;
  //setting the time
  public void start(){
   startTime = System.nanoTime(); 
  }//end startTime
  
  public void stop(){
   stopTime = System.nanoTime(); 
  }//end stopTime
  
  //returning the time by calculating the differences between start and stop time
  //to get the different denominations of time we divide it by its respective 10^x to convert it
  
  public long getTimeNano(){
    long timeDifferenceInNano = stopTime - startTime;
    return timeDifferenceInNano;
  }//end getTimeNano
  public long getTimeMicro(){
    long timeDifferenceInMicro = (stopTime - startTime) / 1000;
    return timeDifferenceInMicro;
  }//end getTimeMicro
  public long getTimeMilli(){
   long timeDifferenceInMilli = (stopTime - startTime) / 1000000;
   return timeDifferenceInMilli;
  }//end getTimeMilli
  public long getTimeSeconds(){
   long timeDifferenceInSeconds = (stopTime - startTime) / 1000000000;
   return timeDifferenceInSeconds;
  }//end getTimeSeconds
  
}//end class