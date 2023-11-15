package ma.projet.elharras.examen.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.elharras.examen.entities.Employe;
import ma.projet.elharras.examen.repository.EmployeRepository;


@Service
public class EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    public List<Employe> getAllCities() {
        return employeRepository.findAll();
    }

    public Employe getEmployeById(Long id) {
        Optional<Employe> Employe = employeRepository.findById(id);
        return Employe.orElse(null);
    }

    public Employe saveEmploye(Employe Employe) {
        return employeRepository.save(Employe);
    }
    public List <Employe> getEmployesByChef(Employe chef){
    	return employeRepository.findByChef(chef);
    }
    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }
}
