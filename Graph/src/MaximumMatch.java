



// Program for transitive closure using Floyd Warshall Algorithm
// A Java program to find maximal
// Bipartite matching.
import java.util.*;
import java.lang.*;
import java.io.*;

public class MaximumMatch
{
    
    
    // Main
    public static void main (String[] args)throws java.lang.Exception
    {
        // Let us create a bpGraph shown
        // in the above example
        boolean bpGraph[][] = new boolean[][]{
             
                {true, true, false, false, false, false}, //Ahmad
                
                {false, false, false, false, false, true},//mahmoud
              
                {true, false, false, true, false, false},  //Eman
                
                {false, false, true, false, false, false},//fatimah
              
                {false, false, false, true, true, false}, // keamel
                
                {false, false, false, false, false, true}};//nojood
        
           //Creat an object of maximumMatch class represent the Maximum number of applicants that can get job
      MaximumMatch MaxNumber = new MaximumMatch();
       
       
       // Print the  Maximum number of applicants that can get job
        System.out.println("\n MAXIMUM NUMBER OF APPLICANTS THAT CAN GET JOB IS ------------>>>"+MaxNumber.maxNum(bpGraph));
        System.out.println();
                
    }
    
    
    
    
    
    
  // M  is reprsented the number of applicants
    static final int M = 6;   
    
    //N is reprsented the number of  hospitals.
    static final int N = 6;  
    //the Match varibale reprsented SEEN
    static boolean Match[]={ false, false, false, false, false, false };
    
    // store the hospitals name
static String  hospital[]={"King AbdelazizUniversity" ,
        "King Fahd","East Jeddah","King Fahad Armed Forces " ,
        "King Faisal Specialist" , "Ministry of National Guard "};

     //store the applicants name
    static String  app[]={"Ahmed","Mahmoud","Eman","Fatimah","Kamel","Nojood"};
    
   // we have a recursive function thatreturns true if a matching for vertex u is possible
    boolean bpm(boolean bpGraph[][], int u, int matchR[])
    {
        // Compareint one by one
        for (int v = 0; v < N; v++)
        {
          
            // If applicant u is interested in job v and v is not visited
            //So will print">> before: "+v+", "+Match[]);
            if (bpGraph[u][v] && !Match[v])
            {
                // So mean make  v as visited
              Match [v] = true;
                //System.out.println("  ===> after: "+v+", "+seen[v]);
                // If job 'v' is not assigned to
                // an applicant OR previously
                // assigned applicant for job v (which
                // is matchR[v]) has an alternate job available.
                // Since v is marked as visited in the
                // above line, matchR[v] in the following
                // recursive call will not get job 'v' again


                if (matchR[v] < 0|| bpm(bpGraph, matchR[v], matchR))
                {
                    //if(seen[v]){
                    matchR[v] = u;
                    return true;
        
                }
            }
        }
        return false;
    }

    // Returns maximum number
    // of matching from M to N
    int maxNum(boolean bpGraph[][])
    {

        // An array to keep track of the
        // applicants assigned to jobs.
        // The value of matchR[i] is the
        // applicant number assigned to job i,
        // the value -1 indicates nobody is assigned.
        int matchR[] = new int[N];

        // Initially all jobs are available
        for(int i = 0; i < N; ++i)
            matchR[i] = -1;

        // Count of jobs assigned to applicants
        int result = 0;
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" ************************MAXIMUM MATCHING*******************************) ");
         System.out.println("-------------------------------------------------------------------------");
         System.out.println();
         System.out.println("-----------------------------BEFORE--------------------------------------");
        for (int u = 0; u < M; u++)
        {
            // Mark all jobs as not seen
            // for next applicant.
            boolean seen[] =new boolean[N] ;
        System.out.println("----------------------THE NUMBER OF ITERATION IS ("+u+") -------------------- ");
        //System.out.println();
            for(int i = 0; i < N; ++i) {

                seen[i] = false;
                if (matchR[i] > -1) {

                   
                    System.out.println((hospital[i]) + "th hospital has  patient : " + (app[matchR[i]]));
                

                } else {

                    System.out.println((hospital[i]) + "th hospital has no patient");
                }

                System.out.println();
            }

            // Find if the applicant 'u' can get a job
            if (bpm(bpGraph, u, matchR))
                result++;
        }
        return result;
    }

}

