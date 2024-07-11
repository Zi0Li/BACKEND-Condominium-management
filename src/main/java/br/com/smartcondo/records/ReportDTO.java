package br.com.smartcondo.records;

import br.com.smartcondo.models.Report;
import br.com.smartcondo.models.Resident;

public record ReportDTO(Report report, Resident resident) {
}
