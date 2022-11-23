package kimiko.demo.dto;

import kimiko.demo.entity.Brand;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {

    private int id;
    @NotEmpty(message="Le modele ne devrait pas être vide.")
    private String model;
    private String picture;
    @Min(value = 1900,message ="Veuillez entrer une annee valide de voiture.")
    private int year;
    @NotEmpty(message="Le prix moyen ne devrait pas être vide.")
    private String averagePrice;
    private int brandId;
    private String brand;
    private List<CommentDto> comments;
}
