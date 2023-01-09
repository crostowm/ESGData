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
		List<TaskTemplate> templates = reader.readTasks("C:/Users/crost/SpringProjects/ESGData/src/main/resources/templates/tasks.txt");
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
