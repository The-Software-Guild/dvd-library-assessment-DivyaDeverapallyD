/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdLibrary.ui;

import com.dvdLibrary.dto.DVD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DivyaDeverapally
 */
public class DVDLibraryView {

    private UserIO io ;
    
    public DVDLibraryView(UserIO io){
        this.io=io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. ADD A DVD");
        io.print("2. DELETE A DVD");
        io.print("3. EDIT A DVD");
        io.print("4. VIEW ALL DVD");
        io.print("5. DISPLAY INFO OF A DVD");
        io.print("6. SEARCH FOR A DVD ");
        io.print("8. Exit");

        return io.readInt("Please select from the"
                + " above choices.", 1, 8);

    }

    public DVD getNewDVDInfo() throws ParseException {
        String dvdId = io.readString("Enter DVD ID");
        String dvdTitle = io.readString("Enter DVD Title");
        String release_date = io.readString("Enter Release Date");
        int mpaa_rating = io.readInt("Enter MPAA Rating");
        String director_name = io.readString("Enter Directoe name");
        String studio_name = io.readString("Enter Studi Name");
        String notes = "";
        int user_rating = 0;
        io.print("1. Enter user rating");
        io.print("2.Notes");
        int res = io.readInt("Please select from the"
                + " above choices.", 1, 2);
        if (res == 1) {
            user_rating = io.readInt("Enter USer Rating");
        } else {
            notes = io.readString("Enter Notes");
        }
        DVD currentDVD = new DVD(dvdId);
        currentDVD.setDvdId(dvdId);
        currentDVD.setTitle(dvdTitle);
        currentDVD.setRelease_date(new SimpleDateFormat("dd-MM-yyyy").parse(release_date));
        currentDVD.setMpaa_rating(mpaa_rating);
        currentDVD.setDirector_name(director_name);
        currentDVD.setStudio(studio_name);
        currentDVD.setUser_rating(user_rating);
        currentDVD.setNote(notes);

        return currentDVD;

    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully created.  Please hit enter to continue");
    }

    public void displayDVDLibraryList(List<DVD> dvdList) {
        System.out.println("ID"+"\t"+"Tile" + "\t" + "Release Date" + "\t\t\t" + "MPAA_Rating " + "\t" + "Director" + "\t"
                + "Studio" + "\t" + "User_Rating" + "\t" + "Notes");
        System.out.println(
                "=======================================================================================================");
        for (DVD dvd : dvdList) {
            // System.out.println(dvd.getUser_rating());
            if (dvd.getUser_rating() != 0) {
                System.out.println(dvd.getDvdId()+"\t"+dvd.getTitle() + "\t" + dvd.getRelease_date() + "\t\t" + dvd.getMpaa_rating() + "\t"
                        + dvd.getDirector_name() + "\t\t" + dvd.getStudio() + "\t\t" + dvd.getUser_rating() + "\t"
                        + "-");
            } else {
                System.out.println(dvd.getDvdId()+"\t"+dvd.getTitle() + "\t" + dvd.getRelease_date() + "\t\t" + dvd.getMpaa_rating() + "\t"
                        + dvd.getDirector_name() + "\t\t" + dvd.getStudio() + "\t\t" + "-" + "\t" + dvd.getNote());
            }
        }
        System.out.println("************************************************************************************");

    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVD ===");
    }

    public void displayDisplayDVDBanner () {
    io.print("=== Display DVD ===");
}
    
    public String getDVDtIdChoice() {
    return io.readString("Please enter the DVD ID.");
    }
    public void displayDVD(DVD dvd){
        if(dvd != null){
            io.print(dvd.toString());
        }
        else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
        
    }
    
    public void displayRemoveDVDBanner () {
    io.print("=== Remove DVD ===");
}
public void displayRemoveResult(DVD dvdRecord) {
    if(dvdRecord != null){
      io.print("DVD successfully removed.");
    }else{
      io.print("No such DVD.");
    }
    io.readString("Please hit enter to continue.");
}
 public void displayEditDVDBanner () {
    io.print("=== EDIT DVD ===");
}
 
 public DVD editDVD(DVD dvd) throws ParseException{
     
     
     //  Collection<DVD> abc = controller.getAll();
       // viewAll();
       // System.out.println("Enter dvd title you want to edit");
        //String dvdTitle = input.next();
       // DVD dvd = controller.getInfoOfDVD(dvdTitle);
        if (dvd != null) {
            if (dvd.getUser_rating() != 0) {
                System.out.println(dvd.getTitle() + "\t" + dvd.getRelease_date() + "\t\t" + dvd.getMpaa_rating() + "\t"
                        + dvd.getDirector_name() + "\t\t" + dvd.getStudio() + "\t\t" + dvd.getUser_rating() + "\t"
                        + "-");
            } else {
                System.out.println(dvd.getTitle() + "\t" + dvd.getRelease_date() + "\t\t" + dvd.getMpaa_rating() + "\t"
                        + dvd.getDirector_name() + "\t\t" + dvd.getStudio() + "\t\t" + "-" + "\t" + dvd.getNote());
            }
        }

        System.out.println("********************************************************************");
        System.out.println("Which field you want to edit ");
        System.out.println(
                "1: Title" + "\n" + "2: Release Date" + "\n" + "3: Director Name" + "\n" +
                        "4: Studio Name"+"\n"+"5: User rating"+"\n"+"6: Notes");
        int n = io.readInt("Coose a number ");
        if (n == 1) {
          //  System.out.println(io.readString(prompt));
            String newTitle = io.readString("Enter new Title");
            dvd.setTitle(newTitle);
        }
        if (n == 2) {
            System.out.println("Enter new Release Date");
            String newDate = io.readString("Enter new Release Date");
            Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(newDate);
            // System.out.println(date1);
            dvd.setRelease_date(date1);
        }
        if (n == 3) {
          //  System.out.println("Enter new Director Name");
            String newDirector = io.readString("Enter new Director Name");
            dvd.setDirector_name(newDirector);

        }
        if (n == 4) {
          //  System.out.println("Enter new Studio Name");
            String newStudio = io.readString("Enter new Studio Name");
            dvd.setStudio(newStudio);

        }
         if (n == 5) {
          //  System.out.println("Enter new User rating");
            int newRating = io.readInt("Enter new User rating");
            dvd.setUser_rating(newRating);

        }
          if (n == 6) {
            //System.out.println("Enter new Notes");
            String newNotes = io.readString("Enter new Notes");
            dvd.setNote(newNotes);

        }
          
       return dvd;   
 }
 
 public void displaySearchDVDBanner () {
    io.print("=== SEARCH FOR A DVD ===");
}
  public void displayALLDVDBanner () {
    io.print("===ALL the existing DVD's ===");
}
 public void displayCreateFailureBanner(){
 io.print("DVD with same ID already exists");
 }
 public void displayExitBanner() {
    io.print("Good Bye!!!");
}

public void displayUnknownCommandBanner() {
    io.print("Unknown Command!!!");
}
public void displayErrorMessage(String errorMsg) {
    io.print("=== ERROR ===");
    io.print(errorMsg);
}
}
