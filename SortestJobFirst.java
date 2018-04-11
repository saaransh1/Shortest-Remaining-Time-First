package sortest.job.first;
import java.util.ArrayList;
import java.util.*;
class A
{
   static int ind=0,indp=0;
    static void add(ArrayList gant,int[][] arvl,int[] scpu,int remain,int loc,ArrayList ct)
    {
        int z=1,diff=0,sub=0,subc=0;
        if(arvl[loc][2] == 0)
        {
            diff=1;
        }
        
        
           arvl[loc][2]=arvl[loc][2]-1;
            if(arvl[loc][2] == 0)
            {
                remain++;
                  if(gant.size()==1)
                  {
                      System.out.println("location is :"+loc);
                    gant.add("p"+arvl[loc][0]);
               
                    gant.add(1);
                    
                   
                  }
                else
                {
                    z=(int) gant.get((gant.size())-1);
                    gant.add("p"+arvl[loc][0]);
                    
                    gant.add(z+1);
                     
                  
                }
              
                    
            
            }
                
            
            else
            {
                
            
               if(gant.size()==1)
            {
               
               if(diff == 1)
               {
                diff=0;
                
               }
               else
               {
                   gant.add("p"+arvl[loc][0]);
                   gant.add(1);
                  
               }
               
              
                    
            }
            else
            {
                z=(int) gant.get((gant.size())-1);
                gant.add("p"+arvl[loc][0]);
              
               gant.add(z+1);
               
              
            }
               
               
               
            }
        
    }
    void mini(int n,int[] pro,int[] ar,int[] cpu,ArrayList gant,int[][] arvl,ArrayList ct)
    {
        gant.add(0,0);
        int m1,m2 = 0,m3,remain=0,x=0,y=0,loc = 0,count=0,value,swap,swap2,swap3,z=1,flag1=0,flag=0,index=0,occur = 0;
 
        int[] sar=ar;
        int[] scpu=cpu;
        Arrays.sort(sar);
        Arrays.sort(scpu);
        
        //----------------------arrival aaray---------------------------------
        
        
        
        //-------------------------------------------------------------------
        //---------------sorting on the basis of arrival time---------------------
        
        for(x=0;x<n;x++)
	{
            for(y=x+1;y<n;y++)
	{
	
			if(arvl[x][1]>arvl[y][1])
			{
			
				swap=arvl[x][0];
				arvl[x][0]=arvl[y][0];
				arvl[y][0]=swap;
			
				swap2=arvl[x][1];
				arvl[x][1]=arvl[y][1];
                                arvl[y][1]=swap2;
				
				swap3=arvl[x][2];
				arvl[x][2]=arvl[y][2];
				arvl[y][2]=swap3;
			
			}
		}
		
	}
        
        System.out.println("sorted arrival array");
        for(x=0;x<n;x++)
        {
            for(y=0;y<3;y++)
            {
                System.out.print(arvl[x][y]);
                System.out.print("\t");
            }
            System.out.print("\n");
            
        }
        //------------------------------------------------------------------------
        //-------------------------first loop--------------------------------------
        go:
        for(x=0;remain!=n;x++)
        {
            int c=0;
         System.out.println("x is :"+x);
            //------------------------------second loop------------------------------
          
            if(x==n)
           {
               //check all process become zero or not---------------------
               int non_zero3=0,zero2=0,np1=0;

                for(int q=0;q<n;q++)
                {
                                        
                    if(arvl[q][2]==0)
                    {
                        zero2++;
                    }
                    else
                    {
                        non_zero3++;
                    }
                    np1++;
                                            
                                      
                }
                                    
                if(zero2 == np1)
                {
                    break;
                }
                else
                {
                    x=0;
                    index++;
                }
                              
               
               
           }
            
           if(gant.size()==1)
            {
                value=0;
            }
            else
            {
                z=(int) gant.get((gant.size())-1);
                value=z;
            }
           //-----------checking condition for gant contains total no. of process if true so out of outer loop ---
           if(value >= arvl[n-1][1])
           {
               flag=1;
               break go;
           }
           //----------------------------------------end condition ----------------------------------------------
           //----------------------------------- if start ----------------------------------------------
         
          
           if((arvl[x][1]<=value) && (arvl[x][2] > 0) && (arvl[x][2] != scpu[index]))
           {
               System.out.println("inside main if");
               loc=x;
           System.out.println("loc is :"+loc);
                occur = 0;
               if(x>=0)
               {
               
               for(int q=0;q<n;q++)
                   {
                       if(arvl[q][1]<=(int)(gant.get(gant.size()-1)))
                       {
                           occur=q;
                       }
                   }
                   m2=arvl[0][2];
                   if(m2<=-1)
                   {
                       m2=0;
                   }
                   loc=0;
                   minimum1:
                   for(int pr=0;pr<occur;pr++)
                   {
                       if(m2==0)
                       {
                           pr++;
                           m2=arvl[pr][2];
                           loc=pr;
                           if(pr>=occur)
                           {
                               break;
                           }
                           while(arvl[pr][2]==0)
                           {
                               pr++;
                               m2=arvl[pr][2];
                                loc=pr;
                               if(pr>=occur)
                               {
                                   break minimum1;
                               }
                           }
                           
                       }
                       if(arvl[pr+1][2]==0)
                       {
                           pr++;
                           c=1;
                           
                           if(pr>=occur)
                           {
                               break;
                           }
                           while(arvl[pr+1][2]==0)
                           {
                               pr++;
                               if(pr>=occur)
                               {
                                   break minimum1;
                               }
                           }
                       }
                      
                          
                       if(m2 > arvl[pr+1][2])
                       {
                           System.out.println("m2 is :"+m2+">"+arvl[pr+1][2]);
                           m2=arvl[pr+1][2];
                           loc=pr+1;
                           
                       }
                       else
                       {
                           
                            if(m2==arvl[pr+1][2])
                            {
                                if(c==0)
                                {
                                    m2=m2;
                                    loc=loc;
                                }
                            else
                            {
                                m2=arvl[pr-1][2];
                                loc=pr-1;
                            }
                            }
                       }
                       
                   
                       
                   }
               }
             System.out.println("m2 is :"+m2);
             System.out.println("loc is :"+loc);
               A.add(gant, arvl, scpu,remain,loc,ct);
              
           
            
           }
           //--------------------------------------- if end-------------------------------------------
           //------------------------------------------else part--------------------------------------
           else {
             //  System.out.println("arvl ["+x+"]["+1+"] is :"+arvl[x][1]+" gant value is :"+gant.get((gant.size())-1));
               if((arvl[x][1] > (int)( gant.get((gant.size())-1))))//&& (arvl[x][2] != scpu[index]))
               {
                   
                       loc=x;
                    if(gant.size()==1)
                    {
                        gant.add("idle");
               
                        gant.add(arvl[x][1]);
               
                    
               occur = 0;
               if(x>=0)
               {
                  
                   for(int q=0;q<n;q++)
                   {
                     
                       if(arvl[q][1]<=(int)(gant.get(gant.size()-1)))
                       {
                           occur=q;
                       
                       }
                   }
                   m2=arvl[0][2];
                   if(m2<=-1)
                   {
                       m2=0;
                   }
                   loc=0;
                   minimum:
                   for(int pr=0;pr<occur;pr++)
                   {
                   
                       if(m2==0)
                       {
                        
                           pr++;
                           
                           m2=arvl[pr][2];
                           loc=pr;
                          
                           if(pr>=occur)
                           {
                           
                               break;
                           }
                           while(arvl[pr][2]==0)
                           {
                               pr++;
                                m2=arvl[pr][2];
                                loc=pr;
                               if(pr>=occur)
                               {
                                   break minimum;
                               }
                           }
                           
                           
                       }
                       if(arvl[pr+1][2]==0)
                       {
                           pr++;
                           c=1;
                           
                           if(pr>=occur)
                           {
                               break;
                           }
                           while(arvl[pr+1][2]==0)
                           {
                                pr++;
                                if(pr>=occur)
                                {
                                    break minimum;
                                }
                            }
                       }
                       
                          
                       if(m2 > arvl[pr+1][2])
                       {
                           m2=arvl[pr+1][2];
                           loc=pr+1;
                           
                       }
                       else
                       {
                           
                            if(m2==arvl[pr+1][2])
                            {
                                if(c==0)
                                {
                                    m2=m2;
                                    loc=loc;
                                }
                            else
                            {
                                m2=arvl[pr-1][2];
                                loc=pr-1;
                            }
                            }
                       }
                       
                  
                       
                   }
               }
                     //   System.out.println("process in the location "+loc+" is going to be add in gant chart");
               //again check for same arrival time----------------------------------------------
                        A.add(gant, arvl, scpu,remain,loc,ct);
                        if(arvl[x][2]==scpu[index])
                        {
                            
                            index++;
                        }
              
                    }
                    else
                    {
                        
                        int non_zero1=0,zero1=0,np=0;
                                if((int)(gant.get(gant.size()-1)) != arvl[x][1])
                                {
                                    for(int q=0;q<n;q++)
                                    {
                                        if(arvl[q][1]<=((int)(gant.get(gant.size()-1))))
                                        {
                                            if(arvl[q][2]==0)
                                            {
                                                zero1++;
                                            }
                                            else
                                            {
                                                non_zero1++;
                                            }
                                            np++;
                                            
                                        }
                                    }
                                    
                                    if(zero1 == np)
                                    {
                                        flag1=0;
                                    }
                                    else
                                    {
                                        flag1=1;
                                    }
                                }
                        
                        if(flag1 == 1)
                        {
                             loc=x-1;
                             int x1=x-1;
                             
                             
                             while_loop:
                            while((int)(gant.get(gant.size()-1))!=arvl[x][1])
                            {
                               
                            if(x1>0)
                            {
                                for(int q=0;q<n;q++)
                                {
                                    if((arvl[q][1]<=(int)(gant.get(gant.size()-1)))&&(arvl[q][1]<arvl[x][1]))
                                    {
                                        occur=q;
                                    }
                                }
                                
                                m2=arvl[0][2];
                                if(m2<=-1)
                                {
                                    m2=0;
                                }
                                loc=0;
                                
                                exceed3:
                                for(int pr=0;pr<occur;pr++)
                                {
                                    if(m2==0)
                                    {
                                        pr++;
                                        m2=arvl[pr][2];
                                        loc=pr;
                                        if(pr>=occur)
                                        {
                                            break;
                                        }
                                        while(arvl[pr][2]==0)
                                        {
                                            pr++;
                                            m2=arvl[pr][2];
                                            loc=pr;
                                            if(pr>=occur)
                                            {
                                                break exceed3;
                                            }
                                        }
                                      
                                        
                                    }
                                    if(arvl[pr+1][2]==0)
                                    {
                                        pr++;
                                        c=1;
                                        if(pr>=occur)
                                        {
                                            break;
                                        }
                                    while(arvl[pr+1][2]==0)
                                    {
                                        pr++;
                                        if(pr>=occur)
                                        {
                                            break exceed3;
                                        }
                                    }
                                    }
                       
                          
                                    if(m2 > arvl[pr+1][2])
                                    {
                                        m2=arvl[pr+1][2];
                                        loc=pr+1;
                           
                                    }
                                    else
                                    {
                                        if(m2==arvl[pr+1][2])
                                        {
                                            if(c==0)
                                            {
                                                m2=m2;//arvl[pr][2];
                                                loc=loc;//pr;
                                            }
                                        else
                                        {
                                            m2=arvl[pr-1][2];
                                            loc=pr-1;
                                        }
                                        }
                                    }
                       
                  
                       
                                }
                            }
                                
                              // System.out.println("(inside while loop ) process in this location is going to be add in gant chart :"+loc); 
                                A.add(gant, arvl, scpu, remain, loc,ct);
                                int non_zero=0,zero=0,num=0;
                                if((int)(gant.get(gant.size()-1)) != arvl[x][1])
                                {
                                    for(int q=0;q<n;q++)
                                    {
                                        if(arvl[q][1]<=arvl[x-1][1])
                                        {
                                            if(arvl[q][2]==0)
                                            {
                                                zero++;
                                            }
                                            else
                                            {
                                                non_zero++;
                                            }
                                            
                                            num++;
                                        }
                                    }
                                }
                                
                                if(zero == num)
                                {
                                    break while_loop;
                                }
                                
                            }
                            
                            
                             occur=0;
                            if(x>0)
                            {
                                
                                for(int q=0;q<n;q++)
                                {
                                    if(arvl[q][1]<=(int)(gant.get(gant.size()-1)))
                                    {
                                        occur=q;
                                    }
                                }
                                
                                m2=arvl[0][2];
                                if(m2<=-1)
                                {
                                    m2=0;
                                }
                                loc=0;
                                exceed2:
                                for(int pr=0;pr<occur;pr++)
                                {
                                    if(m2==0)
                                    {
                                        pr++;
                                        m2=arvl[pr][2];
                                        loc=pr;
                                        if(pr>=occur)
                                        {
                                            break;
                                        }
                                        while(arvl[pr][2]==0)
                                        {
                                            pr++;
                                            m2=arvl[pr][2];
                                            loc=pr;
                                            if(pr>=occur)
                                            {
                                                break exceed2;
                                            }
                                        }
                                    }
                                    if(arvl[pr+1][2]==0)
                                    {
                                        pr++;
                                        c=1;
                                    if(pr>=occur)
                                    {
                                        break;
                                    }
                                    while(arvl[pr+1][2]==0)
                                    {
                                        pr++;
                                        if(pr>=occur)
                                        {
                                            break exceed2;
                                        }
                                    }
                                    }
                       
                          
                                    if(m2 > arvl[pr+1][2])
                                    {
                                        m2=arvl[pr+1][2];
                                        loc=pr+1;
                           
                                    }
                                    else
                                    {
                                        if(m2==arvl[pr+1][2])
                                        {
                                            if(c==0)
                                            {
                                                m2=m2;
                                                loc=loc;
                                            }
                                        else
                                        {
                                            m2=arvl[pr-1][2];
                                            loc=pr-1;
                                        }
                                        }
                                    }
                       
                 
                       
                                }
                            }
                            
                            
                            A.add(gant, arvl, scpu, remain, loc,ct);
                        }
                        else
                        {
                            
                        
                        loc=x;
                        gant.add("idle");
              
                        gant.add(arvl[x][1]);
                        A.add(gant, arvl, scpu,remain,loc,ct);
                    }
            
                    }
                  
                }
               else{
                   
               
                   if((scpu[index]!=0)&&(arvl[x][2]==scpu[index]))
                    {
                        
                        if(gant.size()==1)
                        {
                            gant.add("p"+arvl[x][0]);
                            gant.add(scpu[index]);
                            

                            scpu[index]=scpu[index]-scpu[index];
                           
                            arvl[x][2]=arvl[x][2]-arvl[x][2];
                            index++;
                         
                        }
                    else
                    {
                       occur=0;
                        if(x>0)
                            {
                                
                                for(int q=0;q<n;q++)
                                {
                                    if(arvl[q][1] <= (int)(gant.get(gant.size()-1)))
                                    {
                                        occur=q;
                                    }
                                }
                                m2=arvl[0][2];
                                if(m2<=-1)
                                {
                                    m2=0;
                                }
                                loc=0;
                                exceed1:
                                for(int pr=0;pr<occur;pr++)
                                {
                                    if(m2==0)
                                    {
                                        pr++;
                                        m2=arvl[pr][2];
                                        loc=pr;
                                        
                                        //exceed condition--------------
                                        
                                        if(pr>=occur)
                                        {
                                            break;
                                        }
                                        while(arvl[pr][2]==0)
                                        {
                                            pr++;
                                            m2=arvl[pr][2];
                                            loc=pr;
                                            if(pr>=occur)
                                            {
                                                break exceed1;
                                            }
                                        }
                                    }
                                    if(arvl[pr+1][2]==0)
                                    {
                                        pr++;
                                        c=1;
                                        if(pr>=occur)
                                        {
                                            break;
                                        }
                                        while(arvl[pr+1][2]==0)
                                        {
                                            pr++;
                                            if(pr>=occur)
                                            {
                                                break exceed1;
                                            }
                                        }
                                    }
                       
                          
                                    if(m2 > arvl[pr+1][2])
                                    {
                                        m2=arvl[pr+1][2];
                                        loc=pr+1;
                           
                                    }
                                    else
                                    {
                                        if(m2==arvl[pr+1][2])
                                        {
                                            if(c==0)
                                            {
                                                m2=arvl[pr][2];
                                                loc=pr;
                                            }
                                            else
                                            {
                                                m2=arvl[pr-1][2];
                                                loc=pr-1;
                                            }
                                        }
                                    }
                       
                   
                       
                                }
                            }
                            
                     
                     
                      if(arvl[loc][2]!=scpu[index])
                      {
                          System.out.println("loc is :"+loc);
                          System.out.println("inside arvl[loc][2]!=scpu[index] if");
                          A.add(gant, arvl, scpu, remain, loc,ct);
                      }
                      else
                      {
                          System.out.println("loc is :"+loc);
                          System.out.println("inside arvl[loc][2]==scpu[index] if");
                         z=(int) (gant.get(gant.size()-1));
                       gant.add("p"+arvl[loc][0]);
                       
                      gant.add(z+arvl[loc][2]);
                     
                      scpu[index]=scpu[index]-scpu[index];
                      arvl[loc][2]=arvl[loc][2]-arvl[loc][2];
                     
                      index++;
                      }
                       
                      
                      
                    }
                }
               
                   //------------------------- else part if(scpu[index]==0) -----------------------------
                 else
                   {
                       //---------check next process arvl is less than gant updated value---------------
                       if(arvl[x][1]<=((int)(gant.get(gant.size()-1))))
                       {
                           
                occur = 0;
               if(x>=0)
               {
                   for(int q=0;q<n;q++)
                   {
                       if(arvl[q][1]<=(int)(gant.get(gant.size()-1)))
                       {
                           occur=q;
                       }
                   }
                   m2=arvl[0][2];
                   if(m2<=-1)
                   {
                       m2=0;
                   }
                   loc=0;
                 
                   exceed:
                   for(int pr=0;pr<occur;pr++)
                   {
                       if(m2==0)
                       {
                           pr++;
                           m2=arvl[pr][2];
                           loc=pr;
                           
                           if(pr>=occur)
                           {
                               break;
                           }
                           while(arvl[pr][2]==0)
                           {
                               pr++;
                               m2=arvl[pr][2];
                               loc=pr;
                               if(pr>=occur)
                               {
                                   break exceed;
                               }
                           }
                       }
                       if(arvl[pr+1][2]==0)
                       {
                           pr++;
                           c=1;
                           if(pr>=occur)
                           {
                               break;
                           }
                           while(arvl[pr+1][2]==0)
                           {
                               pr++;
                               if(pr>=occur)
                           {
                               break exceed;
                           }
                           }
                           
                       }
                       
                          
                       if(m2 > arvl[pr+1][2])
                       {
                           m2=arvl[pr+1][2];
                           loc=pr+1;
                          
                       }
                       else
                       {
                           
                            if(m2==arvl[pr+1][2])
                            {
                                if(c==0)
                                {
                                    m2=m2;
                                    loc=loc;
                                }
                            else
                            {
                                m2=arvl[pr-1][2];
                                loc=pr-1;
                            }
                            }
                       }
                       
                   
                       
                   }
               }
                         A.add(gant, arvl, scpu, remain, loc, ct);
                         
                       }
                     
                       index++;
                       
                   }
                   
                   
                   
             
          
               
           }   
               
           } 
           //-----------------------------------------------else end -----------------------------------
           //----------------------------------------------- if part ------------------------------------
          if(arvl[x][2] == 0)
          {
          
              
              
              remain++;
               //x++;
          }
         
          //-----------------------------------------------------if end ----------------------------------
           //}//-----------------------------------second end---------------------------
           
        }//-----------------------------first end-------------------------
        
       //--------------------sjf--------------------------------------------------------------
    if(flag==1)
    {
      //  System.out.println("inside sjf ");
        int min=0,p;
    ArrayList scp=new ArrayList();
    
    for(x=0;x<n;x++)
    {
        if(arvl[x][2]>0)
        {
            scp.add(arvl[x][2]);
        }
    }
    Collections.sort(scp);
   
    
        for(x=0;x<scp.size();x++)
        {
            for(y=0;y<n;y++)
            {
               
                if((int)(scp.get(x))==arvl[y][2])
                {
                   
                    min=(int)(scp.get(x));
                    loc=y;
                    z=(int)(gant.get((gant.size())-1));
                    gant.add("p"+arvl[y][0]);
                    gant.add(z+min);
                   
                    arvl[y][2]=arvl[y][2]-arvl[y][2];
                   
                    break;
                }
            }
    }
    
           
   
        
    } 
        
       
    
    
    //---------------------------------------------------------------------------------------
    }
    
    
}
public class SortestJobFirst{

   
    
