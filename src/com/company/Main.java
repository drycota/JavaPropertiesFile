package com.company;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        InputStream input = null;
        OutputStream output = null;

        try {

            output = new FileOutputStream("config.properties");

            // set the properties value
            prop.setProperty("database", "localhost");
            prop.setProperty("dbuser", "userName");
            prop.setProperty("dbpassword", "userPassword");

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("database"));
            System.out.println(prop.getProperty("dbuser"));
            System.out.println(prop.getProperty("dbpassword"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        try {
//
//            String filename = "config.properties";
//            input = Main.class.getClassLoader().getResourceAsStream(filename);
//            if(input==null){
//                System.out.println("Sorry, unable to find " + filename);
//                return;
//            }
//
//            //load a properties file from class path, inside static method
//            prop.load(input);
//
//            //get the property value and print it out
//            System.out.println(prop.getProperty("database"));
//            System.out.println(prop.getProperty("dbuser"));
//            System.out.println(prop.getProperty("dbpassword"));
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally{
//            if(input!=null){
//                try {
//                    input.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        try {

            //String filename = "config.properties";
            input = input = new FileInputStream("config.properties");
//            if (input == null) {
//                System.out.println("Sorry, unable to find " + filename);
//                return;
//            }

            prop.load(input);

            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                System.out.println("Key : " + key + ", Value : " + value);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        InputStream input2 = new FileInputStream("config.properties");

        prop.load(input2);

        Set set = prop.keySet();

        for (Object r : set) {
            System.out.println(r + " value is: " + prop.getProperty((String) r));

        }


    }
}
