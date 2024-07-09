package org.example.splitwise.Controller;



import org.example.splitwise.Dtos.SettleUpGroupRequestDto;
import org.example.splitwise.Dtos.SettleUpGroupResponseDto;
import org.example.splitwise.Dtos.SettleUpRequestDto;
import org.example.splitwise.Dtos.SettleUpResponseDto;
import org.example.splitwise.Service.SettleUpService;
import org.springframework.stereotype.Controller;

@Controller
public class SettleUpController {

    private SettleUpService settleUpService;

    SettleUpController(SettleUpService settleUpService){
        this.settleUpService=settleUpService;
    }

    public SettleUpResponseDto SettleUpUser(SettleUpRequestDto requestDto){
        return null;
    }

    public SettleUpGroupResponseDto SettleUpGroup(SettleUpGroupRequestDto GroupRequestDto){
       return null;
    }
}
