
import javax.lang.model.element.NestingKind;
import java.util.Scanner;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author javid
 */
public class Main {

    static String str;
    public static void main(String[] args) throws ClassNotFoundException {

        Youtube youtube = new Youtube();

        //2000-01-01 00:00
        youtube.insertUserToDB(youtube.randomAlphabeticString(24),
                youtube.randomAlphabeticString(10) + String.valueOf(youtube.randomNumericInt(299999)),
                String.valueOf(youtube.randomNumericInt(2)) + "0" +
                        String.valueOf(youtube.randomNumericInt(9)) +
                        String.valueOf(youtube.randomNumericInt(9)) + "-" +
                        String.valueOf(youtube.randomNumericInt(2)) +
                        String.valueOf(youtube.randomNumericInt(9)) + "-" +
                        String.valueOf(youtube.randomNumericInt(2)) +
                        String.valueOf(youtube.randomNumericInt(9)) + " " +
                        //clock
                        String.valueOf(youtube.randomNumericInt(2)) +
                        String.valueOf(youtube.randomNumericInt(4)) + ":" +
                        String.valueOf(youtube.randomNumericInt(5)) +
                        String.valueOf(youtube.randomNumericInt(9)) + ":" +
                        String.valueOf(youtube.randomNumericInt(5)) +
                        String.valueOf(youtube.randomNumericInt(9)),
                youtube.randomNumericInt(9000000),
                youtube.randomAlphabeticString(30) + "@" + youtube.randomAlphabeticString(15) + "." + youtube.randomAlphabeticString(10));


        youtube.insertVideoToDB(youtube.randomAlphabeticString(6),
                        youtube.randomAlphabeticString(24),
                String.valueOf(youtube.randomNumericInt(2)) + "0" +
                        String.valueOf(youtube.randomNumericInt(9)) +
                        String.valueOf(youtube.randomNumericInt(9)) + "-" +
                        String.valueOf(youtube.randomNumericInt(2)) +
                        String.valueOf(youtube.randomNumericInt(9)) + "-" +
                        String.valueOf(youtube.randomNumericInt(2)) +
                        String.valueOf(youtube.randomNumericInt(9)) + " " +
                        //clock
                        String.valueOf(youtube.randomNumericInt(2)) +
                        String.valueOf(youtube.randomNumericInt(4)) + ":" +
                        String.valueOf(youtube.randomNumericInt(5)) +
                        String.valueOf(youtube.randomNumericInt(9)) + ":" +
                        String.valueOf(youtube.randomNumericInt(5)) +
                        String.valueOf(youtube.randomNumericInt(9)),
                        youtube.randomAlphabeticString(200),
                        youtube.randomNumericInt(900000000),
                        youtube.randomNumericInt(900));

        System.out.print("Enter userName : \n");
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        String username = sc.nextLine();              //reads string

        System.out.print("Enter password : \n");
        String password = sc.nextLine();              //reads string

        youtube.findUserName(username, password);

        System.out.print("Enter the name of the video you want to search: \n");
        str= sc.nextLine();            //reads string
        System.out.print("You have entered: \n" + str + "\n");
        youtube.findMovieByName(str);


    }


}
