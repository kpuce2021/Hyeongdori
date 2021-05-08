package org.kpu.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JythonTest {

	private static final Logger logger = LoggerFactory.getLogger(JythonTest.class);
	
	@PostMapping(value = "/test")
	public String getTest() throws IOException, InterruptedException {
//		String[] arguments = {"detect.py", "--source", "476.jpg"};
//		Properties p = new Properties();
//		p.setProperty("python.path", "/home/ubuntu/yolov5");
//		
//		PythonInterpreter.initialize(System.getProperties(), p, arguments);
//		
//		PythonInterpreter intPre = new PythonInterpreter();
//		
////		StringWriter out = new StringWriter();
////		intPre.setOut(out);
//		intPre.execfile("/home/ubuntu/yolov5/detect.py");
//		
////		String result = out.toString();
////		System.out.println(result);
//		intPre.close();
		
		
//		@PostMapping("/api")
//	    public String test1() throws IOException, InterruptedException {
//	        Process process = Runtime.getRuntime().exec("python3 /home/ubuntu/yolov5/detect.py --source /var/lib/tomcat9/webapps/upload/202105061557.jpg");
//	        process.waitFor();
//	        process.destroy();
//	        return "json";
//	    }
		
        Process process = Runtime.getRuntime().exec("python3 /home/ubuntu/yolov5/detect.py --source /var/lib/tomcat9/webapps/upload/202105061557.jpg");
        process.waitFor();
        process.destroy();

		
		return "success";
	}
}
