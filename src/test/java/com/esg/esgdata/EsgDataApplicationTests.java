package com.esg.esgdata;

import com.esg.esgdata.model.cash.CashItem;
import com.esg.esgdata.model.cash.CashItemDao;
import com.esg.esgdata.model.catering.CateringDao;
import com.esg.esgdata.model.catering.CateringItem;
import com.esg.esgdata.model.catering.CateringOrder;
import com.esg.esgdata.model.catering.CateringType;
import com.esg.esgdata.model.prep.*;
import com.esg.esgdata.model.setting.Setting;
import com.esg.esgdata.model.setting.SettingDao;
import com.esg.esgdata.model.task.TaskCategory;
import com.esg.esgdata.model.task.TaskDao;
import com.esg.esgdata.model.task.TaskItem;
import com.esg.esgdata.staff.Employee;
import com.esg.esgdata.staff.StaffDao;
import com.esg.esgdata.staff.StaffType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EsgDataApplicationTests {

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
		Setting setting = new Setting();
		setting.setName("Oven_Temp");
		setting.setValue(375);
		settingDao.save(setting);

		Setting setting2 = new Setting();
		setting2.setName("Bread_Tray_Value");
		setting2.setValue(220);
		settingDao.save(setting2);

		Setting setting3 = new Setting();
		setting3.setName("Lettuce_Bin_Value");
		setting3.setValue(600);
		settingDao.save(setting3);

		Setting setting4 = new Setting();
		setting4.setName("Onion_Bin_Value");
		setting4.setValue(1600);
		settingDao.save(setting4);

		Setting setting5 = new Setting();
		setting5.setName("Wheat_Loaf_Value");
		setting5.setValue(1000);
		settingDao.save(setting5);

		staffDao.save(new Employee("John", "Smith", StaffType.Inshop));
		staffDao.save(new Employee("Jimmy", "Bobby", StaffType.Inshop));
		staffDao.save(new Employee("Sarah", "Tough", StaffType.Inshop));
		staffDao.save(new Employee("Bob", "Brown", StaffType.Inshop));
		staffDao.save(new Employee("Kelly", "Bedder", StaffType.Inshop));
		staffDao.save(new Employee("Ashley", "Port", StaffType.Inshop));

		prepDao.save(new PrepTemplate("Lettuce", "bin", 500, PrepType.VEG, 3, true, true));
		prepDao.save(new PrepTemplate("Tomatoes", "bin", 1200, PrepType.VEG, 3, true, true));
		prepDao.save(new PrepTemplate("Onions", "bin", 1600, PrepType.VEG, 2, true, true));
		prepDao.save(new PrepTemplate("Cucumbers", "bin", 3000, PrepType.VEG, 2, true, true));
		prepDao.save(new PrepTemplate("Pickles", "bin", 1500, PrepType.VEG, 2, true, true));
		prepDao.save(new PrepItem("Thousand Island Sauce", "bottle", PrepType.LTO, LocalDate.now(), 3, 500));
		prepDao.save(new PrepItem("Hot Peppers", "bin", PrepType.VEG, LocalDate.now(), 3, 1500));

		CateringOrder order = new CateringOrder(LocalDate.now(), 10, 0, 231);
		order.addCateringItem(new CateringItem(CateringType.Mini_12, 2));
		order.addCateringItem(new CateringItem(CateringType.Party_18, 4));
		cateringDao.save(order);

		taskDao.save(new TaskItem("o1", TaskCategory.Open, "Short", "Looooooooooooooooooooong", 04, 00, 10, 00, LocalDate.now()));
		taskDao.save(new TaskItem("o2", TaskCategory.Open, "Short", "Looooooooooooooooooooong", 04, 00, 10, 00, LocalDate.now()));
		taskDao.save(new TaskItem("o3", TaskCategory.Open, "Short", "Looooooooooooooooooooong", 04, 00, 10, 00, LocalDate.now()));
		taskDao.save(new TaskItem("alcu1", TaskCategory.ALCU, "Short", "Looooooooooooooooooooong", 13, 00, 15, 00, LocalDate.now()));
		taskDao.save(new TaskItem("alcu2", TaskCategory.ALCU, "Short", "Looooooooooooooooooooong", 13, 00, 15, 00, LocalDate.now()));
		taskDao.save(new TaskItem("adcu1", TaskCategory.ADCU, "Short", "Looooooooooooooooooooong", 18, 30, 22, 00, LocalDate.now()));

		cashItemDao.save(new CashItem(LocalDate.now(), 155.00, 150.00, 600.00, staffDao.getAllEmployees().get(0)));
		cashItemDao.save(new CashItem(LocalDate.now(), 150.00, 150.00, 600.00, staffDao.getAllEmployees().get(1)));
		cashItemDao.save(new CashItem(LocalDate.now(), 150.00, 150.00, 600.00, staffDao.getAllEmployees().get(2)));

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
	void addCateringOrder()
	{
		CateringOrder order = new CateringOrder(LocalDate.now(), 10, 0, 231);
		order.addCateringItem(new CateringItem(CateringType.Mini_12, 2));
		order.addCateringItem(new CateringItem(CateringType.Party_18, 4));
		cateringDao.save(order);
	}

	@Test
	void addCateringItem()
	{
		cateringDao.save(new CateringItem(CateringType.Mini_12, 2));
	}

	@Test
	void addTaskItem() {
		/*TaskItem taskItem = taskDao.getTaskItem(9);
		System.out.println(taskItem);
		taskItem.complete(new Employee("Jim", "Bob", StaffType.Inshop));
		taskDao.save(taskItem);*/
	}

	@Test
	void addCashItem() {
		Employee employee = staffDao.getEmployeeById(10);
		CashItem cashItem = new CashItem(LocalDate.now(), 155.00, 150.00, 600.00, employee);
		cashItemDao.save(cashItem);
	}

/*	@Test
	void addDayData() {
		DayData dayData = new DayData(LocalDate.of(2022, Month.NOVEMBER, 30));
		Employee employee = new Employee("Jim", "Bob", StaffType.Inshop);
		dayData.addCashItem(new CashItem(LocalDate.now(), 150.00, 150.00, 600.00, employee));
		CateringOrder order = new CateringOrder(10, 0, 231);
		order.addCateringItem(new CateringItem(CateringType.Mini_12, 2));
		order.addCateringItem(new CateringItem(CateringType.Party_18, 4));
		dayData.addPrepItem(new PrepItem("Desc", "bin", PrepType.LTO, dayData.getDate(), 3, 500));
		dayData.addTask(new TaskItem("sl122", TaskCategory.ALCU, "Short", "Looooong", 17, 00, 20, 00, dayData.getDate()));
		dayData.addCateringOrder(order);
		dayData.addPraise("Praise");
		dayData.addRedirect("Redirect");
		dayData.addNote("Note");
		dayDataDao.save(dayData);
	}*/
/*
	@Test
	void getDayData() {
		List<DayData> templates = dayDataDao.getAllDayData();
		for (DayData template : templates) {
			System.out.println(template.toString());
		}
	}

	@Test
	void clearAllTables() {
		dayDataDao.delete(LocalDate.of(2022, Month.NOVEMBER, 30));
	}*/
}
