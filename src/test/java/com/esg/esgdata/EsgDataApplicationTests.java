package com.esg.esgdata;

import com.esg.esgdata.model.prep.PrepDao;
import com.esg.esgdata.model.prep.PrepItem;
import com.esg.esgdata.model.prep.PrepTemplate;
import com.esg.esgdata.model.prep.PrepType;
import com.esg.esgdata.model.setting.Setting;
import com.esg.esgdata.model.setting.SettingDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EsgDataApplicationTests {

	@Autowired
	SettingDao settingDao;

	@Autowired
	PrepDao prepDao;

	@Test
	void addSetting()
	{
		Setting setting = new Setting();
		setting.setName("BIN");
		setting.setValue(22.123);
		settingDao.save(setting);
	}

	@Test
	void createTable()
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
		PrepItem prepItem = new PrepItem("Ta", "String sas", 200, 100, PrepType.LTO);
		prepDao.save(prepItem);
	}

	@Test
	void createPrepItemTable()
	{
		ArrayList<PrepItem> items = new ArrayList<>();
		items.add(new PrepItem("Vito", "pack", 9, 555, PrepType.SLICING));
		items.add(new PrepItem("Thousand Island Sauce", "bottle", 3, 1000, PrepType.LTO));
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
			prepDao.delete(item.getDescription());
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
			prepDao.delete(template.getDescription());
		}
	}
}
