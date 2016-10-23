package assignment01;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jm on 22.10.16.
 */
public class CommandLine {

    public static void writeToTerminal(FastaTool toolData){
        //Print actual sequences
        ArrayList<Sequence> sequenceList = toolData.getSequences();





        //Print additional stuff
        System.out.println("Number of sequences: "+ sequenceList.size());
        System.out.println("Shortest length: "+ minimumLength(sequenceList) + " (excluding '-'s: " + minimumExcludingGaps(sequenceList) + ")");
        System.out.println("Average length: " + averageLength(sequenceList) + " (excluding '-'s: " + averageExcludingGaps(sequenceList) + ")");
        System.out.println("Longest length: " + maximumLength(sequenceList) + " (excluding '-'s: " + maximumExcludingGaps(sequenceList) + ")");
        System.out.println("Counts: A: " + letterCount(sequenceList,'A')
                + ", C: " + letterCount(sequenceList,'C')
                + ", G: " + letterCount(sequenceList,'G')
                + ", U: " + letterCount(sequenceList,'U')
                + ", -: " + letterCount(sequenceList, '-')
        );


    }

    public static int minimumLength(ArrayList<Sequence> sequences){
        int min = Integer.MAX_VALUE;
        for(Sequence seq : sequences){
            min = Math.min(min, seq.getSeq_length());
        }
        return min;
    }

    public static int minimumExcludingGaps(ArrayList<Sequence> sequences){
        int min = Integer.MAX_VALUE;
        for(Sequence seq: sequences){
            min = Math.min(min, seq.getSeq_length() - seq.getNumber_of_blanks());
        }
        return min;

    }

    public static int maximumLength(ArrayList<Sequence> sequences){
        int max = Integer.MIN_VALUE;
        for(Sequence seq: sequences){
            max = Math.max(max, seq.getSeq_length());
        }
        return max;
    }

    public static int maximumExcludingGaps(ArrayList<Sequence> sequences){
        int max = Integer.MIN_VALUE;
        for(Sequence seq: sequences){
            max = Math.max(max, seq.getSeq_length() - seq.getNumber_of_blanks());
        }
        return max;
    }

    public static int averageLength(ArrayList<Sequence> sequences){
        int sum = 0;
        for(Sequence seq: sequences){
            sum += seq.getSeq_length();
        }
        return sum/sequences.size();
    }

    public static int averageExcludingGaps(ArrayList<Sequence> sequences){
        int sum = 0;
        for(Sequence seq: sequences){
            sum += seq.getSeq_length()-seq.getNumber_of_blanks();
        }
        return sum/sequences.size();
    }

    public static int letterCount(ArrayList<Sequence> sequences, char letter){
        int counter = 0;
        for(Sequence seq: sequences){
            for(Nucleotide nuc: seq.getNucleo_sequence()){
                if(nuc.getBase()== letter){
                    counter++;
                }
            }
        }
        return counter;
    }

}
