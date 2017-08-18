package me.mrdaniel.npcs.catalogtypes.options.types;

import java.util.Optional;

import org.spongepowered.api.data.type.SkeletonType;

import me.mrdaniel.npcs.catalogtypes.options.OptionType;
import me.mrdaniel.npcs.interfaces.mixin.NPCAble;
import me.mrdaniel.npcs.io.NPCFile;
import net.minecraft.entity.monster.EntitySkeleton;

public class OptionSkeletonType extends OptionType<SkeletonType> {

	public OptionSkeletonType() {
		super("SkeletonType", "skeletontype");
	}

	@Override
	public boolean isSupported(final NPCAble npc) {
		return npc instanceof EntitySkeleton;
	}

	@Override
	public void writeToNPC(final NPCAble npc, final SkeletonType value) {
		npc.setNPCSkeletonType(value);
	}

	@Override
	public void writeToFile(final NPCFile file, final SkeletonType value) {
		file.setSkeletonType(value);
	}

	@Override
	public Optional<SkeletonType> readFromFile(final NPCFile file) {
		return file.getSkeletonType();
	}
}