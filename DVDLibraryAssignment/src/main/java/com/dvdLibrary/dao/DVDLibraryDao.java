/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdLibrary.dao;

import com.dvdLibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author DivyaDeverapally
 */
public interface DVDLibraryDao {
    
    DVD addDVD(String dvdID, DVD dvd); 
    DVD deleteDVD(String dvdId);
    DVD editDVD(DVD dvd);
    List<DVD> getAllDVD();
    DVD getDVDInfo(String dvdId);
    DVD searchDVD(String dvdId);
    List<DVD> loadAllDVDLibrary()throws DVDLibraryDaoException; 
    void writeToFIle(List<DVD> dvdLibrary) throws DVDLibraryDaoException;
    
}
