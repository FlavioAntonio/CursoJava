package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.enums.WorkerlLevel;

public class Worker {
	
	private String name;
	private WorkerlLevel level;
	private Double baseSAlary;
	
	private Departament department;
	private List<HourContract> contracts = new ArrayList<HourContract>();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerlLevel level, Double baseSAlary, Departament department) {
		this.name = name;
		this.level = level;
		this.baseSAlary = baseSAlary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerlLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerlLevel level) {
		this.level = level;
	}

	public Double getBaseSAlary() {
		return baseSAlary;
	}

	public void setBaseSAlary(Double baseSAlary) {
		this.baseSAlary = baseSAlary;
	}

	public Departament getDepartment() {
		return department;
	}

	public void setDepartment(Departament department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeCotract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSAlary;
		
		for(HourContract c: contracts) {
			LocalDate dataAtual = LocalDate.now();
			
			int c_year = dataAtual.getYear();
			int c_month = dataAtual.getMonthValue();	
			
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
	
}
