package br.com.smartcondo.records;

import br.com.smartcondo.models.Condominium;
import br.com.smartcondo.models.Employees;

public record EmployeeAllDetailsDTO(Employees employee, Condominium condominium) {
}
