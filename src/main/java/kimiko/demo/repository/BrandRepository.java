package kimiko.demo.repository;

import kimiko.demo.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    public Brand findById(int id);
}
