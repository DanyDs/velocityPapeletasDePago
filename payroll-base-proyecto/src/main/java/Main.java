import static spark.Spark.*;

import java.awt.List;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


import org.junit.Rule;

import controller.EmployeeController;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import payrollcasestudy.DatabaseResource;
import payrollcasestudy.boundaries.PayrollDatabase;
import payrollcasestudy.entities.Employee;
import payrollcasestudy.entities.paymentclassifications.PaymentClassification;
import payrollcasestudy.entities.paymentmethods.HoldMethod;
import payrollcasestudy.entities.paymentmethods.PaymentMethod;
import payrollcasestudy.entities.paymentschedule.PaymentSchedule;
import payrollcasestudy.transactions.Transaction;
import payrollcasestudy.transactions.add.AddHourlyEmployeeTransaction;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.TemplateViewRoute;
import updatable.Updatable;
import velocityy.VelocityTemplateEngine;
import views.EmpleadoView;


public class Main {
	
	public static int employeeId;
	public static String mensajee;
	public static String mensajee2="rebe";
	static EmployeeController employeeController;
	static VelocityTemplateEngine velocity;
		
	public static void main(String[] args) {
		
		employeeId = 0;	
		
		
		get("/regi", new TemplateViewRoute() {
			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {
			      return new ModelAndView(new HashMap(), "registrar1.vtl");
			    }
		}, velocity.vel());

		
		
		
        
        
        
    	post("/registrarEmpleado", new Route() {
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return employeeController.createEmployee(request.queryParams("id"), request.queryParams("nombre"), request.queryParams("direccion"));
			}
		});    	     		
	
		
		get("/mostrar", new TemplateViewRoute() {
			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {
				Map<String, Object> map = new HashMap<>();
			    map.put("nombre", employeeController.showEmployee());
			      return new ModelAndView(map, "showEmp.vtl");
			    }
		}, velocity.vel());				
	}	


	
	
	
	
	
	
	
	
}
