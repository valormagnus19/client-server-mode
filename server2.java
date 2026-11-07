package serverdemo;
import java.net.*;
import java.io.*;
public class server2 {
    public static void main(String[] args)throws Exception{
        System.out.println("server is ready!");
        ServerSocket ss=new ServerSocket(343);
        System.out.println("server is waiting...");
        Socket server=ss.accept();
        System.out.println("server is connected!");
        
        BufferedReader fromClient=new BufferedReader(new InputStreamReader(server.getInputStream()));
        String num=fromClient.readLine();
        System.out.println("Number received from client is: "+num);
        
        int data=Integer.parseInt(num);
        long factorial=1;
        for(int i=2;i<=data;i++){
            factorial*=i;
        }
        PrintWriter toClient=new PrintWriter(server.getOutputStream(),true);
        toClient.println(factorial);
        System.out.println("Number sent to server is: "+data);
        
        fromClient.close();
        toClient.close();
        server.close();
        ss.close();
    }
}
