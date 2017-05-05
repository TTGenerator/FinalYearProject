package net.mzouabi.ng2.server.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.coinor.opents.*;
import net.mzouabi.ng2.server.dto.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/tabusearch")
public class TabuController{

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void mainmethod() {
        // Initialize our objects
        java.util.Random r = new java.util.Random( 12345 );
        double[][] customers = new double[20][2];
        for( int i = 0; i < 20; i++ )
            for( int j = 0; j < 2; j++ )
                customers[i][j] = r.nextDouble()*200;

        ObjectiveFunction objFunc = new MyObjectiveFunction( customers );
        Solution initialSolution  = new MySolution( customers );
        MoveManager   moveManager = new MyMoveManager();
        TabuList         tabuList = new SimpleTabuList( 7 ); // In OpenTS package

        // Create Tabu Search object
        TabuSearch tabuSearch = new SingleThreadedTabuSearch(
                initialSolution,
                moveManager,
                objFunc,
                tabuList,
                new BestEverAspirationCriteria(), // In OpenTS package
                false ); // maximizing = yes/no; false means minimizing

        // Start solving
        tabuSearch.setIterationsToGo( 100 );
        tabuSearch.startSolving();

        // Show solution
        try {
            File file = new File("E://FYP/output.txt");
            file.getParentFile().mkdirs();

            PrintWriter printWriter = new PrintWriter(file);

            MySolution best = (MySolution) tabuSearch.getBestSolution();
            printWriter.print("Best Solution:\n" + best);

            int[] tour = best.tour;
            for (int i = 0; i < tour.length; i++)
                printWriter.print(customers[tour[i]][0] + "\t" + customers[tour[i]][1]+"\n");

            printWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}