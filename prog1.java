import java.util.Scanner;

public class prog1{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int size,nop,opr,temp=0;
        int[] datarate= new int[100];
        System.out.println("Enter bucket size");
        size=sc.nextInt();
        System.out.println("Enter the no of packets");
        nop=sc.nextInt();
        System.out.println("Enter the data rate");
        for(int i=0;i<nop;i++)
        {
            datarate[i]=sc.nextInt();
        }
        System.out.println("enter the output rate");
        opr=sc.nextInt();
        for(int i=0;i<nop;i++)
        {
            if(datarate[i]>size)
            {
                System.out.println("Bucket overflow");
            }
            else
            {
                temp=datarate[i];
                while(temp>=opr)
                {
                    System.out.println("packet transmission "+opr);
                    temp=temp-opr;
                }
                System.out.println("Packet Transmission "+temp);
            }
        }
        
    }

}

