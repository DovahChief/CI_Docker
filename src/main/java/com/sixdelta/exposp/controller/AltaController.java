package com.sixdelta.exposp.controller;

import java.util.Map;

import com.sixdelta.exposp.model.ProcedureOutPojo;
import com.sixdelta.exposp.services.ClientCreateSP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sixdelta.exposp.model.Account;

@RestController
public class AltaController {
	@Autowired
	ClientCreateSP procedureCall;
	
	@RequestMapping(value = "/alta",  method = RequestMethod.POST)
	@ResponseBody
	public ProcedureOutPojo alta(@RequestBody Account input) {
		return  procedureCall.execute(input);

	}
	
}