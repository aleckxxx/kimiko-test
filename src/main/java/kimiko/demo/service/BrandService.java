package kimiko.demo.service;

import kimiko.demo.entity.Brand;
import kimiko.demo.exception.BrandNotFoundException;
import kimiko.demo.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand findById(int id) throws BrandNotFoundException {
        Brand brand = brandRepository.findById(id);
        if(brand==null){
            throw new BrandNotFoundException(id);
        }
        return brand;
    }
}
