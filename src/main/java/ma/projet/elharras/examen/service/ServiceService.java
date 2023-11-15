package ma.projet.elharras.examen.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import ma.projet.elharras.examen.entities.Service;
import ma.projet.elharras.examen.repository.ServiceRepository;


@org.springframework.stereotype.Service
public class ServiceService {

	@Autowired
    private ServiceRepository serviceRepository;

    public List<Service> getAllCities() {
        return serviceRepository.findAll();
    }

    public Service getServiceById(Long id) {
        Optional<Service> Service = serviceRepository.findById(id);
        return Service.orElse(null);
    }

    public Service saveService(Service Service) {
        return serviceRepository.save(Service);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
