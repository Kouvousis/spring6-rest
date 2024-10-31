package gr.aueb.cf.schoolapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseMessageDTO {
    private String code;
    public String description;

    public ResponseMessageDTO(String code) {
        this.code = code;
        this.description = "";
    }
}
