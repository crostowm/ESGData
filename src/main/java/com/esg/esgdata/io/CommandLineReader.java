package com.esg.esgdata.io;

import com.esg.esgdata.model.cash.CashItemDao;
import com.esg.esgdata.model.catering.CateringDao;
import com.esg.esgdata.model.comment.CommentDao;
import com.esg.esgdata.model.daysales.DaySalesDao;
import com.esg.esgdata.model.execution.ExecutionDao;
import com.esg.esgdata.model.prep.PrepDao;
import com.esg.esgdata.model.setting.SettingDao;
import com.esg.esgdata.model.task.TaskDao;
import com.esg.esgdata.staff.StaffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Scanner;

@Service
public class CommandLineReader{
    @Autowired
    SettingDao settingDao;

    @Autowired
    PrepDao prepDao;

    @Autowired
    CateringDao cateringDao;

    @Autowired
    TaskDao taskDao;

    @Autowired
    StaffDao staffDao;

    @Autowired
    CashItemDao cashItemDao;

    @Autowired
    DaySalesDao daySalesDao;

    @Autowired
    CommentDao commentDao;

    @Autowired
    ExecutionDao executionDao;

    String serverBackupFolder = "C:/Users/crost/OneDrive/Documents/Jimmy Johns/All Stores/ServerBackup";

    public void run() {
        String prompt = "Read the backup for entered datetime" +
                "\n\tr month day year hour minute" +
                "\nUpload the backup for entered datetime" +
                "\n\tu month day year hour minute" +
                "\nSave database in current state" +
                "\n\ts";
        Scanner keyboard = new Scanner(System.in);
        String line;
        while(true)
        {
                System.out.println(prompt);
                line = keyboard.nextLine();
                if (line.equals("c"))
                    break;
                String[] tokens = line.split(" ");
                if(tokens.length > 0) {
                    for (int ii = 0; ii < tokens.length; ii++) {
                        System.out.println(tokens[ii]);
                    }
                switch (tokens[0]) {
                    case "r":
                        if (tokens.length > 5)
                            readDatabaseBackup(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]));
                        break;
                    case "u":
                        break;
                    case "s":
                        saveDatabase();
                        break;
                }
                }
        }
        System.out.println("End of keyboard reading");
        keyboard.close();
    }

    private void readDatabaseBackup(int month, int day, int year, int hour, int minute)
    {
        try {
            BackupReader backupReader = new BackupReader(serverBackupFolder);
            Backup backup = backupReader.getBackupFromFileSystem(LocalDateTime.of(year, month, day, hour, minute));
            System.out.println(backup.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void saveDatabase()
    {
        System.out.println("Saving...");
        BackupReader backupReader = new BackupReader(serverBackupFolder);
        Backup backup = backupReader.getBackupFromDatabase();
        backup.setDate(LocalDateTime.now());
        backup.setCashItems(cashItemDao.getAllCashItems());
        backup.setCateringOrders(cateringDao.getAllCateringOrders());
        backup.setComments(commentDao.getAllComments());
        backup.setDaySales(daySalesDao.getAllDaySales());
        backup.setEmployees(staffDao.getAllEmployees());
        backup.setExecutionCharts(executionDao.getAllExecutionChart());
        backup.setPrepItems(prepDao.getAllPrepItems());
        backup.setPrepTemplates(prepDao.getAllPrepTemplates());
        backup.setSettings(settingDao.getAllSettings());
        backup.setTaskItems(taskDao.getAllTaskItems());
        backup.setTaskTemplates(taskDao.getAllTaskTemplates());
        backupReader.writeBackupToSystem(backup);
    }

}
