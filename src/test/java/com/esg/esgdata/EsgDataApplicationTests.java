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
	void getAllPrepItems()
	{
		List<PrepItem> items = prepDao.getAllPrepItems();
		System.out.println(items.size());
		for (PrepItem item : items) {
			System.out.println(item.toString());
		}
	}
	@Test
	void addPrepTemplate()
	{
		PrepTemplate prepTemplate = new PrepTemplate("Temp", "UT", 100, PrepType.MISC, 3, true, true);
		prepDao.save(prepTemplate);
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
}
