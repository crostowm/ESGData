package com.esg.esgdata.io;

import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.time.LocalDateTime;

public class BackupReader {

    private String backupLocation;

    public BackupReader(String backupLocation) {
        this.backupLocation = backupLocation;
    }

    public Backup getBackupFromDatabase()
    {
        Backup backup = new Backup(LocalDateTime.now());

        return backup;
    }

    public Backup getBackupFromFileSystem(LocalDateTime date)
    {
        String filename = String.format("%s/%d-%d-%d_%d-%d.ser", backupLocation, date.getMonthValue(), date.getDayOfMonth(), date.getYear(), date.getHour(), date.getMinute());
        Backup backup = null;
        try
        {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            backup = (Backup) in.readObject();

            in.close();
            file.close();
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
            System.out.println(ex.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("CNFException is caught");
        }
        return backup;
    }
    public Backup getBackupFromFileSystem(int month, int day, int year, int hour, int min)
    {
        return getBackupFromFileSystem(LocalDateTime.of(year, month, day, hour, min));
    }
    public void writeBackupToSystem()
    {
        writeBackupToSystem(getBackupFromDatabase());
    }

    public void writeBackupToSystem(Backup backup)
    {

        String filename = String.format("%s/%d-%d-%d_%d-%d.ser", backupLocation, backup.getDate().getMonthValue(), backup.getDate().getDayOfMonth(), backup.getDate().getYear(), backup.getDate().getHour(), backup.getDate().getMinute());

        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(backup);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
    }
}
