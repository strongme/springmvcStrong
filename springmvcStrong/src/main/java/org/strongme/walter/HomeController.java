package org.strongme.walter;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.strongme.walter.imgdata.ContourBean;
import org.strongme.walter.imgdata.DataProcess;
import org.strongme.walter.pojo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
	
/*	@RequestMapping(value = "/contour", method = RequestMethod.GET)
	public String toContour(Model model) {
		return "contour";
	}
	
	@RequestMapping(value="/getUser/{name}/{gender}",method=RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable String name,@PathVariable String gender) {
		User user = new User();
		user.setName(name);
		user.setGender(gender);
		return user;
	}
	
	@RequestMapping(value="/contourByFilename/{filename}",method=RequestMethod.GET)
	public @ResponseBody ContourBean getContourBeanByFileName(@PathVariable String filename) {
		ContourBean result = DataProcess.processFileToContourBean(filename);
		return  result;
	}*/
}
