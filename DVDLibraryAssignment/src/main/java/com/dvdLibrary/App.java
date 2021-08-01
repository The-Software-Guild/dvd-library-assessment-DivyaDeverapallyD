/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdLibrary;

import com.dvdLibrary.controller.DVDLibraryController;
import com.dvdLibrary.dao.DVDLibraryDao;
import com.dvdLibrary.dao.DVDLibraryDaoException;
import com.dvdLibrary.dao.DVDLibraryDaoFileImpl;
import com.dvdLibrary.ui.DVDLibraryView;
import com.dvdLibrary.ui.UserIO;
import com.dvdLibrary.ui.UserIOConsoleImpl;
import java.text.ParseException;

/**
 *
 * @author DivyaDeverapally
 */
public class App {
     public static void main(String[] args) throws ParseException, DVDLibraryDaoException {
         UserIO userIo= new UserIOConsoleImpl();
         DVDLibraryView dLibraryView= new DVDLibraryView(userIo);
         DVDLibraryDao dLibraryDao= new DVDLibraryDaoFileImpl();
         DVDLibraryController controller = new DVDLibraryController(dLibraryDao,dLibraryView);
        controller.run();
    } 
}
