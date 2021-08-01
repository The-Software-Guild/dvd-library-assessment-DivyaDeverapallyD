/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdLibrary.controller;

import com.dvdLibrary.dao.DVDLibraryDao;
import com.dvdLibrary.dao.DVDLibraryDaoException;
import com.dvdLibrary.dao.DVDLibraryDaoFileImpl;
import com.dvdLibrary.dto.DVD;
import com.dvdLibrary.ui.DVDLibraryView;
import com.dvdLibrary.ui.UserIO;
import com.dvdLibrary.ui.UserIOConsoleImpl;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DivyaDeverapally
 */
public class DVDLibraryController {

    private DVDLibraryView view;
    private DVDLibraryDao dao;
    private UserIO io = new UserIOConsoleImpl();

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() throws ParseException, DVDLibraryDaoException {
        loadAllDVD();
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            try {
                menuSelection = getMenuSelection();
                
                switch (menuSelection) {
                    case 1:
                        createDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVDLibrary();
                        break;
                    case 5:
                        viewDVD();
                        break;
                    case 6:
                        searchDVD();
                        break;
                    case 7:
                        //loadAllDVD();
                        break;
                    case 8:
                        writeToFile();
                        keepGoing = false;
                        
                        break;
                    default:
                        unknownCommand();
                }
            } catch (DVDLibraryDaoException e) {
                  view.displayErrorMessage(e.getMessage());
            }

        }

        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDVD() throws ParseException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        DVD addedDVD = dao.addDVD(newDVD.getDvdId(), newDVD);
        if (addedDVD != null) {
            view.displayCreateSuccessBanner();
        } else {
            view.displayCreateFailureBanner();
        }
    }

    private void listDVDLibrary() {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVD();
        view.displayDVDLibraryList(dvdList);
    }

    private void viewDVD() {
        view.displayDisplayDVDBanner();
        String dvdID = view.getDVDtIdChoice();
        DVD dvd = dao.getDVDInfo(dvdID);
        view.displayDVD(dvd);
    }

    private void removeDVD() {
        view.displayRemoveDVDBanner();
        String DVDId = view.getDVDtIdChoice();
        // System.out.println("Sleced DVD choice to remove "+ DVDId);
        DVD removedDVD = dao.deleteDVD(DVDId);
        view.displayRemoveResult(removedDVD);
    }

    private void editDVD() throws ParseException {
        view.displayEditDVDBanner();

        listDVDLibrary();

        String dvdId = view.getDVDtIdChoice();
        // DVD editedDVD= dao.editDVD(dvd)
        DVD dvd = dao.getDVDInfo(dvdId);
        //   view.displayDVD(dvd);
        DVD editedDvd = view.editDVD(dvd);
        DVD resultDVD = dao.editDVD(editedDvd);
        view.displayDVD(resultDVD);

    }

    private void searchDVD() {
        view.displaySearchDVDBanner();
        String dvdId = view.getDVDtIdChoice();
        DVD dvd = dao.searchDVD(dvdId);
        view.displayDVD(dvd);

    }

    private void loadAllDVD() throws DVDLibraryDaoException {
        view.displayALLDVDBanner();
        List<DVD> allDVD = dao.loadAllDVDLibrary();
        view.displayDVDLibraryList(allDVD);
    }

    private void writeToFile() throws DVDLibraryDaoException {
        List<DVD> dvdList = dao.getAllDVD();
        dao.writeToFIle(dvdList);
    }
    private void unknownCommand() {
    view.displayUnknownCommandBanner();
}

private void exitMessage() {
    view.displayExitBanner();
}
}
