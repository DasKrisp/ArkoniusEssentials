/*
 * Copyright (c) 2022 DasKrisp
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this file,
 * You can obtain one at: https://www.gnu.org/licenses/
 */

package de.krisp.arkoessentials;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArkoEssentials implements ModInitializer {


	public static final MinecraftClient MC = MinecraftClient.getInstance();
	public static final String MOD_ID = "ArkoniusEssentails";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ArkoEssentials INSTANCE = new ArkoEssentials();
	public static final double MOD_VERSION = 0.1;

	@Override
	public void onInitialize() {
		LOGGER.info("-----");
		LOGGER.info("Intialized " + MOD_ID + " V"  + MOD_VERSION + " by Krisp");
		LOGGER.info("-----");

		// mixins are registered in mixins.json!
	}
}
