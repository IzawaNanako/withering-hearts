package com.saduwub.withering_hearts;

import com.saduwub.withering_hearts.bridge.BridgeConfig;
import com.saduwub.withering_hearts.bridge.BridgeEventHandler;
import com.saduwub.withering_hearts.bridge.BridgeWebSocketClient;
import net.fabricmc.api.DedicatedServerModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WitheringHeartsServer implements DedicatedServerModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("withering-hearts-server");

    @Override
    public void onInitializeServer() {
        LOGGER.info("[Withering Hearts] Initializing Server-Side Features...");

        BridgeConfig config = BridgeConfig.get();

        if (config.enableBridge) {
            LOGGER.info("[Withering Hearts] MC-Discord Bridge is enabled. Will connect to: {}", config.wsUri);
            BridgeWebSocketClient.start();
            BridgeEventHandler.register();
        }
    }
}
