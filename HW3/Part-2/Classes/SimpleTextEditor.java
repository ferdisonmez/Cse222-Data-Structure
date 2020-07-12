import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;


public class SimpleTextEditor{
    private ArrayList<Character> textA;
    private LinkedList<Character> textL;

    public SimpleTextEditor() {
       textA=new ArrayList<Character>();
       textL=new LinkedList<Character>();
    }

    /***
     * The file was read character by character and filled with LinkedList and ArrayList
     * @param file  is keeped file
     * @param satir is String
     */
    public void DosyaRead(File file,String satir){
        try {
            FileReader fr=new FileReader(file);   //Creation of File Reader object
            BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object
            int c = 0;
            while((c = br.read()) != -1)         //Read char by Char
            {
                char character = (char) c;          //converting integer to char
                textA.add(character);
                textL.add(character);
            }

        } catch (Exception e) {
            System.out.println("File not fully read");
            e.printStackTrace();
        }
    }
    /***
     * All elements of ArraList are shown
     */
    public void showA(){
        System.out.println("***ArrayList****");
        for (int i = 0; i <textA.size() ; i++) {
            System.out.println(textA.get(i));
        }
    }

    /***
     *All elements of LinkedList are shown
     */
    public void showL(){
        System.out.println("***LinkedList****");
        for (int i = 0; i <textL.size() ; i++) {
            System.out.println(textL.get(i));
        }
    }

    /***
     *Function written to add a string to a special place in Linkedlist
     * @param stringToBeInserted is the string to be added
     * @param index is special place to be added
     */
        public void addL(String stringToBeInserted, int index)
        {
            for (int i = 0; i < textL.size(); i++) {
                if (i == index) {
                    for (int j=stringToBeInserted.length()-1; j>=0;j--) {
                        textL.add(i,stringToBeInserted.charAt(j));

                    }
                }
            }
        }

    /***
     *Function written to add a string to a special place in Linkedlist with iterator
     * @param stringToBeInserted is the string to be added
     * @param index is special place to be added
     */
    public void addLi(String stringToBeInserted, int index)
    {
        ListIterator<Character> iterL=textL.listIterator();
        int i=0;
        while (iterL.hasNext()){
          if(i==index){
                for (int j=0; j<stringToBeInserted.length();j++) {
                    iterL.add(stringToBeInserted.charAt(j));
                }
            }
          i++;
          iterL.next();
        }
    }
    /***
     *Function written to add a string to a special place in ArrayList
     * @param stringToBeInserted is the string to be added
     * @param index is special place to be added
     */
        public void addA(String stringToBeInserted, int index)
        {
            for (int i = 0; i < textA.size(); i++) {
                if (i == index) {
                    for (int j=stringToBeInserted.length()-1; j>=0;j--) {
                        textA.add(i,stringToBeInserted.charAt(j));
                    }
                }
            }
        }
    /***
     *Function written to add a string to a special place in ArrayList with iterator
     * @param stringToBeInserted is the string to be added
     * @param index is special place to be added
     */
    public void addAi(String stringToBeInserted, int index)
    {
        ListIterator<Character> iterA=textA.listIterator();
        while (iterA.hasNext()) {
            if (iterA.nextIndex() == index) {
                for (int j=0; j<stringToBeInserted.length();j++) {
                    iterA.add(stringToBeInserted.charAt(j));
                }
            }
            iterA.next();
        }
    }

    /***
     * This method can find special string in linked list
     * @param findarray is String
     * @return  the location of the found string
     */
        public int findL(String findarray){
            String deger ="";
            for (int i = 0; i <textL.size(); i++) {
                deger+=textL.get(i);
            }
            return deger.indexOf(findarray);

        }
    /***
     * This method can find special string in linked list with iterator
     * @param findarray is string
     * @return  the location of the found string
     */
    public int findLi(String findarray){
        ListIterator<Character> iterL=textL.listIterator();
        String deger ="";
        while (iterL.hasNext()) {
            deger+=textL.get(iterL.nextIndex());
            iterL.next();
        }
        return deger.indexOf(findarray);

    }
    /***
     * This method can find special string in ArrayList
     * @param findarray is String
     * @return  the location of the found string
     */
        public int findA(String findarray){
            String deger ="";
            for (int i = 0; i <textA.size(); i++) {
                deger+=textA.get(i);
            }
            return deger.indexOf(findarray);

        }
    /***
     * This method can find special string in ArrayList with iterator
     * @param findarray is String
     * @return  the location of the found string
     */
    public int findAi(String findarray){
        ListIterator iterA=textA.listIterator();
        String deger ="";
        while (iterA.hasNext()) {
            deger+=textA.get(iterA.nextIndex());
            iterA.next();
        }
        return deger.indexOf(findarray);

    }

    /***
     * Searches for a given special character and replaces it with another given character in Linkedlist
     * @param varsa is the character
     * @param koy is the character
     */
    public void replaceStrL(Character varsa,Character koy){
            for (int i = 0; i <textL.size() ; i++) {
                if (textL.get(i).compareTo(varsa)==0) {
                    textL.set(i,koy);
                }
            }
        }
    /***
     * Searches for a given special character and replaces it with another given character in Linkedlist with iterator
     * @param varsa is the character
     * @param koy is the character
     */
    public void replaceStrLi(Character varsa,Character koy){
        ListIterator<Character> iterL=textL.listIterator();
        while (iterL.hasNext()) {
            Character c=iterL.next();
            if (c.equals(varsa)){
                iterL.set(koy);
            }
        }
    }
    /***
     * Searches for a given special character and replaces it with another given character in Arraylist
     * @param varsa is the character
     * @param koy is the character
     */
    public void replaceStrA(Character varsa,Character koy){
        for (int i = 0; i <textA.size() ; i++) {
            if (textA.get(i).compareTo(varsa)==0) {
                textA.set(i,koy);
            }
        }
    }
    /***
     * Searches for a given special character and replaces it with another given character in Arraylist with iterator
     * @param varsa is the character
     * @param koy is the character
     */
    public void replaceStrAi(Character varsa,Character koy){
        ListIterator<Character> iterA=textA.listIterator();
        while (iterA.hasNext()) {
            Character c=iterA.next();
            if (c.equals(varsa)){
                iterA.set(koy);
            }
        }
    }

}
