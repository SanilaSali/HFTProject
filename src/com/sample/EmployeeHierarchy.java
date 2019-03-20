package com.sample;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeHierarchy {

	public static void main(String[] args) throws IOException {
		
		//Create an employeeList with all employees 
		List<String> employeeList = new ArrayList<>();
		employeeList.add("A");
		employeeList.add("B");
		employeeList.add("C");
		employeeList.add("D");
		employeeList.add("E");
		employeeList.add("F");
		employeeList.add("G");
		employeeList.add("H");
		
		//Create a HashMap to map employees with managers
		Map<String, String> empManager = new HashMap<String, String>();
		empManager.put("B", "A");
		empManager.put("C", "A");
		empManager.put("E", "D");
		empManager.put("F", "D");
		empManager.put("G", "D");
		
		//Create a HashMap to map managers with CEO
		Map<String, String> managerCEO = new HashMap<String, String>();
		managerCEO.put("A", "H");
		managerCEO.put("D", "H");
		
		String CEO = "H";
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\nCompany Employees are "+employeeList);
		System.out.println("\nEmployee Hierarchy ");
		System.out.println(" 	 H ");
		System.out.println("\t"+"/" + "  \\ \t\t");
		System.out.println("       A  "+"  D");
		System.out.println("      / " + "\\" +"  /|\\");
		System.out.println("     B  C E F G");
		
		while(true){
			
			System.out.print("\nEnter Employee name :");
			String employee = br.readLine();
					
			boolean valid = employeeList.contains(employee);
			
			if(valid){
				
				String manager = null;
												
				for (Map.Entry<String, String> entry : empManager.entrySet()) {
					if(employee!=null && employee.equals(entry.getKey())){
						System.out.println(entry.getKey()+ " is an Employee" );
						System.out.println("Manager : "  + entry.getValue());
						manager = entry.getValue();
						break;
					}
				}
			
				if( manager == null && !employee.equals(CEO)){
					manager = employee;
					System.out.println(manager + " is a Manager " );
				}
			
				for (Map.Entry<String, String> entry : managerCEO.entrySet()) {
					if(manager!=null && manager.equals(entry.getKey())){
						System.out.println("CEO : "  + entry.getValue());
						break;
					}
				}
				
				if(employee.equals(CEO))
					System.out.println(employee  +" is the CEO " );
			}
			
			else
				System.out.println("Invalid entry " );
		}
		
			
	}
}
