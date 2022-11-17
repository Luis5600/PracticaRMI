package server;

import java.net.*;
import java.text.*;
import java.util.*;
import rmi.EchoInt;


public class EchoObject implements EchoInt {
  String myURL="127.0.0.0";

  public EchoObject(){
     try {
          myURL=InetAddress.getLocalHost().getHostName();
     } catch (UnknownHostException e) {
          myURL="127.0.0.0";
     }
  }

  public String echo(String input)
  {
     Date h = new Date();
     String fecha = DateFormat.getTimeInstance(3,Locale.FRANCE).format(h);
     String ret = myURL + ":" + fecha + "> " +  input;
     try {
           Thread.sleep(3000);  ret = ret + " (retrasada 3 segundos)";
     } catch (InterruptedException e) {}

     return ret;
  }
}
