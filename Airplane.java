import java.util.*;
import java.io.*;
public class Airplane {
    static class Seats{
        int[][] clusters;
        Seats(int[][] a){
            clusters=a;
        }
        Map<Integer,int[]> asile=new LinkedHashMap<>();
        Map<Integer,int[]> window=new LinkedHashMap<>();
        Map<Integer,int[]> middle=new LinkedHashMap<>();
        void fill_asile_and_window()
        {
            int i,j,m,key=1,key1=1;
            for(i=0;i<clusters.length ;i++)
            {
            for(m=0;m<clusters.length;m++)
            { if(i>=clusters[m][0])
                continue;
              for(j=0;j<clusters[m][1];j+=clusters[m][1]-1)
              {
                    if(m==0 &&  j==0)
                    {
                        int[] l=new int[3];
                        l[0]=m+1;
                        l[1]=i+1;
                        l[2]=j+1;
                        window.put(key1++,l);
                    }
                    else if(m==clusters.length-1 && j==clusters[m][1]-1)
                    {
                        int[] l=new int[3];
                        l[0]=m+1;
                        l[1]=i+1;
                        l[2]=j+1;
                        window.put(key1++,l);
                    }
                    else 
                    {
                    int[] l=new int[3];
                    l[0]=m+1;
                    l[1]=i+1;
                    l[2]=j+1;
                   asile.put(key++,l);
                    }
                }
                
            }
        }
        }
        void fill_middle(){
            int key=1,m,i,j;
            for(i=0;i<clusters.length ;i++)
            {
            for(m=0;m<clusters.length;m++)
            { 
              if(i>=clusters[m][0])
                     continue;
              for(j=1;j<clusters[m][1]-1; j++)
                {
                    int[] l=new int[3];
                    l[0]=m+1;
                    l[1]=i+1;
                    l[2]=j+1;
                   middle.put(key++,l);
                }
            }
        }
        }
        void output(int no_of_passengers){
           try { 
                   BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\jagadeshsri000\\Desktop\\Output.txt", true)); 
                   System.out.println("\t\t\tPassengers List:-");
                   out.write("\n\t\t\tPassengers List:-");
                   out.close();
            } 
            catch (IOException e) { 
                    System.out.println("exception occoured" + e); 
            }
           int count=1;
            Integer temp;
            while(count<=no_of_passengers && !asile.isEmpty()){ 
            int b[]=new int[3],i=0;
            for(int a:asile.get(count))
                b[i++]=a;
            String result="\n Passenger No : "+count+" , Type : 'Asile' , Compartment No:"+b[0]+" , Row No : "+b[1]+" , Seat No : "+b[2];
            System.out.println(result);
            try { 
                    BufferedWriter out = new BufferedWriter( new FileWriter("C:\\Users\\jagadeshsri000\\Desktop\\Output.txt", true)); 
                    out.write(result);
                    out.close();
           } 
           catch (IOException e) { 
                   System.out.println("exception occoured" + e); 
           }
             asile.remove(count);
             ++count;
            }
            no_of_passengers-=count;
            no_of_passengers+=1;
            int k=count;
            count=1;
            while(no_of_passengers >0 && count<=no_of_passengers && !window.isEmpty()){ 
            int b[]=new int[3],i=0;
            for(int a:window.get(count))
                b[i++]=a;
            String result="\n Passenger No : "+k+" , Type : 'Window' , Compartment No:"+b[0]+" , Row No : "+b[1]+" , Seat No : "+b[2];
            System.out.println(result);
            try { 
                    BufferedWriter out = new BufferedWriter( new FileWriter("C:\\Users\\jagadeshsri000\\Desktop\\Output.txt", true)); 
                    out.write(result);
                    out.close();
           } 
           catch (IOException e) { 
                   System.out.println("exception occoured" + e); 
           } window.remove(count);
             ++count;
             ++k;
            }
            no_of_passengers-=count;
            no_of_passengers+=1;
            count=1;
            while(no_of_passengers >0 && count<=no_of_passengers && !middle.isEmpty()){ 
            int b[]=new int[3],i=0;
            for(int a:middle.get(count))
                b[i++]=a;
            String result="\n Passenger No : "+k+" , Type : 'Middle' , Compartment No:"+b[0]+" , Row No : "+b[1]+" , Seat No : "+b[2];
            System.out.println(result);
            try { 
                    BufferedWriter out = new BufferedWriter( new FileWriter("C:\\Users\\jagadeshsri000\\Desktop\\Output.txt", true)); 
                    out.write(result);
                    out.close();
           } 
           catch (IOException e) { 
                   System.out.println("exception occoured" + e); 
           }middle.remove(count);
             ++count;
             ++k;
            }
        }
    }  
    public static void main(String[] args){
      
        int seat[][]={{3,2},{4,3},{2,3},{3,4}};
        Comparator<int[]> c=new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0])
				return o2[1]-o1[1];
				return o1[0]-o2[0];
			}
		};
		 Arrays.sort(seat,c);
        Seats s=new Seats(seat);
        s.fill_asile_and_window();
        s.fill_middle();
        int p=30;
        int temp=(seat[0][0]*seat[0][1])+(seat[1][0]*seat[1][1])+(seat[2][0]*seat[2][1])+(seat[3][0]*seat[3][1]);
        if(p>temp)
            System.out.println("\nInsufficient Seats.");
        else{
               s.output(p);
        }
    }
    }
