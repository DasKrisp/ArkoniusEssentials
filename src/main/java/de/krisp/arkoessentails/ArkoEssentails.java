package de.krisp.arkoessentails;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.impl.base.event.EventFactoryImpl;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArkoEssentails implements ModInitializer {


	public static final MinecraftClient MC = MinecraftClient.getInstance();
	public static final String MOD_ID = "ArkoniusEssentails";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ArkoEssentails INSTANCE = new ArkoEssentails();
	public static final double MOD_VERSION = 0.1;

	@Override
	public void onInitialize() {
		LOGGER.info("-----");
		LOGGER.info("Intialized " + MOD_ID + " V"  + MOD_VERSION + " by Krisp");
		LOGGER.info("-----");

		// mixins are registered in mixins.json!
	}
}
