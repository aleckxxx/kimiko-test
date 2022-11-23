package kimiko.demo.exception;

public class BrandNotFoundException extends RuntimeException{
    public BrandNotFoundException(Integer id){
        super("Marque avec id non trouvée:" + id);
    }
}
