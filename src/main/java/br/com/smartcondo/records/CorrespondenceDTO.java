package br.com.smartcondo.records;

import br.com.smartcondo.models.Correspondence;
import br.com.smartcondo.models.Resident;

public record CorrespondenceDTO(Correspondence correspondence, Resident resident) {
}
