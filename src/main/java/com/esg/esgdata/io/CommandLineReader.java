package com.esg.esgdata.io;

import com.esg.esgdata.model.cash.CashItem;
import com.esg.esgdata.model.cash.CashItemDao;
import com.esg.esgdata.model.catering.CateringDao;
import com.esg.esgdata.model.catering.CateringItem;
import com.esg.esgdata.model.catering.CateringOrder;
import com.esg.esgdata.model.catering.CateringType;
import com.esg.esgdata.model.comment.Comment;
import com.esg.esgdata.model.comment.CommentDao;
import com.esg.esgdata.model.daysales.DaySales;
import com.esg.esgdata.model.daysales.DaySalesDao;
import com.esg.esgdata.model.execution.ExecutionChart;
import com.esg.esgdata.model.execution.ExecutionDao;
import com.esg.esgdata.model.prep.*;
import com.esg.esgdata.model.setting.Setting;
import com.esg.esgdata.model.setting.SettingCategory;
import com.esg.esgdata.model.setting.SettingDao;
import com.esg.esgdata.model.setting.Settings;
import com.esg.esgdata.model.task.*;
import com.esg.esgdata.staff.Employee;
import com.esg.esgdata.staff.StaffDao;
import com.esg.esgdata.staff.StaffType;
import com.esg.esgdata.tools.Tools;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@Service
public class CommandLineReader {
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
                "\n\ts" +
                "\nClear data from all tables except task templates and settings" +
                "\n\tcat" +
                "\nCreate fake tables of data" +
                "\n\tcft" +
                "\nCreate PDF" +
                "\n\tpdf m d yyyy" +
                "\nRead tasks from file and upload to DB" +
                "\n\trt";
        Scanner keyboard = new Scanner(System.in);
        String line;
        while (true) {
            System.out.println(prompt);
            line = keyboard.nextLine();
            if (line.equals("c"))
                break;
            String[] tokens = line.split(" ");
            if (tokens.length > 0) {
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
                    case "cat":
                        clearAllTables();
                        break;
                    case "cft":
                        createFakeTables();
                        break;
                    case "pdf":
                        if (tokens.length > 3)
                            writePDF(tokens[1], tokens[2], tokens[3]);
                        break;
                    case "rt":
                        readTasks();
                }
            }
        }
        System.out.println("End of keyboard reading");
        keyboard.close();
    }

    private void readTasks() {
        TaskReader reader = new TaskReader();
        List<TaskTemplate> templates = reader.readTasks("C:/Users/crost/SpringProjects/ESGData/src/main/resources/templates/tasks.txt");
        System.out.println("Templates Size: " + templates.size());
        for (TaskTemplate readTask : templates) {
            System.out.println(readTask.toString());
            taskDao.save(readTask);
        }
    }

    private void writePDF(String month, String day, String year) {
        LocalDate date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

        try {
            // Load the PDF document
            File file = new File("C:\\Users\\crost\\SpringProjects\\ESGData\\src\\main\\resources\\templates\\template_punchlist.pdf");
            System.out.println(file.getAbsolutePath());
            PDDocument pdfDoc = PDDocument.load(file);
            PDDocumentCatalog docCatalog = pdfDoc.getDocumentCatalog();
            PDAcroForm acroForm = docCatalog.getAcroForm();

            for (TaskItem taskItem : taskDao.getAllTaskItemsForDate(date)) {
                // Iterate through all the form fields in the PDF
                for (PDField field : acroForm.getFields()) {
                    String fieldName = field.getFullyQualifiedName();
                    System.out.println("Field Name: " + fieldName);
                    switch (fieldName) {
                        case "date":
                            field.setValue(date.toString());
                            break;
                        case "store_num":
                            field.setValue("3733");
                            break;
                        case "am_shift":
                            field.setValue(String.format("%d", Tools.getShiftFor(date, true)));
                            break;
                        case "pm_shift":
                            field.setValue(String.format("%d", Tools.getShiftFor(date, false)));
                            break;
                        case "open_cashdep_yes":
                            field.setValue("O");
                            break;
                        case "bin_tuna":
                            field.setValue(String.format("%.2f", prepDao.getPrepItemForDate(date, "Tuna").getNumToPrep()));
                        default:
                            if (taskItem.getTaskCode().equals(fieldName)) {
                                if(taskItem.getCompletedBy() != null)
                                    field.setValue(taskItem.getCompletedBy().getInitials());
                                else
                                    field.setValue("X");
                            }

                    }
                }

            }
            // Save the filled out PDF with a new name
            String newFilename = "filled_" + date.toString() + "_" + 3733 + "_Punchlist.pdf";
            pdfDoc.save(newFilename);
            pdfDoc.close();
        } catch (NumberFormatException nfe) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearAllTables() {
        for (CashItem allCashItem : cashItemDao.getAllCashItems()) {
            cashItemDao.delete(allCashItem.getId());
        }
        for (CateringOrder allCateringOrder : cateringDao.getAllCateringOrders()) {
            cateringDao.deleteOrder(allCateringOrder.getId());
        }
        for (CateringItem allCateringItem : cateringDao.getAllCateringItems()) {
            cateringDao.deleteItem(allCateringItem.getId());
        }
        for (Comment allComment : commentDao.getAllComments()) {
            commentDao.deleteComment(allComment.getId(), allComment.getDate());
        }
        for (DaySales allDaySale : daySalesDao.getAllDaySales()) {
            daySalesDao.deleteDaySales(allDaySale.getDate());
        }
        for (ExecutionChart executionChart : executionDao.getAllExecutionChart()) {
            executionDao.deleteExecutionChart(executionChart.getDate(), executionChart.getLunchOrDinner());
        }
        for (PrepItem allPrepItem : prepDao.getAllPrepItems()) {
            prepDao.deleteItem(new PrepId(allPrepItem.getDesc(), allPrepItem.getDate()));
        }
        /*for (PrepTemplate allPrepTemplate : prepDao.getAllPrepTemplates()) {
            prepDao.deleteTemplate(allPrepTemplate.getDesc());
        }*/
		/*for (Setting setting : settingDao.getAllSettings()) {
			settingDao.delete(setting.getName());
		}*/
        for (TaskItem allTaskItem : taskDao.getAllTaskItems()) {
            taskDao.deleteItem(new TaskId(allTaskItem.getTaskCode(), allTaskItem.getDate()));
        }
        for (Employee allEmployee : staffDao.getAllEmployees()) {
            staffDao.delete(allEmployee.getId());
        }
    }

    private void createFakeTables() {
        settingDao.save(new Setting(Settings.PERC_PM_BREAD_BAKED_AT_SC, .5, SettingCategory.MISC));
        settingDao.save(new Setting(Settings.PERC_AM_BREAD_BAKED_AT_11, .75, SettingCategory.MISC));
        settingDao.save(new Setting(Settings.BIN_VALUE_LETTUCE, 500, SettingCategory.BIN));
        settingDao.save(new Setting(Settings.BIN_VALUE_TOMATOES, 1400, SettingCategory.BIN));
        settingDao.save(new Setting(Settings.BIN_VALUE_ONIONS, 1600, SettingCategory.BIN));
        settingDao.save(new Setting(Settings.BIN_VALUE_PICKLES, 1800, SettingCategory.BIN));
        settingDao.save(new Setting(Settings.BIN_VALUE_CUCUMBERS, 3000, SettingCategory.BIN));
        settingDao.save(new Setting(Settings.TRAY_VALUE_6, 100, SettingCategory.BREAD));
        settingDao.save(new Setting(Settings.STICK_VALUE_LJ, 500, SettingCategory.BREAD));
        settingDao.save(new Setting(Settings.LOAF_VALUE_WHEAT, 1000, SettingCategory.BREAD));
        settingDao.save(new Setting(Settings.TOP_DECK_HEAT, 375, SettingCategory.OVEN));
        settingDao.save(new Setting(Settings.DECK_1_HEAT, 375, SettingCategory.OVEN));
        settingDao.save(new Setting(Settings.DECK_2_HEAT, 375, SettingCategory.OVEN));
        settingDao.save(new Setting(Settings.DECK_3_HEAT, 375, SettingCategory.OVEN));
        settingDao.save(new Setting(Settings.DECK_4_HEAT, 375, SettingCategory.OVEN));
        settingDao.save(new Setting(Settings.DECK_5_HEAT, 375, SettingCategory.OVEN));
        settingDao.save(new Setting(Settings.PROOFER_HEAT, 110, SettingCategory.OVEN));
        settingDao.save(new Setting(Settings.PROOFER_HUMIDITY, 75, SettingCategory.OVEN));
        settingDao.save(new Setting(Settings.OPEN_TIME_HR, 10, SettingCategory.TIME));
        settingDao.save(new Setting(Settings.OPEN_TIME_MIN, 0, SettingCategory.TIME));
        settingDao.save(new Setting(Settings.SHIFT_CHANGE_TIME_HR, 15, SettingCategory.TIME));
        settingDao.save(new Setting(Settings.SHIFT_CHANGE_TIME_MIN, 0, SettingCategory.TIME));
        settingDao.save(new Setting(Settings.CLOSE_TIME_HR, 21, SettingCategory.TIME));
        settingDao.save(new Setting(Settings.CLOSE_TIME_MIN, 0, SettingCategory.TIME));
        settingDao.save(new Setting(Settings.PROJECTION_BUFFER, 1.2, SettingCategory.MISC));
        settingDao.save(new Setting(Settings.STORE_NUMBER, 3733, SettingCategory.MISC));
        settingDao.save(new Setting(2022 + Settings.FIRST_DAY_OF_YEAR, 5, SettingCategory.MISC));
        settingDao.save(new Setting(2023 + Settings.FIRST_DAY_OF_YEAR, 4, SettingCategory.MISC));

        staffDao.save(new Employee("John", "Smith", StaffType.Inshop));
        staffDao.save(new Employee("Jimmy", "Bobby", StaffType.Inshop));
        staffDao.save(new Employee("Sarah", "Tough", StaffType.Inshop));
        staffDao.save(new Employee("Bob", "Brown", StaffType.Inshop));
        staffDao.save(new Employee("Kelly", "Bedder", StaffType.Driver));
        staffDao.save(new Employee("Ashley", "Port", StaffType.Manager));

        for (int ii = 0; ii > -105; ii--) {
            daySalesDao.save(new DaySales(LocalDate.now().plusDays(ii), 1200 + (400 * Math.random()), 0, 0, 800 + (400 * Math.random()), 0, 0));
        }

        for (int ii = 0; ii > -8; ii--) {
            LocalDate date = LocalDate.now().plusDays(ii);
            CateringOrder order = new CateringOrder(LocalDate.now().plusDays(ii), 10, 0, 231);
            order.addCateringItem(new CateringItem(CateringType.Mini_12, 2));
            order.addCateringItem(new CateringItem(CateringType.Party_18, 4));
            cateringDao.save(order);
            DaySales ds = daySalesDao.getDaySales(date);
            ds.addCatering(true, order.getDollarValue());

            CateringOrder order2 = new CateringOrder(LocalDate.now().plusDays(ii), 11, 30, 655);
            order2.addCateringItem(new CateringItem(CateringType.Party_30, 2));
            order2.addCateringItem(new CateringItem(CateringType.Box_Lunch, 50));
            cateringDao.save(order2);
            ds.addCatering(true, order2.getDollarValue());
            daySalesDao.save(ds);
        }
        prepDao.save(new PrepTemplate("Lettuce", "bin", 500, PrepType.VEG, 2, true, true));
        prepDao.save(new PrepTemplate("Tomatoes", "bin", 1200, PrepType.VEG, 2, true, true));
        prepDao.save(new PrepTemplate("Onions", "bin", 1600, PrepType.VEG, 2, true, true));
        prepDao.save(new PrepTemplate("Cucumbers", "bin", 3000, PrepType.VEG, 2, true, true));
        prepDao.save(new PrepTemplate("Pickles", "bin", 1500, PrepType.VEG, 2, true, true));
        prepDao.save(new PrepTemplate("Cheese", "pack", 478, PrepType.SLICING, 4, true, true));
        prepDao.save(new PrepTemplate("Ham", "pack", 573, PrepType.SLICING, 4, true, true));
        prepDao.save(new PrepTemplate("Turkey", "pack", 555, PrepType.SLICING, 4, true, true));
        prepDao.save(new PrepTemplate("Beef", "pack", 633, PrepType.SLICING, 4, true, true));
        prepDao.save(new PrepTemplate("Vito", "pack", 544, PrepType.SLICING, 4, true, true));
        prepDao.save(new PrepTemplate("Tuna", "batch", 2000, PrepType.MISC, 4, true, true));
        prepDao.save(new PrepTemplate("Sauce", "bottle", 700, PrepType.MISC, 2, true, true));

        //Daily Stuff
        for (int ii = 0; ii < 7; ii++) {
            LocalDate date = LocalDate.now().plusDays(ii);
            prepDao.save(new PrepItem("Thousand Island Sauce", "bottle", PrepType.LTO, date, 3, 500));
            prepDao.save(new PrepItem("Hot Peppers", "bin", PrepType.MISC, date, 3, 1500));

            cashItemDao.save(new CashItem(date, 155.00, 150.00, 600.00, staffDao.getAllEmployees().get(0)));
            cashItemDao.save(new CashItem(date, 150.00, 150.00, 600.00, staffDao.getAllEmployees().get(1)));
            cashItemDao.save(new CashItem(date, 150.00, 150.00, 600.00, staffDao.getAllEmployees().get(2)));

            commentDao.save(new Comment(date, "Clean Bathrooms", Comment.PRAISE));
            commentDao.save(new Comment(date, "Chips and Paper Goods Stocked", Comment.PRAISE));
            commentDao.save(new Comment(date, "Slicing", Comment.PRAISE));
            commentDao.save(new Comment(date, "Paperwork holes. Lol", Comment.REDIRECT));
            commentDao.save(new Comment(date, "Dusty Register", Comment.REDIRECT));
            commentDao.save(new Comment(date, "Dining Room Tables", Comment.REDIRECT));
            commentDao.save(new Comment(date, "Don't forget to enter payroll ID for Alicia", Comment.NOTE));
            commentDao.save(new Comment(date, "Circus today down the road. Might need more bread.", Comment.NOTE));
        }

		/*prepDao.save(new PrepItem("Lettuce", "bin", PrepType.VEG, LocalDate.now(), 7, 500));
		prepDao.save(new PrepItem("Tomatoes", "bin", PrepType.VEG, LocalDate.now(), 3, 1200));
		prepDao.save(new PrepItem("Onions", "bin", PrepType.VEG, LocalDate.now(), 2, 1600));
		prepDao.save(new PrepItem("Cucumbers", "bin", PrepType.VEG, LocalDate.now(), 2, 1500));
		prepDao.save(new PrepItem("Pickles", "bin", PrepType.VEG, LocalDate.now(), 1, 3000));*/
        /*for (int ii = 0; ii < 20; ii++) {
            LocalDate date = LocalDate.now().plusDays(ii);
            taskDao.save(new TaskItem("open_1", TaskCategory.Open, "Open " + ii, "Loooooooooooooooooooooooooooooooooooooooooooooong", 04, 00, 10, 00, date));
            taskDao.save(new TaskItem("open_3", TaskCategory.Open, "Open 2", "Loooooooooooooooooooooooooooooooooooooooong", 04, 00, 10, 00, date));
            taskDao.save(new TaskItem("open_4", TaskCategory.Open, "Open 3", "Looooooooooooooooooooooooooooooooooooooooooooooong", 04, 00, 10, 00, date));
            taskDao.save(new TaskItem("open_5", TaskCategory.ALCU, "ALCU " + ii, "Looooooooooooooooooooooooooooooooooooong", 13, 00, 15, 00, date));
            taskDao.save(new TaskItem("open_6", TaskCategory.ALCU, "ALCU 2", "Loooooooooooooooooooooooooooooooooooong", 13, 00, 15, 00, date));
            taskDao.save(new TaskItem("open_7", TaskCategory.ALCU, "ALCU 2", "Loooooooooooooooooooooooooooooooooooong", 13, 00, 15, 00, date));
            taskDao.save(new TaskItem("open_8a", TaskCategory.ALCU, "ALCU 2", "Loooooooooooooooooooooooooooooooooooong", 13, 00, 15, 00, date));
            taskDao.save(new TaskItem("open_9", TaskCategory.ALCU, "ALCU 2", "Loooooooooooooooooooooooooooooooooooong", 13, 00, 15, 00, date));
            taskDao.save(new TaskItem("open_10", TaskCategory.ALCU, "ALCU 2", "Loooooooooooooooooooooooooooooooooooong", 13, 00, 15, 00, date));
            taskDao.save(new TaskItem("open_11", TaskCategory.ALCU, "ALCU 2", "Loooooooooooooooooooooooooooooooooooong", 13, 00, 15, 00, date));
            taskDao.save(new TaskItem("open_12", TaskCategory.ALCU, "ALCU 2", "Loooooooooooooooooooooooooooooooooooong", 13, 00, 15, 00, date));
            taskDao.save(new TaskItem("open_13", TaskCategory.ALCU, "ALCU 2", "Loooooooooooooooooooooooooooooooooooong", 13, 00, 15, 00, date));
        }

        for (TaskItem allTaskItem : taskDao.getAllTaskItems()) {
            allTaskItem.setActive(true);
            taskDao.save(allTaskItem);
        }*/
    }

    private void readDatabaseBackup(int month, int day, int year, int hour, int minute) {
        try {
            BackupReader backupReader = new BackupReader(serverBackupFolder);
            Backup backup = backupReader.getBackupFromFileSystem(LocalDateTime.of(year, month, day, hour, minute));
            System.out.println(backup.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveDatabase() {
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
