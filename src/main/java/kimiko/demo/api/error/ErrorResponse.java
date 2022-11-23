package kimiko.demo.api.error;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter

public class ErrorResponse {
    private Integer status;
    private Object errors;
}
