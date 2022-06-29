package net.cybercake.cyberapi.server.serverlist;

import net.cybercake.cyberapi.Validators;
import net.cybercake.cyberapi.server.serverlist.managers.MOTDManager;
import net.cybercake.cyberapi.server.serverlist.managers.PlayerListManager;
import net.cybercake.cyberapi.server.serverlist.managers.ProtocolManager;

public class ServerListInfo {

    /**
     * @deprecated Please use {@link ServerListInfo#serverListInfo()} or
     */
    @SuppressWarnings({"all"})
    @Deprecated
    public ServerListInfo() { }

    private static ServerListInfo serverListInfo = null;

    /**
     * Gets an instance of {@link ServerListInfo}
     * @return the {@link ServerListInfo} instance
     * @since 3.1.0
     */
    public static ServerListInfo serverListInfo() {
        Validators.validateProtocolLibHook();
        if(serverListInfo == null) serverListInfo = new ServerListInfo();
        return new ServerListInfo();
    }

    /**
     * Gets an instance of MOTD manager, please use this method instead of instantiating {@link MOTDManager}
     * <br>
     * This class if for managing the MOTD, allowing you to modify it to what you please
     * @return the {@link MOTDManager} instance
     * @since 3.1.0
     */
    public MOTDManager getMOTDManager() {
        return MOTDManager.motdManager();
    }

    /**
     * Gets an instance of Player List manager, please use this method instead of instantiating {@link PlayerListManager}
     * <br>
     * This class is for managing the player list, including player count, max player count, and players online hover
     * @return the {@link PlayerListManager} instance
     * @since 3.1.0
     */
    public PlayerListManager getPlayerListManager() {
        return PlayerListManager.playerListManager();
    }

    /**
     * Gets an instance of Protocol manager, please use this method instead of instantiating {@link ProtocolManager}
     * <br>
     * This class is for managing the protocol number and version name, for example, if a server is outdated, it'll show "Paper 1.18" or something, and you can change that by using this class
     * @return the {@link ProtocolManager} instance
     * @since 3.1.0
     */
    public ProtocolManager getProtocolManager() { return ProtocolManager.protocolManager(); }

}
