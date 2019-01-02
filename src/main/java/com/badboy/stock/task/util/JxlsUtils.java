package com.badboy.stock.task.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jsoup.helper.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.badboy.stock.service.util.mail.MailUtils;
import com.badboy.stock.service.util.mail.ToMail;
import com.badboy.stock.utils.date.DateUtils;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.Configuration;
import net.sf.jxls.transformer.XLSTransformer;

@Component
public class JxlsUtils {
	
	@Autowired
	private MailUtils mailUtils;
	
	@Value("${file.out.data.root}")
	private String outFileRoot;
	
	public static final String out_hopen_file_name = DateUtils.getDate()+"_高开数据.xls";
	public static final String templates_hopen_file_path = "classpath:export/templates/h_open_day.xls";
	
	protected String getHopenDayTemplatesPath() {
		File file = null;
		try {
			file = ResourceUtils.getFile(templates_hopen_file_path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return file.getPath();
	}
	protected String getHopenDayOutPath() {
		String filePath = outFileRoot + File.separator+DateUtils.getDate()+File.separator + out_hopen_file_name;
		File file = new File(filePath);
	    if(!file.getParentFile().exists()){
	    	file.getParentFile().mkdirs();
        }
		return  filePath;
	}
	
	public  void outHopenData (List list) {
		 Map beans = new HashMap();
	     beans.put("li", list);
	     Configuration config =  new Configuration();
	     XLSTransformer transformer = new XLSTransformer( config );
	     transformer.groupCollection( "li.stockNo");
	     try {
			transformer.transformXLS(getHopenDayTemplatesPath(), beans, getHopenDayOutPath());
		} catch (ParsePropertyException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public  void sendMailHopenData () {
		File file = new File(getHopenDayOutPath());
		List<String> list = ToMail.listMail();
		for(String li : list) {
			mailUtils.sendAttachmentsMail(li, out_hopen_file_name, "数据", file);
		}
	}
	
}
