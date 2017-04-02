package me.mrdaniel.npcs.commands.action;

import java.util.Optional;

import javax.annotation.Nonnull;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;

import com.google.common.collect.Lists;

import me.mrdaniel.npcs.NPCs;
import me.mrdaniel.npcs.commands.NPCCommand;
import me.mrdaniel.npcs.data.action.NPCCommandAction;
import me.mrdaniel.npcs.data.npc.NPCData;
import me.mrdaniel.npcs.utils.TextUtils;

public class CommandActionSetCommand extends NPCCommand {

	public CommandActionSetCommand(@Nonnull final NPCs npcs) {
		super(npcs);
	}

	@Override
	public void execute(final Player player, final Living npc, final CommandContext args) throws CommandException {
		NPCData data = npc.get(NPCData.class).get();
		data.setAction(Optional.of(new NPCCommandAction(Lists.newArrayList(args.<String>getOne("command").get()), false, 0)));
		npc.offer(data);

		TextUtils.sendMessage(player, "You successfully set the selected NPC's action to 'command'.");
	}
}