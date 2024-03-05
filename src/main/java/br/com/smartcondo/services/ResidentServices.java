package br.com.smartcondo.services;

import br.com.smartcondo.models.Resident;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class ResidentServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(ResidentServices.class.getName());

    public List<Resident> findAll() {
        logger.info("Finding all peoples!");

        List<Resident> residents = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Resident resident = mockResident(i);
            residents.add(resident);
        }

        return residents;
    }

    public Resident findById(Long id){
        logger.info("Find one resident!");
        Resident resident = new Resident();
        resident.setId(id);
        resident.setName("Marcelo Zioli");
        resident.setCpf("111.222.333-44");
        resident.setRg("55.666.777-X");
        resident.setPhone("(18) 9 9805-0504");
        resident.setAge(id.intValue());

        return resident;
    }

    public Resident update(Resident resident) {

        logger.info("Updating one resident!");

        return resident;
    }

    public void delete(int id) {

        logger.info("Deleting one resident!");

    }

    public Resident create(Resident resident) {

        logger.info("Creating one resident!");

        return resident;
    }


    private Resident mockResident(int i) {
        Resident resident = new Resident();
        resident.setId(counter.incrementAndGet());
        resident.setName("Resident name" + i);
        resident.setCpf("Cpf" + i);
        resident.setRg("Rg" + i);
        resident.setPhone("Phone" + i);
        resident.setAge(i + 20);
        return resident;
    }
}
