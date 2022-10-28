
package PL;

/**
 * @author DEI-ESINF
 */
public class TextWord implements Comparable<TextWord> {

    private String word;
    private int ocorrences;

    // constructor
    public TextWord(String word, int ocorrences) {
        setWord(word, ocorrences);
    }

    // setword
    public void setWord(String word, int ocorrences) {
        this.word = word;
        this.ocorrences = ocorrences;
    }

    // count the number of ocorrences
    public void incOcorrences() {
        this.ocorrences++;
    }

    // getword
    public String getWord() {
        return word;
    }

    // get the number of ocorrences
    public int getOcorrences() {
        return ocorrences;
    }

    @Override
    public int compareTo(TextWord o) {
        return word.compareTo(o.getWord());
    }

    public String toString() {
        return "<" + word + ">:" + ocorrences;
    }
}
