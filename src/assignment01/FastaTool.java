package assignment01;

import java.util.ArrayList;
import java.io.*;
import java.util.Iterator;
/**
 * Created by jm on 22.10.16.
 */
public class FastaTool {
    private ArrayList<Sequence> sequences;

    public FastaTool(){
        sequences = new ArrayList<>();
    }

    public void read(Reader r) throws IOException{
        BufferedReader br = new BufferedReader(r);
        char first = (char) br.read();
        if(first != '>')
            throw new IOException("Not a FastA file!");
        while(true){
            String header = br.readLine();
            ArrayList<Nucleotide> currentSequence = new ArrayList<>();
            int blank_counter = 0;
            char next = (char)br.read();
            while(next != '>') {
                //Check if end of file is reached
                if (next == (char) -1) {
                    sequences.add(new Sequence(header, currentSequence, blank_counter));
                    br.close();
                    return;
                }
                //Ignore spaces and newlines
                if (next != ' ' && next != '\n' && next != '\r') {
                    currentSequence.add(new Nucleotide(next));
                    if (next == '-')
                        blank_counter++;

                }
                next = (char) br.read();
            }
            sequences.add(new Sequence(header, currentSequence, blank_counter));

        }

    }

    public static void main(String[] args) throws IOException{

        System.out.println("Reading the Multi FastA-file...");
        // open reader to input file
        String infile=args[0];
        Reader r=new FileReader(infile);
        FastaTool tool = new FastaTool();
        tool.read(r);
        CommandLine.writeToTerminal(tool);

    }

    public ArrayList getSequences(){
        return sequences;
    }


}
