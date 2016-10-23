package assignment01;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jm on 22.10.16.
 */
public class Sequence {
    private String seq_name;
    private ArrayList<Nucleotide> nucleo_sequence;
    private int seq_length;
    private int number_of_blanks;

    public Sequence(String seq_name, ArrayList<Nucleotide> nucleo_sequence,int number_of_blanks){
        this.seq_name=seq_name;
        this.nucleo_sequence=nucleo_sequence;
        this.seq_length=nucleo_sequence.size();
        this.number_of_blanks=number_of_blanks;
    }

    public String getHeader(){
        return seq_name;
    }

    public ArrayList<Nucleotide> getNucleo_sequence(){
        return nucleo_sequence;
    }

    public int getSeq_length(){
        return seq_length;
    }

    public int getNumber_of_blanks(){
        return number_of_blanks;
    }


}