    public static void main(String[] args) {
        
        Scanner input=new Scanner(System.in);
       int n,c1=0,c2=1,c3=2,y;
       
       System.out.print("Enter number of Process :");
       n=input.nextInt();
       ArrayList gant=new ArrayList();
       int process[]=new int[n];
        int arrival[]=new int[n];
        int art[]=new int[n];
         int burst[]=new int[n];
         int cpu_time[]=new int[n];
         int[][] arvl=new int[n][3];
         ArrayList ct=new ArrayList();
         for(int i=0;i<n;i++)
         {
        
             
             process[i]=i+1;
             ct.add("p"+(i+1));
             ct.add(0);
             arvl[i][c1]=i+1;
             
             
             System.out.printf("Enter process %d Arrival time :",i+1);
             arrival[i]=input.nextInt();
             arvl[i][c2]=arrival[i];
             art[i]=arrival[i];
             
             System.out.printf("Enter process %d Burst time :",i+1);
             burst[i]=input.nextInt();
             if(burst[i] > 10)
             {
                 System.out.println("Burst Time should be less than or equal to 10");
                 System.out.println("Do you want to enter Again(1 for yes/0 for no)");
                 y = input.nextInt();
                
                 while(y == 1)
                 {
                     System.out.printf("Enter process %d Burst time :",i+1);
                     burst[i]=input.nextInt();
                     if(burst[i] > 10)
                     {
                        System.out.println("burst Time should be less than or equal to 10");
                        System.out.println("Do you want to enter Again(1 for yes/0 for no)");
                        y = input.nextInt();
                        if(y == 0)
                        {
                            if(burst[i] < 10)
                            {
                                break;
                            }
                            else
                            {
                                System.exit(0);
                            }
                       
                        }
                     }
                     else
                     {
                         break;
                     }
                 }
             }
             cpu_time[i]=burst[i];
             arvl[i][c3]=burst[i];
             
         
         }
         
         System.out.println("\n\t\t Process\tArrival Time\tBurst Time");
         for(int i=0;i<n;i++)
         {
             System.out.println("\n\t\t"+process[i]+"\t\t"+arrival[i]+"\t\t"+burst[i]);
         }
         
         A obj=new A();
         obj.mini(n, process, arrival, burst,gant,arvl,ct);
         System.out.println("gant chart is :");
         for(int i=0;i<gant.size();i++)
         {
             System.out.print(gant.get(i));
             System.out.print("<-->");
         }
         
       
         int comp=0,comp1,tt=0,cmpt=1;
         for(int i=0;i<n;i++)
         {
              comp=gant.lastIndexOf("p"+arvl[i][0]);
              comp1=ct.indexOf("p"+arvl[i][0]);
              ct.set(comp1+1,(int)(gant.get(comp+1)));
              
         }
         int[] turn_around=new int[n];
         int[] waiting_time=new int[n];
         for(int i=0;i<n;i++)
         {
             turn_around[i]=((int)(ct.get(cmpt))-art[i]);
            
             cmpt=cmpt+2;
         }
         
         
         for(int i=0;i<n;i++)
         {
             waiting_time[i]=turn_around[i]-cpu_time[i];
         }
       
         System.out.println("\n Process \t Completion Time \t Turn Around Time \t Waiting Time");
         for(int i=0;i<ct.size();i++)
         {
             
                  System.out.println(ct.get(i)+"<--> \t\t\t "+ct.get(i+1)+" \t\t\t "+turn_around[tt]+" \t\t "+waiting_time[tt]+"\n");
            i++;
             tt++;
             
         }
         
         int sum=0,wsum=0;
         for(int i=0;i<turn_around.length;i++)
         {
             sum=sum+turn_around[i];
         }
         
         for(int i=0;i<turn_around.length;i++)
         {
             wsum=wsum+waiting_time[i];
         }
         
        System.out.println("\n\tAverage Waiting Time = "+wsum+"/"+n+" : "+((float)wsum/(float)n));
        System.out.println("\n\tAverage Turn Around Time is = "+sum+"/"+n+" : "+((float)sum/(float)n));
    }
    
}
