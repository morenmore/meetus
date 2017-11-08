package com.meet.together.holist.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.meet.together.holist.dto.ImageFile;
import com.meet.together.holist.dto.ListInfo;
import com.meet.together.holist.dto.Place;
import com.meet.together.holist.dto.TakeUserInfo;
import com.meet.together.holist.service.HoService;
import com.meet.together.houser.dto.UserInfo;

@Controller
public class HoController {
	@Autowired
	HoService ls;
 
	//메인화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainsite() {
		return "main";
	}
	//이미지 
	@RequestMapping(value="/image1", method=RequestMethod.POST)
	public String hangoutImage(@RequestParam MultipartFile imageFile, ModelMap modelMap) {
		ImageFile fileInfo = ls.imageSave(imageFile);
		
		modelMap.put("imageFile", fileInfo);
		
		return "uploadComplete";
	}

	@RequestMapping(value="/image", method=RequestMethod.POST)
    public @ResponseBody ModelMap handleFileUpload(@RequestParam("file") MultipartFile file,ModelMap modelMap) {
        try {
    		ImageFile fileInfo = ls.imageSave(file);
    		modelMap.put("fileName", fileInfo.getFileName());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("error",e);
            //return ResponseEntity.badRequest().build();
        }
		return modelMap;
    }
	@RequestMapping(value = "/hangout/insert", method = RequestMethod.POST)
	public @ResponseBody ModelMap insertListInfo(@RequestBody ListInfo li, ModelMap hm) {
		int result = ls.insertListInfo(li);
		if (result == 1) {
			hm.put("msg", "모임생성이 완료되었습니다.");
			hm.put("url", "");
		} else {
			hm.put("msg", "모임생성 실패, 정보를 확인하세요");
			hm.put("url", "hangout/create");
		}
		return hm;
	}

	@RequestMapping(value = "/hangout/create", method = RequestMethod.GET)
	public String createsite(UserInfo ui) {
		return "hangout/create";
	}

	@RequestMapping(value = "/hangout/update", method = RequestMethod.GET)
	public String updatesite(UserInfo ui) {
		return "hangout/update";
	}

	@RequestMapping(value = "/hangout/list", method = RequestMethod.POST)
	public @ResponseBody ModelMap selectList(@RequestBody ListInfo li, ModelMap hm) {
		List<ListInfo> list = ls.selectListInfo(li);
		hm.put("list", list);
		return hm;
	}
	@RequestMapping(value = "/place", method = RequestMethod.POST)
	public @ResponseBody Place place(@RequestBody Place pi) {
		int result = ls.insertPlace(pi);
		if(result==1){
			return pi;
		}
		return null;
	}
	@RequestMapping(value = "/hangout/takeuser/check", method = RequestMethod.POST)
	public @ResponseBody ModelMap selectTakeUserList(@RequestBody TakeUserInfo tu, ModelMap hm) {
		TakeUserInfo list = ls.selectTakeUserList(tu);
		hm.put("list", list);
		return hm;
	}
	
	@RequestMapping(value = "/hangout/takeuser/list", method = RequestMethod.POST)
	public @ResponseBody ModelMap selectHangoutUserList(@RequestBody TakeUserInfo tu, ModelMap hm) {
		List<UserInfo> list = ls.selectHangoutUserList(tu);
		hm.put("list", list);
		return hm;
	}

	@RequestMapping(value = "/hangout/golist", method = RequestMethod.GET)
	public String listsite() {
		return "hangout/list";
	}
	
	@RequestMapping(value = "/hangout/drop", method = RequestMethod.GET)
	public String dropzonetest() {
		return "test/dropzonetest";
	}
	@RequestMapping(value = "/hangout/airmode", method = RequestMethod.GET)
	public String airmodetest() {
		return "test/airmode";
	}
	@RequestMapping(value = "/hangout/mylist", method = RequestMethod.GET)
	public String myListSite(UserInfo ui) {
		return "hangout/myholist";
	}
	
	@RequestMapping(value = "/hangout/partimylist", method = RequestMethod.GET)
	public String myParticipateSite(UserInfo ui) {
		return "hangout/myparlist";
	}
 
	   @RequestMapping(value = "/hangout", method = RequestMethod.GET)
	   public String listsiteinfo(ListInfo li,ModelMap model) {
		  HashMap<String, Object> hm = ls.selectListContent(li);
	      model.addAttribute("ListInfo", hm );
	      return "hangout/hangout";
	   }
	   
		@RequestMapping(value = "/hangout/takeuser/insert", method = RequestMethod.POST)
		public @ResponseBody ModelMap TakeUserCount(@RequestBody TakeUserInfo tu, ModelMap hm) {
			int result = ls.TakeUserCount(tu);
			if (result == 1) {
				hm.put("msg", "참가신청이 완료되었습니다.");
				hm.put("url", "hangout");
			} else {
				hm.put("msg", "참가신청 실패, 정보를 확인하세요");
				hm.put("url", "hangout");
			}
			return hm;
		}
		
		@RequestMapping(value = "/hangout/takeuser/participate", method = RequestMethod.POST)
		public @ResponseBody ModelMap selectParticipateUserList(@RequestBody TakeUserInfo tu, ModelMap hm) {
			List<ListInfo> list = ls.selectParticipateUserList(tu);
			hm.put("list", list);
			return hm;
		}
}