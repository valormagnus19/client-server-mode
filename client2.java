
package serverdemo;
import java.io.*;
import java.net.*;

public class client2 {
    public static void main(String[]args)throws Exception{
        System.out.println("client is ready!");
        Socket client=new Socket("localhost",343);
        System.out.println("Enter a number to send it to server:");
        BufferedReader fromUser=new BufferedReader(new InputStreamReader(System.in));
        String num=fromUser.readLine();
              
        PrintWriter toServer=new PrintWriter(client.getOutputStream(),true);
        toServer.println(num);
        System.out.println("number sent to server is: "+num);
        
        BufferedReader fromServer=new BufferedReader(new InputStreamReader(client.getInputStream()));
        String data=fromServer.readLine();
        System.out.println("number received from server is: "+data);
        
        toServer.close();
        fromServer.close();
        fromUser.close();
        client.close();
        
        
    }
}
