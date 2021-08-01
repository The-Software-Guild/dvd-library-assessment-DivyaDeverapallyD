/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdLibrary.dao;

import com.dvdLibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DivyaDeverapally
 */
public class DVDLibraryDaoFileImpl  implements DVDLibraryDao{
    
    private Map<String, DVD> dvdLibraryMap = new HashMap<>();

    @Override
    public DVD addDVD(String dvdId,DVD dvd) {
         DVD previousDVD;
        if(!dvdLibraryMap.containsKey(dvd.getDvdId()))
        {
               dvdLibraryMap.put(dvdId, dvd);
              previousDVD=dvdLibraryMap.get(dvdId);
        }
        else{
        previousDVD= null;}
       return previousDVD;
    }

    @Override
    public DVD deleteDVD(String dvdId) {
        DVD removedDVD= dvdLibraryMap.get(dvdId);
        dvdLibraryMap.remove(dvdId);
        System.out.println("Delecte method implementation"+ removedDVD.toString());
        return removedDVD;
    }

    @Override
    public DVD editDVD(DVD dvd) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   dvdLibraryMap.put(dvd.getDvdId(), dvd);
   return  dvdLibraryMap.get(dvd.getDvdId());
    }

    @Override
    public List<DVD> getAllDVD() {
  return new ArrayList<DVD>(dvdLibraryMap.values());     
    }

    @Override
    public DVD getDVDInfo(String dvdId) {
        return dvdLibraryMap.get(dvdId);
    }

    @Override
    public DVD searchDVD(String dvdId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return dvdLibraryMap.get(dvdId);
    }

    @Override
    public List<DVD> loadAllDVDLibrary() {
         List<DVD> tempList = new ArrayList<DVD>();
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(new File("dvdLibrary.txt"))));
            List<DVD> dvdList = new ArrayList<>();
           
            while (scanner.hasNextLine()) {
                DVD d1 = new DVD();
                String dvd = scanner.nextLine();
                String[] d = dvd.split(",");
                for (String str : d) {
                    
                    String temp[] = str.split("=");
                    // System.out.println("temp at 0"+ temp[0]);
                    // System.out.println("temp at 1"+ temp[1]);
                    if(str.contains("ID"))
                    {
                        d1.setDvdId(temp[1].trim());
                    }
                    if (str.contains("title")) {
                        // System.out.println(tempList);
                        d1.setTitle(temp[1].trim());
                    }
                    if (str.contains("Release Date")) {
                        d1.setRelease_date(new Date(temp[1]));
                    }
                    if (str.contains("MPAA Rating3")) {
                        d1.setMpaa_rating(Integer.parseInt(temp[1]));
                    }
                    if (str.contains("Director Name")) {
                        d1.setDirector_name(temp[1].trim());
                    }
                    if (str.contains("Studio Name")) {
                        d1.setStudio(temp[1].trim());
                    }
                    if (str.contains("User Rating")) {
                        d1.setUser_rating(Integer.parseInt(temp[1].trim()));
                    }
                    if (str.contains("Notes")) {
                        d1.setNote(temp[1].trim());
                    }
                    
                }
                tempList.add(d1);
                dvdLibraryMap.put(d1.getDvdId(), d1);
                
            }
            
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DVDLibraryDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
 return tempList;
    }

    @Override
    public void writeToFIle(List<DVD> dvdLibrary) {
           PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(new File("dvdLibrary.txt")));
            for (Map.Entry<String, DVD> entry : dvdLibraryMap.entrySet()) {
                DVD dvd = entry.getValue();
                String dvdString =  "ID = " + dvd.getDvdId()+ "," +"title = " + dvd.getTitle() + "," + "Release Date = " + dvd.getRelease_date() + "," + "MPAA Rating = " + dvd.getMpaa_rating() + ","
                        + "Director Name = " + dvd.getDirector_name() + "," + "Studio Name = " + dvd.getStudio() + "," + "User Rating = " + dvd.getUser_rating() + ","
                        + "Notes = " + dvd.getNote();
                
                //  System.out.println(dvd.toString());
                pw.println(dvdString);
            }   pw.close();
        } catch (IOException ex) {
            Logger.getLogger(DVDLibraryDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }

    }
    
}
