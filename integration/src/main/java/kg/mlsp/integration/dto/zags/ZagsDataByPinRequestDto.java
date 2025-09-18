package kg.mlsp.integration.dto.zags;

import kg.mlsp.integration.dto.BaseRequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZagsDataByPinRequestDto extends BaseRequestDto {
    public String pin;

    public ZagsDataByPinRequestDto(String pin){
        this.pin = pin;
    }
}