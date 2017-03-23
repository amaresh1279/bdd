package com.hill.william.test.bdd.steps;

import com.hill.william.test.bdd.BonusCalculation;
import com.hill.william.test.bdd.PayDay;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MonthlyBonusStepDefinition {

	BonusCalculation bonusCalculation = new BonusCalculation();

	PayDay payDay = new PayDay();

	boolean bonusGiven = false;

	boolean basePayGiven = false;

	@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {

	}

	@When("^the 15th of the month is \"([^\"]*)\"$")
	public void the_15_of_the_month_is_Weekday(String week_day) throws Throwable {		
		String bonusDay = bonusCalculation.calculateDay(week_day);		
		if (week_day.equalsIgnoreCase(bonusDay)) {
			bonusGiven = true;
		} else {
			bonusGiven = false;
		}
	}

	@Then("^bonus need to be paid on (\\d+)th$")
	public void bonus_need_to_be_paid_on_th(int arg1) throws Throwable {
		if (bonusGiven) {
			System.out.println("Bonus need to be paid on 15th");
		} else {
			throw new Exception("Test Failed");
		}

	}

	@When("^the 15th of the month is \"([^\"]*)\" OR \"([^\"]*)\"$")
	public void the_15_of_the_month_is_OR(String arg2, String arg3) throws Throwable {
		String bonusDay = bonusCalculation.calculateDay(arg2);

		
		if (arg2.equalsIgnoreCase(bonusDay) || arg3.equalsIgnoreCase(bonusDay)) {
			bonusGiven = true;
		} else {
			bonusGiven = false;
		}
	}

	@Then("^bonus need to be paid on first Wednesday after (\\d+)th$")
	public void bonus_need_to_be_paid_on_first_Wednesday_after_th(int arg1) throws Throwable {
		if (bonusGiven) {
			System.out.println("Bonus need to be paid on first Wednesday after 15th");
		} else {
			throw new Exception("Test Failed");
		}
	}

	@When("^the last day of the month is \"([^\"]*)\"$")
	public void the_last_day_of_the_month_is(String last_day_of_month) throws Throwable {
		
		String payingDay = payDay.calculatePayDay(last_day_of_month);
		
		if (last_day_of_month.equalsIgnoreCase(payingDay)) {
			basePayGiven = true;
		} else {
			basePayGiven = false;
		}
	}

	@Then("^base salary need to be paid on last day$")
	public void base_salary_need_to_be_paid_on_last_day() throws Throwable {
		if (basePayGiven) {
			System.out.println("salary need to be paid on last day");
		} else {
			throw new Exception("Test Failed");
		}
	}

	@When("^the last day of the month is \"([^\"]*)\" OR \"([^\"]*)\"$")
	public void the_last_day_of_the_month_is_weekend(String arg1, String arg2) throws Throwable {
		String payingDay = payDay.calculatePayDay(arg1);
		
		if (arg1.equalsIgnoreCase(payingDay) || arg2.equalsIgnoreCase(payingDay)) {
			basePayGiven = true;
		} else {
			basePayGiven = false;
		}
	}

	@Then("^base salary need to be paid on last day before the weekend$")
	public void base_salary_need_to_be_paid_on_last_day_before_the_weekend() throws Throwable {
		if (basePayGiven) {
			System.out.println("salary need to be paid on last day before weekend");
		} else {
			throw new Exception("Test Failed");
		}
	}
	
	
	@When("^the 15th of the month is \"([^\"]*)\" OR \"([^\"]*)\" And \"([^\"]*)\"$")
	public void the_15th_of_the_month_is_OR_And(String arg1, String arg2, String arg3) throws Throwable {
		String bonusDay = bonusCalculation.calculateDay(arg2);
		
		String holiday = bonusCalculation.calculateHoliday();

		
		if (arg2.equalsIgnoreCase(bonusDay) || arg3.equalsIgnoreCase(bonusDay) && arg3.equalsIgnoreCase(holiday)) {
			bonusGiven = true;
		} else {
			bonusGiven = false;
		}
	}

	@Then("^bonus need to be paid on first Thursday after (\\d+)th$")
	public void bonus_need_to_be_paid_on_first_Thursday_after_th(int arg1) throws Throwable {
		if (bonusGiven) {
			System.out.println("Bonus need to be paid on first Thursday after 15th");
		} else {
			throw new Exception("Test Failed");
		}
	}
	
	
	
	
	
}