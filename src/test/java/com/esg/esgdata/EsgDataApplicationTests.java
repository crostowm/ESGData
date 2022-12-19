package com.esg.esgdata;

import com.esg.esgdata.io.Backup;
import com.esg.esgdata.io.BackupReader;
import com.esg.esgdata.io.TaskReader;
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
import com.esg.esgdata.model.setting.SettingDao;
import com.esg.esgdata.model.setting.Settings;
import com.esg.esgdata.model.task.*;
import com.esg.esgdata.staff.Employee;
import com.esg.esgdata.staff.StaffDao;
import com.esg.esgdata.staff.StaffType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EsgDataApplicationTests {

	String serverBackupFolder = "C:/Users/crost/OneDrive/Documents/Jimmy Johns/All Stores/ServerBackup";

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
	@Test
	void addSetting()
	{
		Setting setting = new Setting();
		setting.setName("BIN");
		setting.setValue(22.123);
		settingDao.save(setting);
	}

	@Test
	void createTables()
	{
		settingDao.save(new Setting(Settings.PERC_PM_BREAD_BAKED_AT_SC, .5));
		settingDao.save(new Setting(Settings.PERC_AM_BREAD_BAKED_AT_11, .75));
		settingDao.save(new Setting(Settings.BIN_VALUE_LETTUCE, 500));
		settingDao.save(new Setting(Settings.BIN_VALUE_TOMATOES, 1400));
		settingDao.save(new Setting(Settings.BIN_VALUE_ONIONS, 1600));
		settingDao.save(new Setting(Settings.BIN_VALUE_PICKLES, 1800));
		settingDao.save(new Setting(Settings.BIN_VALUE_CUCUMBERS, 3000));
		settingDao.save(new Setting(Settings.TRAY_VALUE_6, 100));
		settingDao.save(new Setting(Settings.STICK_VALUE_LJ, 500));
		settingDao.save(new Setting(Settings.LOAF_VALUE_WHEAT, 1000));
		settingDao.save(new Setting(Settings.TOP_DECK_HEAT, 375));
		settingDao.save(new Setting(Settings.DECK_1_HEAT, 375));
		settingDao.save(new Setting(Settings.DECK_2_HEAT, 375));
		settingDao.save(new Setting(Settings.DECK_3_HEAT, 375));
		settingDao.save(new Setting(Settings.DECK_4_HEAT, 375));
		settingDao.save(new Setting(Settings.DECK_5_HEAT, 375));
		settingDao.save(new Setting(Settings.PROOFER_HEAT, 110));
		settingDao.save(new Setting(Settings.PROOFER_HUMIDITY, 75));
		settingDao.save(new Setting(Settings.OPEN_TIME_HR, 10));
		settingDao.save(new Setting(Settings.OPEN_TIME_MIN, 0));
		settingDao.save(new Setting(Settings.SHIFT_CHANGE_TIME_HR, 15));
		settingDao.save(new Setting(Settings.SHIFT_CHANGE_TIME_MIN, 0));
		settingDao.save(new Setting(Settings.CLOSE_TIME_HR, 21));
		settingDao.save(new Setting(Settings.CLOSE_TIME_MIN, 0));
		settingDao.save(new Setting(Settings.PROJECTION_BUFFER, 1.2));
		settingDao.save(new Setting(Settings.STORE_NUMBER, 3733));
		settingDao.save(new Setting(2022 + Settings.FIRST_DAY_OF_YEAR, 5));
		settingDao.save(new Setting(2023 + Settings.FIRST_DAY_OF_YEAR, 4));

		staffDao.save(new Employee("John", "Smith", StaffType.Inshop));
		staffDao.save(new Employee("Jimmy", "Bobby", StaffType.Inshop));
		staffDao.save(new Employee("Sarah", "Tough", StaffType.Inshop));
		staffDao.save(new Employee("Bob", "Brown", StaffType.Inshop));
		staffDao.save(new Employee("Kelly", "Bedder", StaffType.Driver));
		staffDao.save(new Employee("Ashley", "Port", StaffType.Manager));

		for(int ii = -1; ii > -105; ii--) {
			daySalesDao.save(new DaySales(LocalDate.now().plusDays(ii), 1200 + (400 * Math.random()), 0, 0, 800 + (400 * Math.random()), 0, 0));
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

		//Daily Stuff
		for(int ii = 0; ii < 7; ii++) {
			LocalDate date = LocalDate.now().plusDays(ii);
			prepDao.save(new PrepItem("Thousand Island Sauce", "bottle", PrepType.LTO, date, 3, 500));
			prepDao.save(new PrepItem("Hot Peppers", "bin", PrepType.MISC, date, 3, 1500));

			CateringOrder order = new CateringOrder(date, 10, 0, 231);
			order.addCateringItem(new CateringItem(CateringType.Mini_12, 2));
			order.addCateringItem(new CateringItem(CateringType.Party_18, 4));
			cateringDao.save(order);

			CateringOrder order2 = new CateringOrder(date, 11, 30, 655);
			order2.addCateringItem(new CateringItem(CateringType.Party_30, 2));
			order2.addCateringItem(new CateringItem(CateringType.Box_Lunch, 50));
			cateringDao.save(order2);

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
		prepDao.save(new PrepItem("Pickles", "bin", PrepType.VEG, LocalDate.now(), 1, 3000));*//*
		*//*for (int ii = 0; ii < 20; ii++) {
			taskDao.save(new TaskItem("o" + ii, TaskCategory.Open, "Open " + ii, "Loooooooooooooooooooooooooooooooooooooooooooooong", 04, 00, 10, 00, date));
			*//**//*taskDao.save(new TaskItem("o2", TaskCategory.Open, "Open 2", "Looooooooooooooooooooooooooooooooooooooooooooooong", 04, 00, 10, 00, date));
			taskDao.save(new TaskItem("o3", TaskCategory.Open, "Open 3", "Loooooooooooooooooooooooooooooooooooooooong", 04, 00, 10, 00, date));*//**//*
			taskDao.save(new TaskItem("alcu" + ii, TaskCategory.ALCU, "ALCU " + ii, "Looooooooooooooooooooooooooooooooooooong", 13, 00, 15, 00, date));
			//taskDao.save(new TaskItem("alcu2", TaskCategory.ALCU, "ALCU 2", "Loooooooooooooooooooooooooooooooooooong", 13, 00, 15, 00, date));
			taskDao.save(new TaskItem("adcu" + ii, TaskCategory.ADCU, "ADCU " + ii, "Loooooooooooooooooooooooooooooooooooooong", 18, 30, 22, 00, date));
		}*//*

		*//*for (TaskItem allTaskItem : taskDao.getAllTaskItems()) {
			allTaskItem.setActive(true);
			taskDao.save(allTaskItem);
		}*/
	}
	@Test
	void getAllSettings()
	{
		List<Setting> settings = settingDao.getAllSettings();
		for (Setting setting : settings) {
			System.out.println(setting);
		}
	}

	@Test
	void deleteSetting()
	{
		settingDao.delete("");
	}

	@Test
	void getAllSettingsAndDeleteThem()
	{
		List<Setting> settings = settingDao.getAllSettings();
		for (Setting setting : settings) {
			settingDao.delete(setting.getName());
		}
	}

	@Test
	void addPrepItem()
	{
		PrepItem prepItem = new PrepItem("Ta", "String sas", PrepType.LTO, LocalDate.of(2022, Month.NOVEMBER, 30), 200, 100);
		prepDao.save(prepItem);
	}

	@Test
	void createPrepItemTable()
	{
		ArrayList<PrepItem> items = new ArrayList<>();
		items.add(new PrepItem("Vito", "pack", PrepType.SLICING, LocalDate.of(2022, Month.NOVEMBER, 30), 9, 555));
		items.add(new PrepItem("Thousand Island Sauce", "bottle", PrepType.LTO, LocalDate.of(2022, Month.NOVEMBER, 30), 3, 1000));
		for (PrepItem item : items) {
			prepDao.save(item);
		}
	}

	@Test
	void getAllPrepItems()
	{
		List<PrepItem> items = prepDao.getAllPrepItems();
		System.out.println(items.size());
		for (PrepItem item : items) {
			System.out.println(item.toString());
		}
	}

	@Test
	void getAllPrepItemsAndDeleteThem()
	{
		List<PrepItem> items = prepDao.getAllPrepItems();
		for (PrepItem item : items) {
			prepDao.deleteItem(new PrepId(item.getDesc(), item.getDate()));
		}
	}

	@Test
	void addPrepTemplate()
	{
		PrepTemplate prepTemplate = new PrepTemplate("Temp", "UT", 100, PrepType.MISC, 3, true, true);
		prepDao.save(prepTemplate);
	}

	@Test
	void createPrepTemplateTable()
	{
		ArrayList<PrepTemplate> templates = new ArrayList<>();
		templates.add(new PrepTemplate("Lettuce", "bin", 500, PrepType.VEG, 3, true, true));
		templates.add(new PrepTemplate("Tomatoes", "bin", 1200, PrepType.VEG, 3, true, true));
		templates.add(new PrepTemplate("Pickles", "bin", 1200, PrepType.VEG, 3, true, true));
		templates.add(new PrepTemplate("Cucumbers", "bin", 3000, PrepType.VEG, 3, true, true));
		templates.add(new PrepTemplate("Onions", "bin", 1600, PrepType.VEG, 3, true, true));
		for (PrepTemplate template : templates) {
			prepDao.save(template);
		}
	}
	@Test
	void getAllPrepTemplates()
	{
		List<PrepTemplate> templates = prepDao.getAllPrepTemplates();
		System.out.println(templates.size());
		for (PrepTemplate template : templates) {
			System.out.println(template.toString());
		}
	}

	@Test
	void getAllPrepTemplatesAndDeleteThem()
	{
		List<PrepTemplate> templates = prepDao.getAllPrepTemplates();
		for (PrepTemplate template : templates) {
			prepDao.deleteTemplate(template.getDesc());
		}
	}

	@Test
	void addCashItem() {
		Employee employee = staffDao.getEmployeeById(10);
		CashItem cashItem = new CashItem(LocalDate.now(), 155.00, 150.00, 600.00, employee);
		cashItemDao.save(cashItem);
	}

	@Test
	void clearAllTables()
	{
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
		for (PrepTemplate allPrepTemplate : prepDao.getAllPrepTemplates()) {
			prepDao.deleteTemplate(allPrepTemplate.getDesc());
		}
		/*for (Setting setting : settingDao.getAllSettings()) {
			settingDao.delete(setting.getName());
		}*/
		for (TaskItem allTaskItem : taskDao.getAllTaskItems()) {
			taskDao.deleteItem(new TaskId(allTaskItem.getTaskCode(), allTaskItem.getDate()));
		}
	}
	//IO -------------------------
	//private LocalDateTime testDate = LocalDateTime.of(1, 1, 1, 1, 1);
	private LocalDateTime testDate = LocalDateTime.now();
	@Test
	void readTasks()
	{
		TaskReader reader = new TaskReader();
		List<TaskTemplate> templates = reader.readTasks("C:/Users/crost/IdeaProjects/DatabaseWriter/src/main/java/res/tasks.txt");
		System.out.println("Templates Size: " + templates.size());
		for (TaskTemplate readTask : templates) {
			System.out.println(readTask.toString());
			taskDao.save(readTask);
		}
	}

	@Test
	void saveDatabase()
	{
		BackupReader backupReader = new BackupReader(serverBackupFolder);
		Backup backup = backupReader.getBackupFromDatabase();
		backup.setDate(testDate);
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

	@Test
	void readDatabaseBackup()
	{
		BackupReader backupReader = new BackupReader(serverBackupFolder);
		Backup backup = backupReader.getBackupFromFileSystem(testDate);
		System.out.println(backup.toString());
	}

	@Test
	void uploadBackup()
	{
		BackupReader backupReader = new BackupReader(serverBackupFolder);
		Backup backup = backupReader.getBackupFromFileSystem(LocalDateTime.of(2022, 12, 19, 10, 17));
		//Backup backup = backupReader.getBackupFromFileSystem(testDate);
		for (CashItem cashItem : backup.getCashItems()) {
			cashItemDao.save(cashItem);
		}
		for (CateringOrder cateringOrder : backup.getCateringOrders()) {
			cateringDao.save(cateringOrder);
		}
		for (Comment comment : backup.getComments()) {
			commentDao.save(comment);
		}
		for (DaySales daySale : backup.getDaySales()) {
			daySalesDao.save(daySale);
		}
		for (Employee employee : backup.getEmployees()) {
			staffDao.save(employee);
		}
		for (ExecutionChart executionChart : backup.getExecutionCharts()) {
			executionDao.save(executionChart);
		}
		for (PrepItem prepItem : backup.getPrepItems()) {
			prepDao.save(prepItem);
		}
		for (PrepTemplate prepTemplate : backup.getPrepTemplates()) {
			prepDao.save(prepTemplate);
		}
		for (Setting setting : backup.getSettings()) {
			settingDao.save(setting);
		}
		for (TaskItem taskItem : backup.getTaskItems()) {
			taskDao.save(taskItem);
		}
		for (TaskTemplate taskTemplate : backup.getTaskTemplates()) {
			taskDao.save(taskTemplate);
		}
	}
}
