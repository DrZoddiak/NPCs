package me.mrdaniel.npcs.catalogtypes.options.types;

import java.util.Optional;

import org.spongepowered.api.data.type.HorseVariant;

import me.mrdaniel.npcs.catalogtypes.options.OptionType;
import me.mrdaniel.npcs.interfaces.mixin.NPCAble;
import me.mrdaniel.npcs.io.NPCFile;
import net.minecraft.entity.passive.EntityHorse;

public class OptionHorseVariant extends OptionType<HorseVariant> {

	public OptionHorseVariant() {
		super("HorseVariant", "horsevariant");
	}

	@Override
	public boolean isSupported(final NPCAble npc) {
		return npc instanceof EntityHorse;
	}

	@Override
	public void writeToNPC(final NPCAble npc, final HorseVariant value) {
		npc.setNPCHorseVariant(value);
	}

	@Override
	public void writeToFile(final NPCFile file, final HorseVariant value) {
		file.setHorseVariant(value);
	}

	@Override
	public Optional<HorseVariant> readFromFile(final NPCFile file) {
		return file.getHorseVariant();
	}
}