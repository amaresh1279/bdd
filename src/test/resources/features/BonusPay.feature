#Author: Amaresh
@tag
Feature: Monthly bonus
  As a payroll accountant
  I want to get a report of the dates when the bonuses need to be paid

  Scenario Outline: The 15th of the month is not a weekend
    When the 15th of the month is <day>
    Then bonus need to be paid on 15th

    Examples: 
      | day         |
      | "Monday"    |
      | "Tuesday"   |
      | "Wednesday" |
      | "Thursday"  |
      | "Friday"    |

  Scenario Outline: The 15th of the month is a weekend
    When the 15th of the month is <day1> OR <day2>
    Then bonus need to be paid on first Wednesday after 15th

    Examples: 
      | day1       | day2       |
      | "Saturday" | "Sunday"   |
      | "Sunday"   | "Saturday" |

  Scenario Outline: The 15th of the month is a weekend And first Wednesday is holiday
    When the 15th of the month is <day1> OR <day2> And <day3>
    Then bonus need to be paid on first Thursday after 15th

    Examples: 
      | day1       | day2       | day3      |
      | "Saturday" | "Sunday"   | "Holiday" |
      | "Sunday"   | "Saturday" | "Holiday" |

  Scenario Outline: Last day of the month is not a weekend
    When the last day of the month is <day>
    Then base salary need to be paid on last day

    Examples: 
      | day         |
      | "Monday"    |
      | "Tuesday"   |
      | "Wednesday" |
      | "Thursday"  |
      | "Friday"    |

  Scenario Outline: Last day of the month is a weekend
    When the last day of the month is <day1> OR <day2>
    Then base salary need to be paid on last day before the weekend

    Examples: 
      | day1       | day2       |
      | "Saturday" | "Sunday"   |
      | "Sunday"   | "Saturday" |
