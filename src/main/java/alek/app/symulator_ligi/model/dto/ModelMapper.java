package alek.app.symulator_ligi.model.dto;

import alek.app.symulator_ligi.model.Player;

public interface ModelMapper {

    static PlayerWithNewContract fromPlayerToPlayerWithContract(Player player) {
        return player == null ? null : PlayerWithNewContract.builder()
                .id(player.getId())
                .date(player.getDate())
                .newDate(player.getDate())
                .pension(player.getPension())
                .newPension(player.getPension())
                .build();
    }
}
