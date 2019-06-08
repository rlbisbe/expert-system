package net.rlbisbe.expert;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
class Stage {

    private String status;
    private Stage yes;
    private Stage no;

    boolean isEnd(){
        return yes == null && no == null;
    }
}
