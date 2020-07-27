package com.example.consumingrest;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class CompileController {

  private final String queryURL = "https://api.jdoodle.com/v1/execute/";
  private HashMap<String, String> params = new HashMap<>();

  @Autowired
  private RestTemplate restTemplate;

  @PostConstruct
  public void initJdoodleParams() {
    params.put("clientId", "897ecf21be30faf3b108e047795e8ee3");
    params.put("clientSecret", "a4195f2f8e03cde574d313c70c9708eb9791ebb0789e13d41b7fc430c1b1354");
    params.put("language", "java");
    params.put("versionIndex", "0");
  }

  @RequestMapping(method = RequestMethod.GET, path = "/")
  public String getEditor() {
    return "editor";
  }

  @PostMapping(value = "/compile", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<ExecOutput> compileCode(@RequestBody Code code) {
    //System.out.println(code);
    params.put("script",code.getCode());
    ExecOutput output = restTemplate.postForObject(queryURL, params, ExecOutput.class);
    //System.out.println(output.toString());
    return new ResponseEntity<>(output, HttpStatus.OK);
  }
}
