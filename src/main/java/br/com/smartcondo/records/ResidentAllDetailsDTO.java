package br.com.smartcondo.records;

import br.com.smartcondo.models.AuthorizedPersons;
import br.com.smartcondo.models.Resident;
import br.com.smartcondo.models.Vehicle;

import java.util.List;

public record ResidentAllDetailsDTO(Resident resident, List<AuthorizedPersons> authorizedPersonsList, List<Vehicle> vehicleList) {
}
