package com.javasmartwork.io.healthcare.controller;

import org.hl7.fhir.dstu3.model.Appointment;
import org.hl7.fhir.dstu3.model.Bundle;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;


@RestController("/claim")
public class ClaimResource {
	
	
	@GetMapping("/subdetail-udi/{Id}")
	public String testHapiController(@PathVariable("Id") String id) {
//		String url="http://hapi.fhir.org/baseR4/Claim";
		String url="http://hapi.fhir.org/baseR4/Claim?subdetail-udi=r&_format=json&_pretty=true";
		RestTemplate restTemplate = new RestTemplate();
//		Bundle bundle=restTemplate.getForObject(url, Bundle.class, id,"json",Boolean.TRUE);
		HttpHeaders header = new HttpHeaders();
		
		header.add(HttpHeaders.ACCEPT,"application/fhir+json;q=1.0, application/json+fhir;q=0.9");
		header.add(HttpHeaders.ACCEPT_CHARSET, "UTF-8");
		header.add(HttpHeaders.USER_AGENT, "HAPI-FHIR/4.1.0-SNAPSHOT (FHIR Client; FHIR 4.0.0/R4; apache)");
		//header.add(HttpHeaders.ACCEPT_ENCODING, "gzip");
		HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(header);
		System.out.println("Url to be posted :::::"+url);
		String bundle2=restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class).getBody();
		System.out.println(bundle2);
		FhirContext ourFhirCtx = FhirContext.forDstu3();
		IParser parser=ourFhirCtx.newJsonParser().setPrettyPrint(true);
		String string="{\"resourceType\":\"Appointment\",\"id\":\"\",\"status\":\"proposed\",\"reason\":{\"text\":\"Regular checkup\"},\"description\":\"\",\"slot\":[{\"reference\":\"bfgf5dfdf4e45g\"}],\"comment\":\"Regular yearly visit\",\"participant\":[{\"actor\":{\"reference\":\"9sdfsndjkfnksdfu3yyugbhjasbd\"},\"required\":\"required\"},{\"actor\":{\"reference\":\"78hjkdfgdfg223vg\"},\"required\":\"required\"},{\"actor\":{\"reference\":\"sdfs3df5sdfdfgdf\"},\"required\":\"required\"}]}";
		Appointment parsed=parser.parseResource(Appointment.class,string);
		Bundle bundle=parser.parseResource(Bundle.class, bundle2);
		System.out.println("Done ::::::::::");
		Bundle bundles=restTemplate.exchange(url, HttpMethod.GET, requestEntity, Bundle.class).getBody();
		ObjectMapper ob=new ObjectMapper();
		String str=null;
		try {
			//str=ob.writerWithDefaultPrettyPrinter().writeValueAsString(bundle);
			//System.out.println(bundle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
