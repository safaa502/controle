package ma.projet.elharras.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.elharras.examen.entities.Employe;
import java.util.List;




public interface EmployeRepository extends JpaRepository<Employe,Long> {
 List<Employe> findByChef(Employe chef);
}
