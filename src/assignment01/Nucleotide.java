package assignment01;

/**
 * Created by jm on 22.10.16.
 */
public class Nucleotide {
    private char base;
    private String name;

    public Nucleotide(char base){
        this.base=base;
        
        //This turned out to be unnecessary, but it might
        //become useful in the future
        switch (base){
            case 'A': this.name="Adenine";
                break;
            case 'C': this.name="Cytosine";
                break;
            case 'G': this.name="Guanine";
                break;
            case 'U': this.name="Uracil";
                break;
            case '-': this.name="Gap";
        }


    }

    public char getBase(){
        return base;
    }
}
