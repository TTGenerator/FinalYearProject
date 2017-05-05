package net.mzouabi.ng2.server.dto;

import org.coinor.opents.*;


public class MyGreedyStartSolution extends MySolution 
{
    
    public MyGreedyStartSolution(){} // Appease clone()
    
    public MyGreedyStartSolution( double[][] customers )
    {
        // Greedy neighbor initialize
        int[] avail = new int[ customers.length ];
        tour = new int[ customers.length ];
        for( int i = 0; i < avail.length; i++ )
            avail[i] = i;
        for( int i = 1; i < tour.length; i++ )
        {
            int closest = -1;
            double dist = Double.MAX_VALUE;
            for( int j = 1; j < avail.length; j++ )
                if( (norm( customers, tour[i-1], j ) < dist) && (avail[j] >= 0) )
                {   
                    dist = norm( customers, tour[i-1], j );
                    closest = j;
                }   // end if: new nearest neighbor
            tour[i] = closest;
            avail[closest] = -1;
        }   // end for
        
        for( int i = 0; i < tour.length; i++ )
            System.out.println( 
             customers[tour[i]][0] + "\t" + customers[tour[i]][1] );
        
    }   // end constructor
    
    
    private double norm( double[][]matr, int a, int b )
    {
        double xDiff = matr[b][0] - matr[a][0];
        double yDiff = matr[b][1] - matr[a][1];
        return Math.sqrt( xDiff*xDiff + yDiff*yDiff );
    }   // end norm
    
    
}   // end class MyGreedyStartSolution
