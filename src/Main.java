public class Main {

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader( "alice.txt");
        System.out.println("Total amount of chars: "+reader.getTotalCharCount());
        System.out.println("Total amount of words: "+ reader.getTotalWordCount());
        reader.toPrintLetters();
        //reader.toPrintWords();
    }
}
