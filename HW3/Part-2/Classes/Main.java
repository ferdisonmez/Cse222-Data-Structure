import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args){
        File file = new File("C:\\Users\\Ferdi Sönmez\\Desktop\\Dosya.txt");
        SimpleTextEditor yeni=new SimpleTextEditor();
        Logger logger=Logger.getLogger("Mylog");
        FileHandler fh;
        try {
            fh=new FileHandler("C:\\Users\\Ferdi Sönmez\\Desktop\\MylogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter=new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.info("MyFirst log");
            String satir = "";
            String ekle = "For";
            String ekle1 = "Hello";
            yeni.DosyaRead(file, satir);
            logger.info("Read File");
            yeni.addL(ekle, 2);
            logger.info("New element added specific index to linked list");
            yeni.showL();
            System.out.println("******addL******");
            yeni.addLi(ekle1, 6);
            logger.info("New element added specific index to linked list with iterator");
            yeni.showL();
            System.out.println("****addLi****");
            yeni.addA("Yap", 1);
            yeni.showA();
            logger.info("New element added specific index to ArrayList");
            System.out.println("***addA****");
            yeni.addAi("Olsun", 0);
            logger.info("New element added specific index to ArrayList with iterator");
            yeni.showA();
            System.out.println("****addAi****");
            if (yeni.findL("For") != -1) {
                System.out.println("IndexfindL=" + yeni.findL("For"));
            } else {
                System.out.println("Not Found");
            }
            logger.info("Searched character found in Linkedlist or not found");
            System.out.println("***findL****");
            if (yeni.findLi("Hel") != -1) {
                System.out.println("IndexfindLi=" + yeni.findLi("Hel"));
            } else {
                System.out.println("Not Found");
            }
            logger.info("Searched character found in Linkedlist or not found with iterator");
            System.out.println("***findLi****");
            if (yeni.findA("JY") != -1) {
                System.out.println("IndexfindA=" + yeni.findA("JY"));
                ;
            } else {
                System.out.println("Not Found");
            }
            logger.info("Searched character found in Arraylist or not found");
            System.out.println("***findA****");
            if (yeni.findAi("Ol") != -1) {
                System.out.println("IndexfindAi=" + yeni.findAi("Ol"));
            } else {
                System.out.println("Not Found");
            }
            logger.info("Searched character found in Arraylist or not found with iterator");
            System.out.println("**findAi***");
            System.out.println("*************************");
            yeni.replaceStrL('a', 'x');
            logger.info("Desired character replaced with other character in Linkedlist");
            yeni.showL();
            System.out.println("**************************");
            yeni.replaceStrLi('J', '#');
            logger.info("Desired character replaced with other character in Linkedlist with iterator");
            yeni.showL();
            System.out.println("***************************");
            yeni.replaceStrA('n', '%');
            logger.info("Desired character replaced with other character in Arraylist");
            yeni.showA();
            System.out.println("***************************");
            yeni.replaceStrAi('a', '&');
            logger.info("Desired character replaced with other character in Arraylist with iterator");
            yeni.showA();
            System.out.println("****************************");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Size exceeded");
        }
        catch (NullPointerException e){
            System.out.println("Sorry, NULLPOINTER has been accessed");
        }
        catch (SecurityException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        logger.info("***Finish***");
    }
}
